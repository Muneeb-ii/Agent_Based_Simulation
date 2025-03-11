/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: This class creates a GUI for the simulation.
 */

 import javax.swing.*;
 import javax.swing.event.ChangeEvent;
 import javax.swing.event.ChangeListener;
 import java.awt.*;
 import java.awt.event.*;
 import java.util.Random;
 
 public class AgentSimulationGUI extends JFrame {
 
     private Landscape scape;
     private LandscapeDisplayGUI display;
     private Timer timer;
     
     // Fields for tracking simulation information
     private int iterationCount = 0;
     private int maxIterations;
     private JLabel iterationLabel;
     private JLabel socialLabel;
     private JLabel antisocialLabel;
     private JLabel movedLabel;
 
     /**
      * Constructor that sets up the GUI.
      */
     public AgentSimulationGUI() {
         // Prompt the user for simulation parameters using input dialogs.
         int height = Integer.parseInt(JOptionPane.showInputDialog(this, 
                 "Please enter the height of the simulation landscape:", 
                 "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
         int width = Integer.parseInt(JOptionPane.showInputDialog(this, 
                 "Please enter the width of the simulation landscape:", 
                 "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
         int numberOfSA = Integer.parseInt(JOptionPane.showInputDialog(this, 
                 "Please enter the initial number of Social Agents:", 
                 "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
         int numberOfASA = Integer.parseInt(JOptionPane.showInputDialog(this, 
                 "Please enter the initial number of Anti-Social Agents:", 
                 "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
         int radiusOfAgent = Integer.parseInt(JOptionPane.showInputDialog(this, 
                 "Please enter the interaction radius for each agent:", 
                 "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
         maxIterations = Integer.parseInt(JOptionPane.showInputDialog(this, 
                 "Please enter the maximum number of iterations for the simulation (it will stop if no agents move or this limit is reached):", 
                 "Simulation Parameters", JOptionPane.QUESTION_MESSAGE));
         
         // Create the Landscape and its display using the user-provided parameters.
         scape = new Landscape(width, height);
         display = new LandscapeDisplayGUI(scape); // This version returns the canvas without creating its own window.
         
         // Add the Social Agents to the landscape.
         Random rand = new Random();
         for (int i = 0; i < numberOfSA; i++) {
             SocialAgent a = new SocialAgent(rand.nextDouble() * scape.getHeight(), 
                                             rand.nextDouble() * scape.getWidth(), 
                                             radiusOfAgent);
             scape.addAgent(a);
         }
         // Add the Anti-Social Agents to the landscape.
         for (int i = 0; i < numberOfASA; i++) {
             AntiSocialAgent a = new AntiSocialAgent(rand.nextDouble() * scape.getHeight(), 
                                                      rand.nextDouble() * scape.getWidth(), 
                                                      radiusOfAgent);
             scape.addAgent(a);
         }
  
         // Set up the main frame.
         setTitle("Agent Based Simulation");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setLayout(new BorderLayout());
  
         // Create a panel for displaying simulation information.
         JPanel infoPanel = new JPanel(new FlowLayout());
         iterationLabel = new JLabel("Iterations: 0");
         socialLabel = new JLabel("Social Agents: " + numberOfSA);
         antisocialLabel = new JLabel("Anti-Social Agents: " + numberOfASA);
         movedLabel = new JLabel("Agents Moved: 0");
          
         infoPanel.add(iterationLabel);
         infoPanel.add(socialLabel);
         infoPanel.add(antisocialLabel);
         infoPanel.add(movedLabel);
         add(infoPanel, BorderLayout.NORTH);
  
         // Add the drawing canvas from the display to the center of the GUI.
         add(display.getCanvas(), BorderLayout.CENTER);
          
         // Create a panel for control buttons.
         JPanel controlPanel = new JPanel();
         JButton startButton = new JButton("Start/Resume");
         JButton pauseButton = new JButton("Pause");
          
         startButton.setBackground(Color.green);
         startButton.setOpaque(true);
         pauseButton.setBackground(Color.yellow);
         pauseButton.setOpaque(true);
         controlPanel.add(startButton);
         controlPanel.add(pauseButton);
  
         // Create a panel for the speed slider.
         JPanel sliderPanel = new JPanel();
         JLabel sliderLabel = new JLabel("Simulation Speed (ms delay): ");
         // Slider with minimum 5ms, maximum 200ms, and initial delay of 20ms.
         JSlider speedSlider = new JSlider(JSlider.HORIZONTAL, 5, 200, 20);
         speedSlider.setMajorTickSpacing(25);
         speedSlider.setMinorTickSpacing(5);
         speedSlider.setPaintTicks(true);
         speedSlider.setPaintLabels(true);
         sliderPanel.add(sliderLabel);
         sliderPanel.add(speedSlider);
  
         // Combine control and slider panels into a southPanel.
         JPanel southPanel = new JPanel();
         southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
         southPanel.add(controlPanel);
         southPanel.add(sliderPanel);
         add(southPanel, BorderLayout.SOUTH);
          
         // Set up a timer to update the simulation every 20ms.
         timer = new Timer(20, new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 int moved = scape.updateAgents(); // Update simulation and get number of agents moved
                 iterationCount++;
                  
                 // Update the info labels.
                 iterationLabel.setText("Iterations: " + iterationCount);
                 movedLabel.setText("Agents Moved: " + moved);
                  
                 // Count Social and Anti-Social agents.
                 int socialCount = 0;
                 int antisocialCount = 0;
                 for (Agent agent : scape.getAgents()) { // Assumes scape.getAgents() returns a collection of agents.
                     if (agent instanceof SocialAgent) {
                         socialCount++;
                     } else if (agent instanceof AntiSocialAgent) {
                         antisocialCount++;
                     }
                 }
                 socialLabel.setText("Social Agents: " + socialCount);
                 antisocialLabel.setText("Anti-Social Agents: " + antisocialCount);
                  
                 display.getCanvas().repaint();
                  
                 // Check if the simulation should stop.
                 if (moved == 0 || iterationCount >= maxIterations) {
                     timer.stop();
                     JOptionPane.showMessageDialog(AgentSimulationGUI.this, 
                             "Simulation stopped after " + iterationCount + " iterations.", 
                             "Simulation Complete", JOptionPane.INFORMATION_MESSAGE);
                 }
             }
         });
          
         // Change listener for the speed slider to adjust the timer delay.
         speedSlider.addChangeListener(new ChangeListener() {
             @Override
             public void stateChanged(ChangeEvent e) {
                 int delay = speedSlider.getValue();
                 timer.setDelay(delay);
             }
         });
          
         // Action listeners for the control buttons.
         startButton.addActionListener(new StartButtonListener(timer));
         pauseButton.addActionListener(new PauseButtonListener(timer));
          
         pack();
         setLocationRelativeTo(null); // Center the frame on screen.
         setVisible(true);
     }
  
     // Private inner classes to handle button events.
     private class PauseButtonListener implements ActionListener {
         private Timer timer;
         public PauseButtonListener(Timer timer) {
             this.timer = timer;
         }
         @Override
         public void actionPerformed(ActionEvent e) {
             timer.stop();
         }
     }
  
     private class StartButtonListener implements ActionListener {
         private Timer timer;
         public StartButtonListener(Timer timer) {
             this.timer = timer;
         }
         @Override
         public void actionPerformed(ActionEvent e) {
             timer.start();
         }
     }
  
     public static void main(String[] args) {
         SwingUtilities.invokeLater(new Runnable() {
             public void run() {
                 new AgentSimulationGUI();
             }
         });
     }
 }