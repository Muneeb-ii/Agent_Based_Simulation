/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Social Agent
 */

 import java.awt.Color; // import the Colour class
 import java.awt.Graphics; // import the Graphics class
 
 public class LeaderAgent extends Agent{
 
     /**
      * Constructor for the SocialAgent class
      * @param x0 the x-coordinate of the agent
      * @param y0 the y-coordinate of the agent
      * @param radius the radius of the agent
      */
     public LeaderAgent(double x0, double y0, int radius) {
         super( x0, y0 , radius );
         // remainder of constructor code
     }
 
     /**
      * Draws the agent on the screen depending on whether it has moved or not
      * @param g graphics object to draw the agent
      */
     @Override // indicates that this method overrides a superclass method
     public void draw(Graphics g){
         if(!moved) g.setColor(new Color(255, 165, 0));
         else g.setColor(new Color(255, 213, 128));
     
         g.fillOval((int) getX(), (int) getY(), 5, 5);
     }
 
     /**
      * Updates the status of the agent
      * @param scape the landscape the agent is in
      */
     public void updateState(Landscape scape){
     }
 }