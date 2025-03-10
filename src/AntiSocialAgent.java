/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of an AntiSocial Agent
 */

import java.awt.Color; // import the Graphics class
import java.awt.Graphics; // import the Color class

public class AntiSocialAgent extends Agent{

    /**
     * Constructor for the AntiSocialAgent class
     * @param x0 the x-coordinate of the agent
     * @param y0 the y-coordinate of the agent
     * @param radius the radius of the agent
     */
    public AntiSocialAgent(double x0, double y0, int radius) {
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
    public void updateStatus(Landscape scape){

    }

}