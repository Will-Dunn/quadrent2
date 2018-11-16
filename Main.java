
import rxtxrobot.ArduinoNano;
import rxtxrobot.RFIDSensor;
import rxtxrobot.RXTXRobot;
public class Main {
	private static int test=0;
	//our robots current heading or angle
	private static int heading=85;
	
	//beacon 1 2 3 are the beacons that will be scaned by the robot;
	private static char beacon1;
	private static char beacon2;
	private static beacon beacon3;
	private static int[] distances=new int[3];
	private static boolean b1d=false;
	private static boolean b2d=false;
	public static Servomotors IRServo;
	//x and y are robots x and y corrdinats 
	
	private static double x;
	private static double y;
	//desx and desy our are target x and y
	private static double desx;
	private static double desy;
	public static boolean done=false;
	public static RXTXRobot Robot = new ArduinoNano();
	//general direction of desired heading up being 90/ left being 180/ down being 270, right being 0
	private static int direction=90;
	//private static int heading=85;
	//private static Servomotors Irmotor=new Servomotors(); 
	
	public static void main(String[] args) {
		Robot.setPort("/dev/tty.usbmodem14101");
		//one of these two is run during tests
		Quadrent1_2();	
		Quadrent3_4();
		angleBetween();
		
		Robot.close();
		
}
	public static void angleBetween() {
		int a1 = findBeacon1('G',180);	
		int a2 = findBeacon2('N',findBeacon1('G',180));
		int anglebetween= a1-a2;
		System.out.println("Angle Between: "+anglebetween);
	}
	public static int findBeacon1(char target,int a) {
		Servomotors.rotate(11, a);
		if(IRReadOut.ScanIR(target)==0) {
			
			return findBeacon1( target, a-5);
			
		}
		else {
			System.out.println("target aquired. tag: "+IRReadOut.Tag+" Angle: "+a);
			beacon1=IRReadOut.Tag;
			return a;
		}
		
	}
	public static int findBeacon2(char target,int a) {
		Servomotors.rotate(11, 180-a);
		if(IRReadOut.ScanIR(target)==0) {
			//System.out.println("not the target");
			return findBeacon2( target, a+5);
			
		}
		else {
			System.out.println("target aquired. tag: "+IRReadOut.Tag+" Angle: "+a);
			beacon2=IRReadOut.Tag;
			return a;
		}
		
	}
	
	//temperature Quadrent
	public static void Quadrent1() {
		Robot.setPort("/dev/tty.usbmodem14101");
		Robot.connect();
		Servomotors.rotate(10, 180);
		
		// move forward 52 inches (4 feet 3 in)
		RunMotors.distanceMove(5,1);
		//turn right **GET ANGLE CORRECT
		RunMotors.turnRightByAngle(40);
		//move forward inches 31
		RunMotors.distanceMove(3,1);
		//turn left
		RunMotors.turnLeftByAngle(90);
		//move forward 37 inches
		RunMotors.distanceMove(4,1);
		//turn right
		RunMotors.turnRightByAngle(90);
		//move forward 79 inches (6 feet 7 inches)
		RunMotors.distanceMove(7,1);
		//lower temperature sensor
		code to lower 
		//use thermistors to get reading  
		thermistors.main(5);
		//raise temperature sensor
		code to raise
		//move backward 15 inches
		RunMotors.distanceMove(2,-1);
		//turn left 
		RunMotors.turnLeftByAngle(90);
		//move forward 18 inches
		RunMotors.distanceMove(2,1);
		//turn right 45 degrees
		RunMotors.turnRightByAngle(45);
		//move forward 4.5 inches
		RunMotors.distanceMove(1,1);
		//ramp is a distance of 39.75 inches
		//go up ramp half the distance 
		RunMotors.distanceMove(2,1);
		//meausre angle
		inclinometer.main(5);
		//go up last half of ramp 
		RunMotors.distanceMove(2,1);		
	}
	
