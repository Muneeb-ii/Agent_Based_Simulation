/**
 * Author: Muneeb Azfar Nafees
 * 
 * Purpose of the class: Implementation of an Agent Simulation
 */

public class AgentSimulation {

    public static void main(String[] args){
        if (args.length != 1){
            System.out.println("Usage: java AgentSimulation <N>");
        }
        else{
            int N = Integer.parseInt(args[0]);
            runExpt(N);
        }
    }

    public static int runExpt(int N){
    }
    
}
