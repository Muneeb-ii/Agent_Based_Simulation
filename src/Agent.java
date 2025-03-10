/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of an Agent
 */

 abstract class Agent{
    private double x;
    private double y;
    protected int radius;
    protected boolean moved;

    /**
     * Constructor for the Agent class
     * @param x0 the x-coordinate of the agent
     * @param y0 the y-coordinate of the agent
     * @param radius the radius of the agent
     */
    public Agent(double x0, double y0, int radius){
        x = x0;
        y = y0;
        this.radius = radius;
        moved = false;
    }

    /**
     * Returns the x-coordinate of the agent
     * @return the x-coordinate of the agent
     */
    public double getX(){
        return x;
    }

    /**
     * Returns the y-coordinate of the agent
     * @return the y-coordinate of the agent
     */
    public double getY(){
        return y;
    }
 }