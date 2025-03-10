/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Landscape
 */

import java.awt.Graphics; // import the Graphics class
import java.util.Random; // import the Random class

public class Landscape {
    private int width;
    private int height;
    private LinkedList<Agent> agents;

    /**
     * Constructor for the Landscape class
     * @param w the width of the landscape
     * @param h the height of the landscape
     */
    public Landscape(int w, int h){
        width = w;
        height = h;
        agents = new LinkedList<>();
    }

    /**
     * Returns the height of the landscape
     * @return the height of the landscape
     */
    public int getHeight(){
        return height;
    }

    /**
     * Returns the width of the landscape
     * @return the width of the landscape
     */
    public int getWidth(){
        return width;
    }

    /**
     * Adds an agent to the landscape
     * @param a the agent to be added
     */
    public void addAgent(Agent a){
        agents.add(a);
    }

    /**
     * Returns the size of the landscape and the number of agents in the landscape
     * @return the size of the landscape and the number of agents in the landscape
     */
    public String toString(){
        return "Landscape: " + width + " x " + height + " with " + agents.size() + " agents";
    }

    /**
     * Returns the number of agents within a certain radius of a point
     * @param x0 the x-coordinate of the point
     * @param y0 the y-coordinate of the point
     * @param radius the radius of the point
     * @return the linked list of agents within the radius of the point
     */
    public LinkedList<Agent> getNeighbors(double x0, double y0, double radius){
        LinkedList<Agent> neighbors = new LinkedList<>();
        for (Agent a : agents){
            double distance = Math.pow(Math.pow(a.getX() - x0, 2) + Math.pow(a.getY() - y0, 2), 0.5);  // distance formula
            if(distance <= radius){
                neighbors.add(a);
            }
        }
        return neighbors;
    }

    /**
     * Draws the agents on the screen
     * @param g the gradphics object to draw the agents
     */
    public void draw(Graphics g){
        for (Agent a : agents){
            a.draw(g);
        }
    }

    /**
     * Updates the agents in the landscape
     * @return the number of agents that have moved
     */
    public int updateAgents(){
        int moved = 0;
        Random rand = new Random();
        int agentIndex = rand.nextInt(agents.size());
        Agent randAgent = agents.get(agentIndex);
        double agentX = randAgent.getX();
        double agentY = randAgent.getY();
        int agentRadius = randAgent.getRadius();

        agents.remove(agentIndex);

        Agent asa = new AntiSocialAgent(agentX, agentY, agentRadius);
        agents.add(asa);

        for (Agent a : agents){
            a.updateState(this);
            if(a.getMoved()){
                moved++;
            }
        }
        return moved;
    }
    
}
