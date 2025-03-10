/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Social Agent
 */

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
    public void updateStatus(Landscape scape){

    }

}