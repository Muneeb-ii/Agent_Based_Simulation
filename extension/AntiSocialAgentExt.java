/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of an AntiSocial Agent with the possibility of a LeaderAgent.
 */

 import java.awt.Color; // import the Colour class
 import java.awt.Graphics; // import the Graphics class
 import java.util.Random;
 
 public class AntiSocialAgentExt extends Agent{
 
     /**
      * Constructor for the AntiSocialAgent class
      * @param x0 the x-coordinate of the agent
      * @param y0 the y-coordinate of the agent
      * @param radius the radius of the agent
      */
     public AntiSocialAgentExt(double x0, double y0, int radius) {
         super( x0, y0 , radius );
         // remainder of constructor code
     }
 
     /**
      * Draws the agent on the screen depending on whether it has moved or not
      * @param g graphics object to draw the agent
      */
     @Override // indicates that this method overrides a superclass method
     public void draw(Graphics g){
         if(!moved) g.setColor(new Color(255, 0, 0));
         else g.setColor(new Color(255, 125, 125));
     
         g.fillOval((int) getX(), (int) getY(), 5, 5);
     }
 
     /**
      * Updates the status of the agent
      * @param scape the landscape the agent is in
      */
     @Override
     public void updateState(Landscape scape) {
         Random rand = new Random();
         // Get all neighbors within the agent's radius
         LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), getRadius());
         
         // If there are more than 1 agent in the neighborhood, attempt to move
         if (neighbors.size() > 1) {
             // Calculate candidate new positions with a random move between -10 and 10
             double newX = getX() + (rand.nextDouble() * 20) - 10;
             double newY = getY() + (rand.nextDouble() * 20) - 10;
             
             // Check if a LeaderAgent is present among the neighbors
             LeaderAgent leader = null;
             for (Agent agent : neighbors) {
                 if (agent instanceof LeaderAgent) {
                     leader = (LeaderAgent) agent;
                     break; // Use the first LeaderAgent found
                 }
             }
             
             // If a LeaderAgent is detected, constrain the candidate move within the leader's radius
             if (leader != null) {
                 double distanceX = newX - leader.getX();
                 double distanceY = newY - leader.getY();
                 double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);
                 
                 // If the candidate position is outside the leader's radius, clamp it to the boundary
                 if (distance > leader.getRadius()) {
                     double angle = Math.atan2(distanceY, distanceX);
                     newX = leader.getX() + leader.getRadius() * Math.cos(angle);
                     newY = leader.getY() + leader.getRadius() * Math.sin(angle);
                 }
             }
             
             // Ensure the candidate position stays within the landscape boundaries
             while (newX < 0 || newX > scape.getWidth()) {
                 newX = getX() + (rand.nextDouble() * 20) - 10;
             }
             while (newY < 0 || newY > scape.getHeight()) {
                 newY = getY() + (rand.nextDouble() * 20) - 10;
             }
             
             // Update the agent's position
             setX(newX);
             setY(newY);
             moved = true;
         } 
         else {
             moved = false;
         }
     }
 }