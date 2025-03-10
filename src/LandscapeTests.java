/*
file name:      LandscapeTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea LandscapeTests
*/

public class LandscapeTests {

    public static double landscapeTests() {

        double score = 0.;

        // case 1: testing Landscape(int, int)
        {

            // setup
            Landscape scape = new Landscape( 5 , 5 ) ;

            // verify
            System.out.println( scape + " != null" ) ;

            // test
            assert scape != null : "Error in Landscape::Landscape( int , int )" ;

            score += 1 ;
        
        }

        // case 2: testing getWidth()
        {

            // setup
            Landscape scape = new Landscape( 5 , 5 ) ;

            // verify
            System.out.println( scape.getWidth() + " == 5" ) ;

            // test
            assert scape.getWidth() == 5 : "Error in Landscape::getWidth()" ;

            score += 1 ;

        }

        // case 3: testing getHeight()
        {
            
            //TODO

        }

        return score ;
    }

    public static void main(String[] args) {

        System.out.println( landscapeTests() );
    }
}