import rxtxrobot.ArduinoNano;
import rxtxrobot.RXTXRobot;

public class RunMotors
{	private static RXTXRobot Robot = new ArduinoNano(); // Create RXTXRobot object
	//time should be set to the length of time required to move 3 meters.
	private static int time=4290;
	//motor1pin is the pin motor 1 is wired to.
	private static int motor1pin=5;
	//motor2pin is the pin motor 2 is wired to.
	private static int motor2pin=7;
	//speed1 is the speed motor 1 will move at.
	private static int speed1=-145;
	//speed2 is the speed motor 2 will move at.
	private static int speed2=500;
	//Pingpin is the pin at which the ping sensor is wired.
	private static int Pingpin=5;
	//if doing ping stop test set test to 1 other wise leave as is. 
	//private static int test=0;
	public static void main(String[] args, int test)
	{
	Robot.setPort("COM6"); // Set port to COM3
		
		Robot.connect();
		
		//Run motor on channel 0 at speed 400 for 2000 milliseconds
		//r.runPCAMotor(1, 400, 2000);`

		//Run motor on channel 1 at speed 250 for infinite time
		//r.runPCAMotor(2, 250, 0);

		//Runs a motor on channel 2 at speed 100 and a motor on channel 3 at speed -200 for 5000 milliseconds
		//.runTwoPCAMotor(7, -400, 5, 400, 5000);
		if(test==1) {
			contrun();
		}
		else
			Robot.runTwoPCAMotor(motor1pin, speed1, motor2pin, speed2, time);
		Robot.close();
	}
	public static void distancemove() {
		
		//Runs a motor on channel 2 at speed 100 and a motor on channel 3 at speed -200 for 5000 milliseconds
		
		
	}
	public static boolean ping() {
		//for (int x=0; x < 20; ++x)
	//	{
		System.out.println(Robot.getPing(Pingpin));
			if(Robot.getPing(Pingpin)<20)
				return true;
			//Robot.sleep(300);
		//}
		return false;
		
	}
	public static void contrun() {
		while(!ping()) {
			Robot.runTwoPCAMotor(motor1pin, speed1,motor2pin,speed2, 5);
		}
		Robot.allPCAStop();
	}
 	public static void turn() {
		if (ping(20)==true) {
			Robot.runTwoPCAMotor(motor1pin, -speed1, motor2pin, speed2, 1000);
			Robot.runTwoPCAMotor(motor1pin, speed1, motor2pin, speed2, 1000);
			Robot.runTwoPCAMotor(motor1pin, speed1, motor2pin, -speed2, 1000);
			Robot.runTwoPCAMotor(motor1pin, speed1, motor2pin, speed2, 1000);
			
		}
}
