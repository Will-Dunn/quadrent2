import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class RunMotors extends Main
{	//public static RXTXRobot Robot = new ArduinoNano(); // Create RXTXRobot object
	//time should be set to the length of time required to move 3 meters.
	public static double time=2500;
	//motor1pin is the pin motor 1 is wired to.
	public static int motor1pin=5;
	//motor2pin is the pin motor 2 is wired to.
	public static int motor2pin=7;
	//speed1 is the speed motor 1 will move at.
	public static int speed1=-300;
	//speed2 is the speed motor 2 will move at.
	public static int speed2=500;
	//Pingpin is the pin at which the ping sensor is wired.
	public static int Pingpin=5;
	public static int Me1=2;
	public static int Me2=3;
		
	//if doing ping stop test set test to 1 other wise leave as is. 
	//private static int test=0;
	public static void main(String[] args, int test)
	{
	
	
		ping();
			
		
	}
	public static int Time(int distance) {
		double T=5/time;
		T=distance*T;
		int t=(int)T*1000;
		return t;
		
		
	}
	public static void distanceMove(int distance,int direction) {
		//move in direction for length of time
		//direction is either positive or negative switching our direction
		Robot.runTwoPCAMotor( motor1pin,  speed1*direction,  motor2pin,  speed2*direction,  Time(distance));
		Robot.allPCAStop();
		Robot.sleep(1000);
		
		
		
	}
	public static boolean ping() {
		//handles ping distance 
		//for (int x=0; x < 20; ++x)
	//	{
		System.out.println(Robot.getPing(Pingpin));
			if(Robot.getPing(Pingpin)<20)
				return true;
			//Robot.sleep(300);
		//}
		return false;
		
	}
	
	public static void turnToAngle (int angleToTurnTo) {
		//Right a turn to angle 
		//pass in paramter angle
		//pass into turn by angle
		turnByAngle(angleToTurnTo);
	}	
	
	public static void turnByAngle (int angle) {
		//TOFIX: Calibration
		int timeTurn = (int)(angle *6); //uses ratio to calculate time needed to turn based on the angle passed through paramters
 		Robot.runTwoPCAMotor(motor1pin, -speed1, motor2pin, speed2, timeTurn); //turns robot right 
 		Robot.sleep(1000);
	}
			
	
		
	/*
	public static void turnRightByAngle (int angle) {
		
//turn right
		
 		int timeTurn = (int)(angle *6); //uses ratio to calculate time needed to turn based on the angle passed through paramters
 		Robot.runTwoPCAMotor(motor1pin, -speed1, motor2pin, speed2, timeTurn); //turns robot right 
 		Robot.sleep(1000);
 		;
 	}
 	public static void turnLeftByAngle (int angle) {
//turn left 
		
		
 		int timeTurn = (int)(angle * 2); //uses ratio to calculate time needed to turn based on the angle passed through paramters
 		Robot.runTwoPCAMotor(motor1pin, speed1, motor2pin, -speed2, timeTurn); //turns robot left
 		Robot.sleep(1000);
 	
 	}
 	*/
}
