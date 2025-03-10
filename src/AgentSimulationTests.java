/*
file name:      AgentSimulationTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea AgentSimulationTests
*/

import java.util.Random;

public class AgentSimulationTests {

    public static int runExpt(int N) {
        //TODO this is the same as your runExpt method in AgentSimulation, except don't do anything with the landscape display
        //That means you should remove the lines that create the landscape display, the call to Thread.sleep, and the call to the repaint method.

        
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