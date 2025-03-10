/*
file name:      AgentSimulationTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea AgentSimulationTests
*/

import java.util.Random;

public class AgentSimulationTests {

    public static int runExpt(int N) {
        //That means you should remove the lines that create the landscape display, the call to Thread.sleep, and the call to the repaint method.
        Landscape scape = new Landscape(500,500); // Create a new landscape
        Random rand = new Random();
        for(int i=0; i<N; i++){
            SocialAgent a = new SocialAgent(rand.nextDouble()*500, rand.nextDouble()*500, 25); // Create a new social agent
            scape.addAgent(a); // Add the social agent to the landscape
        }

        int numberOfIterations = 0; // Number of iterations of the simulation
        int agentsMoved = 1; // Number of agents that have moved in the last time step

        while(agentsMoved>0 & numberOfIterations<5000){
            agentsMoved = scape.updateAgents(); // Update the agents in the landscape and returns the number of agents that have moved
            numberOfIterations++; // Increment the number of iterations
        }
        return numberOfIterations;
    }


    public static double agentSimulationTests() {

        //Note, you must implement runExpt in AgentSimulation for this code to work!

        double score = 0.;

        {
            int[] nums = { 50 , 100 };
            int[] correctAnswers = { 234 , 541 };
            for ( int i = 0 ; i < nums.length ; i++ ) {
                int output = 0 ;
                for ( int j = 0 ; j < 20 ; j++ ) {
                    output += runExpt( nums[ i ] ) ;
                }
                output /= 20;
                System.out.println( output );
                if ( ( output < correctAnswers[ i ] + 100 ) && ( ( output > correctAnswers[ i ] - 100 ) ) ) {
                    score += 1.;
                }
            }
        }

        {
            int output = runExpt( 250 ) ;
            if ( output == 5000 ) {
                score += 1.;
            }

        }
        return score ;
    }

    public static void main(String[] args) {

        System.out.println( agentSimulationTests() );
    }
}