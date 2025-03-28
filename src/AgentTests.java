/*
file name:      AgentTests.java
Authors:        Ike Lage
last modified:  03/04/2025

How to run:     java -ea AgentTests
*/

public class AgentTests {

    public static double agentTests() {

        double score = 0. ;

        // case 1: testing SocialAgent( double , double , int ) and AntiSocialAgent( double , double , int )
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 0.0 , 0.0 , 5 ) ;

            // verify
            System.out.println( sa + " != null" ) ;
            System.out.println( asa + " != null" ) ;

            // test
            assert sa != null : "Error in SocialAgent::SocialAgent( double , double , int )" ;
            assert asa != null : "Error in AntiSocialAgent::AntiSocialAgent( double , double , int )" ;

            score += 1.25 ;
        }

        // case 2: testing getX() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 5.5 , 0.0, 5 ) ;

            // verify
            System.out.println( sa.getX() + " == 0.0" ) ;
            System.out.println( asa.getX() + " == 5.5" ) ;

            // test
            assert sa.getX() == 0.0 : "Error in SocialAgent::getX()" ;
            assert asa.getX() == 5.5 : "Error in AntiSocialAgent::getX()" ;

            score += 1.25 ;
        }

        // case 3: testing getY() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 0.0 , 2.3, 5 ) ;

            // verify
            System.out.println( sa.getY() + " == 0.0" ) ;
            System.out.println( asa.getY() + " == 2.3" ) ;

            // test
            assert sa.getY() == 0.0 : "Error in SocialAgent::getY()" ;
            assert asa.getY() == 2.3 : "Error in AntiSocialAgent::getY()" ;

            score += 1.25 ;
        }

        // case 4: testing getRadius() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 0.0 , 0.0, 10 ) ;

            // verify
            System.out.println( sa.getRadius() + " == 5" ) ;
            System.out.println( asa.getRadius() + " == 10" ) ;

            // test
            assert sa.getRadius() == 5 : "Error in SocialAgent::getRadius()" ;
            assert asa.getRadius() == 10 : "Error in AntiSocialAgent::getRadius()" ;

            score += 1.25 ;
        }

        // case 5: testing setX() for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 0.0 , 0.0, 5 ) ;

            sa.setX( 5.5 ) ;
            asa.setX( 10.5 ) ;

            // verify
            System.out.println( sa.getX() + " == 5.5" ) ;
            System.out.println( asa.getX() + " == 10.5" ) ;

            // test
            assert sa.getX() == 5.5 : "Error in SocialAgent::setX()" ;
            assert asa.getX() == 10.5 : "Error in AntiSocialAgent::setX()" ;

            score += 1.25 ;
        }

        // case 6: testing setY()  for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 0.0 , 0.0, 5 ) ;

            sa.setY( 5.5 ) ;
            asa.setY( 10.5 ) ;

            // verify
            System.out.println( sa.getY() + " == 5.5" ) ;
            System.out.println( asa.getY() + " == 10.5" ) ;

            // test
            assert sa.getY() == 5.5 : "Error in SocialAgent::setY()" ;
            assert asa.getY() == 10.5 : "Error in AntiSocialAgent::setY()" ;

            score += 1.25 ;
        }

        // case 7: testing setRadius()  for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 0.0 , 0.0, 5 ) ;

            sa.setRadius( 10 ) ;
            asa.setRadius( 15 ) ;

            // verify
            System.out.println( sa.getRadius() + " == 10" ) ;
            System.out.println( asa.getRadius() + " == 15" ) ;

            // test
            assert sa.getRadius() == 10 : "Error in SocialAgent::setRadius()" ;
            assert asa.getRadius() == 15 : "Error in AntiSocialAgent::setRadius()" ;

            score += 1.25 ;
        }

        // case 8: testing getMoved()  for both SocialAgent and AntiSocialAgent
        {
            // setup
            SocialAgent sa = new SocialAgent( 0.0 , 0.0 , 5 ) ;
            AntiSocialAgent asa = new AntiSocialAgent( 0.0 , 0.0, 5 ) ;

            // verify
            System.out.println( sa.getMoved() + " == false" ) ;
            System.out.println( asa.getMoved() + " == false" ) ;

            // test
            assert !sa.getMoved() : "Error in SocialAgent::getMoved()" ;
            assert !asa.getMoved() : "Error in AntiSocialAgent::getMoved()" ;

            score += 1.25 ;
        }

        return score;
    }
    


    public static void main(String[] args) {

        System.out.println( agentTests() );
    }
}