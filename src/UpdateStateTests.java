/*
file name:      UpdateStateTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea UpdateStateTests
*/

public class UpdateStateTests {

    public static double updateStateTests() {

        double score = 0.;

        // case 1: testing updateState() doesn't move the agent for a social agent when it has many neighbors
        {
           
            // set up
            // Make a landscape of 100x100
            Landscape scape = new Landscape(100, 100);

            //Make an social agent at x=10, y=10 with radius of 5 called a1
            Agent a1 = new SocialAgent(10,10,5);

            //Add a1 to the landscape;
            scape.addAgent(a1);

            //Make 4 Social Agents within a radius of 5 of the agent
            Agent a2 = new SocialAgent(5,5,5);
            Agent a3 = new SocialAgent(15,15,5);
            Agent a4 = new SocialAgent(5,15,5);
            Agent a5 = new SocialAgent(15,5,5);

            // verify
            //update the agent's state
            a1.updateState(scape);

            // test
            //Check that a1 didn't move
            if ( ( a1.getX() == 10 ) && ( a1.getY() == 10 ) && ( a1.getMoved() == false ) ){
                System.out.println("1");
                score += 0.75 ;
            }
        }

        // case 2: testing updateState() moves the agent for an antisocial agent when it has many neighbors
        {
           
            // set up
            // Make a landscape of 100x100
            Landscape scape = new Landscape(100,100);

            //Make an antisocial agent at x=10, y=10 with radius of 5 called a1
            Agent a1 = new AntiSocialAgent(10,10,5); 

            //Add the a1 to the landscape;
            scape.addAgent(a1);

            //Make 4 Social Agents within a radius of 5 of the agent
            Agent a2 = new SocialAgent(5,5,5);
            Agent a3 = new SocialAgent(15,15,5);
            Agent a4 = new SocialAgent(5,15,5);
            Agent a5 = new SocialAgent(15,5,5);

            // verify
            //update the agent's state
            a1.updateState(scape);

            // test
            //Check that a1 did move
            if ( ( a1.getX() != 10 ) && ( a1.getY() != 10 ) && ( a1.getY() != a1.getX() ) && ( a1.getMoved() == true ) ){
                System.out.println("2");
                score += 0.75 ;
            }
        }

        // case 3: testing updateState() moves the agent for a social agent when it has few neighbors
        {
           
            // set up
            // Make a landscape of 100x100

            //Make an social agent at x=10, y=10 called a1

            //Add a1 to the landscape

            // verify
            //update the agent's state

            // test
            //Check that a1 did move
            if ( ( a1.getX() != 10 ) && ( a1.getY() != 10 ) && ( a1.getY() != a1.getX() ) && ( a1.getMoved() == true ) ){
                System.out.println("3");
                score += 0.75 ;
            }
        }

        // case 4: testing updateState() doesn't move the agent for an antisocial agent when it has few neighbors
        {
            //Setup
        
            // Make a landscape of 100x100

            //Make an antisocial agent at x=10, y=10 called a1

            //Add the a1 to the landscape

            //Verify

            //update the agent's state

            // test
            //Check that a1 didn't move
            if ( ( a1.getX() == 10 ) && ( a1.getY() == 10 ) && ( a1.getMoved() == false ) ){
                System.out.println("4");
                score += 0.75 ;
            }
        }

        return score ;

    }

    public static void main(String[] args) {

        System.out.println( updateStateTests() );
    }
}