	//Quadrent2 sandbox
	public static void Quadrent2() {
		Robot.setPort("/dev/tty.usbmodem14101");
		Robot.connect();
		Servomotors.rotate(10, 180);

		//move robot forward 75 inches (6ft 3)
		RunMotors.distanceMove(7,1);
		//turn robot to the right
		RunMotors.turnRightByAngle(90);
		//move robot forward 19 inches to the sandbox
		RunMotors.distanceMove(2,1);
		//lower probe  **IS THIS THE CORREC PROBE FOR TEMPERATURE
		Servomotors.rotate(10, 10);
		Robot.sleep(5000);
		Conductivity.main();
		Robot.sleep(10000);
		//raises probe
		Servomotors.rotate(10, 10);
		Robot.sleep(5000);
		Conductivity.main();
		Robot.sleep(10000);
		//move robot backward 19 inches from the sandbox
		//**LONG BACKWARDS DISTANCE
		RunMotors.distanceMove(2,-1);
		//turn the robot left
		RunMotors.turnLeftByAngle(90);
		//move robot forward 36 inches
		RunMotors.distanceMove(3,1);
		//turn the robot 45 degrees to the right
		RunMotors.turnRightByAngle(89);
		//move forward 21.5 inches
		RunMotors.distanceMove(2,1);
		//we are at the base of the ramp
		//ramp is a distance of 39.75 inches
		//go up ramp half the distance 
		RunMotors.distanceMove(2,1);
		//meausre angle
		inclinometer.main(5);
		//go up last half of ramp 
		RunMotors.distanceMove(2,1);
	}
	
	//Quadrent3 nothing
	public static void Quadrent3() {
		Robot.setPort("/dev/tty.usbmodem14101");
		Robot.connect();
		Servomotors.rotate(10, 180);

		//move forward 6ft
		RunMotors.distanceMove(6,1);
		//turn right
		RunMotors.turnRightByAngle(90);
		// move forward 73.5 inches
		RunMotors.distanceMove(7,1);
		//turn left
		RunMotors.turnLeftByAngle(90);
		//move forward 46 inches (3ft 10 in)
		RunMotors.distanceMove(4,1);
		//we are at the base of the ramp
		//ramp is a distance of 39.75 inches
		//go up ramp half the distance 
		RunMotors.distanceMove(2,1);
		//meausre angle
		inclinometer.main(5);
		//go up last half of ramp 
		RunMotors.distanceMove(2,1);
	}
	
	//Quadrent 4 movable barriers 
	public static void Quadrent4() {
		Robot.setPort("/dev/tty.usbmodem14101");
		Robot.connect();
		Servomotors.rotate(10, 180);

		//move foward 4 feet 8 inches 
		RunMotors.distanceMove(5,1);
		//turn left 90 degrees
		RunMotors.turnLeftByAngle(90);
		//move forward 3 feet 3 inches 
		RunMotors.distanceMove(4,1);
		//turn right 90 degrees 
		RunMotors.turnRightByAngle(90);
		//move forward 3 feet 10 inches
		RunMotors.distanceMove(4,1);
		//we are at the base of the ramp
		//ramp is a distance of 39.75 inches
		//go up ramp half the distance 
		RunMotors.distanceMove(2,1);
		//meausre angle
		inclinometer.main(5);
		//go up last half of ramp 
		RunMotors.distanceMove(2,1); 
	}
	
	
	
	
	public static void Quadrent1_2() {
		Robot.setPort("/dev/tty.usbmodem14101");
		Robot.connect();
		Servomotors.rotate(10, 180);
		RunMotors.distanceMove(1550,1);
		RunMotors.turnRightByAngle(150);
		RunMotors.distanceMove(1025,1);
		//lowers probe
		Servomotors.rotate(10, 10);
		Robot.sleep(5000);
		Conductivity.main();
		Robot.sleep(10000);
		//raises probe
		Servomotors.rotate(10, 180);
		Robot.sleep(5000);
		//back up for a tenth of a second
		Robot.close();
		Robot.connect();
		RunMotors.distanceMove(100,-1);
		//turn aproximitly 90ish degrees or you know the program just does the hell what ever the hell it wants.
		RunMotors.turnLeftByAngle(50);
		//move forward or not your choice program
		RunMotors.distanceMove(2400,1);
		
		Servomotors.rotate(10, 15);
		
		thermistors.main(10);
		Robot.sleep(5000);
		//raises probe
		Servomotors.rotate(10, 180);
		//fixes problem with actions overlapping
		Robot.close();
		Robot.connect();
		
		RunMotors.distanceMove(1000,-1);
		//makes the robot go forward: distance, direction (-1) , (1) 
		RunMotors.turnRightByAngle(89);
		
		RunMotors.distanceMove(1025,1);
		
		
		
		
		RunMotors.distanceMove(2000,1);
		Robot.close();
		//Sing im on top of the world. 
	}
	public static void Quadrent3_4() {
		Robot.setPort("/dev/tty.usbmodem14101");
		Robot.connect();
		RunMotors.distanceMove(1550,1);
		RunMotors.turnRightByAngle(115);
		RunMotors.distanceMove(1700,1);
		RunMotors.turnLeftByAngle(80);
		RunMotors.distanceMove(4500,1);

		
		
		
	}
	
}

