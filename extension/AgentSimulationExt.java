/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of an Agent Simulation for extension
 */

 import java.util.Random; // import the Random class

 public class AgentSimulationExt {
 
     public static void main(String[] args) throws InterruptedException {
         if (args.length != 2) {
             System.out.println("Usage: java AgentSimulation <L> <S>");
             System.out.println("Where <L> is the number of LeaderAgents and <S> is the number of SocialAgents");
         } else {
             int L = Integer.parseInt(args[0]); // Number of LeaderAgents
             int S = Integer.parseInt(args[1]); // Number of SocialAgents
             System.out.println(runExpt(L, S)); // Run the experiment and print the number of iterations
         }
     }
 
     /**
      * Runs the experiment with L LeaderAgents and S SocialAgents in the landscape and returns the number of iterations of the simulation
      * @param L the number of LeaderAgents
      * @param S the number of SocialAgents
      * @return the number of iterations of the simulation
      * @throws InterruptedException
      */
     public static int runExpt(int L, int S) throws InterruptedException {
         Landscape scape = new Landscape(500, 500); // Create a new landscape
         LandscapeDisplay display = new LandscapeDisplay(scape); // Create a new landscape display
         Random rand = new Random();
         
         // Spawn LeaderAgents
         for (int i = 0; i < L; i++) {
             LeaderAgent leader = new LeaderAgent(rand.nextDouble() * 500, rand.nextDouble() * 500, 25);
             scape.addAgent(leader);
         }
         
         // Spawn SocialAgents
         for (int i = 0; i < S; i++) {
             SocialAgent agent = new SocialAgent(rand.nextDouble() * 500, rand.nextDouble() * 500, 25);
             scape.addAgent(agent);
         }
         
         int numberOfIterations = 0; // Number of iterations of the simulation
         int agentsMoved = 1; // Number of agents that have moved in the last time step
 
         while (agentsMoved > 0 && numberOfIterations < 5000) {
             agentsMoved = scape.updateAgents(); // Update the agents and get the number of agents that moved
             display.repaint(); // Repaint the landscape
             Thread.sleep(10);
             numberOfIterations++; // Increment the iteration count
         }
         return numberOfIterations;
     }
 }
 