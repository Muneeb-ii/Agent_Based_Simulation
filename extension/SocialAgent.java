/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Social Agent without the possibility of a LeaderAgent.
 */

import java.awt.Color; // import the Colour class
import java.awt.Graphics; // import the Graphics class
import java.util.Random;

public class SocialAgent extends Agent{

    /**
     * Constructor for the SocialAgent class
     * @param x0 the x-coordinate of the agent
     * @param y0 the y-coordinate of the agent
     * @param radius the radius of the agent
     */
    public SocialAgent(double x0, double y0, int radius) {
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
    public void updateState(Landscape scape){
        Random rand = new Random();
        if(scape.getNeighbors(getX(), getY(), getRadius()).size()<4){ // if there are less than 4 agents within the radius
            double newX = getX()+(rand.nextDouble()*(10+10))-10; // move the agent to a new location
            double newY = getY()+(rand.nextDouble()*(10+10))-10; // move the agent to a new location
            while(newX<0 || newX>scape.getWidth()){ // make sure the agent stays within the landscape
                newX = getX()+(rand.nextDouble()*(10+10))-10;
            }
            while(newY<0 || newY>scape.getHeight()){ // make sure the agent stays within the landscape
                newY = getY()+(rand.nextDouble()*(10+10))-10;
            }
            this.setX(newX);
            this.setY(newY);
            moved = true;
        }
        else{
            moved = false;
        }
    }
}