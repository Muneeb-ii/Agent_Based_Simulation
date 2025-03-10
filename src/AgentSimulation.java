/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of an Agent Simulation
 */

import java.util.Random; // import the Random class

public class AgentSimulation {

    public static void main(String[] args) throws InterruptedException{
        if (args.length != 1){
            System.out.println("Usage: java AgentSimulation <N>");
        }
        else{
            int N = Integer.parseInt(args[0]); // Initial number of social agents
            runExpt(N);
        }
    }

    /**
     * Runs the experiment with N social agents in the landscape and returns the number of iterations of the simulation
     * @param N the number of social agents
     * @return the number of iterations of the simulation
     * @throws InterruptedException
     */
    public static int runExpt(int N) throws InterruptedException{
        Landscape scape = new Landscape(500,500); // Create a new landscape
        LandscapeDisplay display = new LandscapeDisplay(scape); // Create a new landscape display
        Random rand = new Random();
        for(int i=0; i<N; i++){
            SocialAgent a = new SocialAgent(rand.nextDouble(500), rand.nextDouble(500), 25); // Create a new social agent
            scape.addAgent(a); // Add the social agent to the landscape
        }

        int numberOfIterations = 0; // Number of iterations of the simulation
        int agentsMoved = 1; // Number of agents that have moved in the last time step

        while(agentsMoved>0 & numberOfIterations<5000){
            Thread.sleep(10);
            display.repaint(); // Repaint the landscape
            agentsMoved = scape.updateAgents(); // Update the agents in the landscape and returns the number of agents that have moved
            numberOfIterations++; // Increment the number of iterations
        }
        return numberOfIterations;
    }
    
}
