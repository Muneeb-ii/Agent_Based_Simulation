/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Landscape
 */

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
        agents = new LinkedList<Agent>();
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
}
