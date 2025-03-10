/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of a Landscape
 */

public class Landscape {
    private int width;
    private int height;
    private LinkedList<Agent> agents;

    public Landscape(int w, int h){
        width = w;
        height = h;
        agents = new LinkedList<Agent>();
    }
}
