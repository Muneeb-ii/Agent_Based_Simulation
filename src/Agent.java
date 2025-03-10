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

    /**
     * Returns the radius of the agent
     * @return the radius of the agent
     */
    public int getRadius(){
        return radius;
    }
    
    /**
     * Returns weather the agent has moved or not
     * @return true if the agent has moved, false otherwise
     */
    public boolean getMoved(){
        return moved;
    }

    /**
     * Sets the x-coordinate of the agent
     * @param newX the new x-coordinate of the agent
     */
    public void setX(double newX){
        x = newX;
    }

    /**
     * Sets the y-coordinate of the agent
     * @param newY the new y-coordinate of the agent
     */
    public void setY(double newY){
        y = newY;
    }

    /**
     * Sets the radius of the agent
     * @param newRadius the new radius of the agent
     */
    public void setRadius(int newRadius){
        radius = newRadius;
    }

    /**
     * Returns the string representation of the agent
     * @return stringRepresentation the string representation of the agent e.g. (x, y)
     */
    public String toString(){
        String stringRepresentation = "(" + String.format("%.3f", x) + ", " + String.format("%.3f", y) + ")";
        return stringRepresentation;
    }

    public abstract void updateStatus(Landscape scape);

    public abstract void draw(Graphics g);
 }
