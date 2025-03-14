/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Social Agent with the possibility of a LeaderAgent.
 */

 import java.awt.Color; // import the Colour class
 import java.awt.Graphics; // import the Graphics class
 import java.util.Random;
 
 public class SocialAgentExt extends Agent{
 
     /**
      * Constructor for the SocialAgent class
      * @param x0 the x-coordinate of the agent
      * @param y0 the y-coordinate of the agent
      * @param radius the radius of the agent
      */
     public SocialAgentExt(double x0, double y0, int radius) {
         super( x0, y0 , radius );
         // remainder of constructor code
     }
 
     /**
      * Draws the agent on the screen depending on whether it has moved or not
      * @param g graphics object to draw the agent
      */
     @Override // indicates that this method overrides a superclass method
     public void draw(Graphics g){
         if(!moved) g.setColor(new Color(0, 0, 255));
         else g.setColor(new Color(125, 125, 255));
     
         g.fillOval((int) getX(), (int) getY(), 5, 5);
     }
 
     /**
      * Updates the status of the agent
      * @param scape the landscape the agent is in
      */
      public void updateState(Landscape scape) {
        Random rand = new Random();
        // Get neighbors within the agent's radius.
        LinkedList<Agent> neighbors = scape.getNeighbors(getX(), getY(), getRadius());
        
        // Search for a LeaderAgent among the neighbors.
        LeaderAgent leader = null;
        for (Agent agent : neighbors) {
            if (agent instanceof LeaderAgent) {
                leader = (LeaderAgent) agent;
                break; // Use the first leader found.
            }
        }
        
        // If there are less than 4 neighbors, the agent attempts to move.
        if (neighbors.size() < 4) {
            // Compute candidate new positions with a random move between -10 and 10.
            double newX = getX() + (rand.nextDouble() * 20) - 10;
            double newY = getY() + (rand.nextDouble() * 20) - 10;
            
            // If a LeaderAgent is detected, constrain the candidate move within the leader's radius.
            if (leader != null) {
                double distanceX = newX - leader.getX();
                double distanceY = newY - leader.getY();
                double distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
                if (distance > leader.getRadius()) {
                    // Calculate angle and clamp candidate position to leader's boundary.
                    double angle = Math.atan2(distanceY, distanceX);
                    newX = leader.getX() + leader.getRadius() * Math.cos(angle);
                    newY = leader.getY() + leader.getRadius() * Math.sin(angle);
                }
            }

            // Ensure the candidate position remains within the landscape boundaries.
            while (newX < 0 || newX > scape.getWidth()) {
                newX = getX() + (rand.nextDouble() * 20) - 10;
            }
            while (newY < 0 || newY > scape.getHeight()) {
                newY = getY() + (rand.nextDouble() * 20) - 10;
            }
            
            // Update the agent's position.
            setX(newX);
            setY(newY);
            moved = true;
        } 
        else {
            moved = false;
        }
    }
 }