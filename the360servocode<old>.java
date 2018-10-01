
import rxtxrobot.*;
public class the360servocode {
	private static int speed=90;
	private static int timerot=5/speed;
	private static int servopin=11;
	private static int IRpin=4;
	private static String Tag="";
	public static RXTXRobot Robot = new ArduinoNano();
	private static RFIDSensor IR = new RFIDSensor();
	public static void main(String[] args) throws InterruptedException {
	 for(int i=0;i<360/5;i++) {
		 rotate();
		 
		 //getAngle(i);
		 if (!Tag.equals(""))
				System.out.println("Tag: " + Tag + " at Θ: "+getAngle(i));
		 }
		 
	 }
		
	
	public static int getAngle(int calls) {
		//Theta is the Angle of the servo motor.
		//calls is the number of times the method is called.
		//Theta is increased by 5 each step of the motor and this method keeps track of theta.
		int Theta=5*calls;
		return Theta;
	}
	public static void rotate() throws InterruptedException {
		/*Currently rotates motor at speed that is set at top of program. 
		 * Rotation happens for a length of time necissary to rotate 5 degrees at current speed. 
		 * variable names are Speed for motor speed/ and timerot for rotation time
		 *
		 */
		Robot.setPort("COM3");
		Robot.setVerbose(true); //debugging
		Robot.connect();
		//servo is to be wired to digital pin 9
		//rotates to 
		
		Robot.runPCAContServo(servopin,speed);
		Thread.sleep(timerot*1000);
		//closes out of robot
		Robot.close();
		
	}
	public static void IrScan() {
		IR.setPort("COM5");
		IR.connect();
		//until it has a found a beacon it sleeps
		if(!IR.hasTag()) {
			IR.sleep(300);
			}
		//once beacon if found prints out its tag and its angle 
		
		String tag=IR.getTag();
		IR.close();
		Tag=tag;
	}
}
