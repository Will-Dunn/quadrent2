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
	//motor 1's power should be 70% of what motor 2's power is
	//public static int speed1=-350;
	//speed2 is the speed motor 2 will move at.
	public static int speed2=500;
	public static int speed1=speed2*-1*(350/500);
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
		double T=2200/5;
		T=distance*T;
		int t=(int)T;
		return t;
		
		
	}
	public static void distanceMove(int distance,int direction) {
		//move in direction for length of time
		//direction is either positive or negative switching our direction
		Robot.runTwoPCAMotor( motor1pin,  speed1*direction,  motor2pin,  speed2*direction,  Time(distance));
		if(ping()) {
			Robot.allPCAStop();}
		Robot.allPCAStop();
		Robot.sleep(1000);
		
		
		
	}
	public static void timed(int time,int direction) {
		//move in direction for length of time
		//direction is either positive or negative switching our direction
		Robot.runTwoPCAMotor( motor1pin,  speed1*direction,  motor2pin,  speed2*direction,  time);
		//if(ping()) {
		//	Robot.allPCAStop();}
		Robot.allPCAStop();
		Robot.sleep(100);
		
		
		
	}
	public static int ping() {
		return Robot.getPing(Pingpin);
		
	}
	
		
				
			
		
		
			
			
	public static void holdpos(int time) {
		Robot.runTwoPCAMotor( motor1pin,  100,  motor2pin,  350,  time);
		
		
	}
		
	
	public static void turnRightByAngle (int angle) {
		
//turn right
		
 		int timeTurn = (int)(angle *6); //uses ratio to calculate time needed to turn based on the angle passed through paramters
 		Robot.runTwoPCAMotor(motor1pin, -speed1, motor2pin, speed2, timeTurn); //turns robot right 
 		Robot.sleep(1000);
 		
 	}
 	public static void turnLeftByAngle (int angle) {
//turn left 
		
		
 		int timeTurn = (int)(angle * 2); //uses ratio to calculate time needed to turn based on the angle passed through paramters
 		Robot.runTwoPCAMotor(motor1pin, speed1, motor2pin, -speed2, timeTurn); //turns robot left
 		Robot.sleep(1000);
 	
 	}
}
