package quadrent2;
import rxtxrobot.*;
public class IR_Sensor extends Main{
	//private static int angle=0;
	//time to stop at angle in seconds
	private static int timeatangle=1;
	private static RFIDSensor IR = new RFIDSensor();
	public static void main(String[] args) {
		for(int i=0;i<180;i+=5) {
			rotate(i);
			//angle=i;
			if(ScanIR(i)!="") {
				System.out.println(ScanIR(i));
			}
		
		}
		rotate(0);
	}
	//rotates motor to angle
	public static void rotate(int angle) {
		//robot is the Arduino board instantiated in Main class
		//sets com port 3 to be input port
		Robot.setPort("COM3");
		Robot.setVerbose(true); //debugging
		Robot.connect();
		//servo is to be wired to digital pin 9
		Robot.attachServo(RXTXRobot.SERVO1, 9);//connects the servo's format is the servo's name followed by pin #
		//rotates to angle a for time specified by var timeatangle  
		Robot.runPCAServo(9, angle , timeatangle*1000);
		//closes out of robot
		Robot.close();
	}
	//for rotate and return test only not good code
	public static void rotateandreturn(int a) {
		rotate(a);
		rotate(0);
	}
	
	//checks for IR Beacons and returns there letter and angle
	public static String ScanIR(int cur_angle) {
		//RFIDSensor IR= new RFIDSensor(); //makes IR sensors object named IR
		IR.setPort("COM5");
		IR.connect();
		//until it has a found a beacon it sleeps
		if (!IR.hasTag())
			return("");
		//once beacon if found prints out its tag and its angle 
		System.out.println("tag: "+ IR.getTag()+" at angle: "+cur_angle);
		String tag=IR.getTag();
		IR.close();
		return tag;
		
		
		
		
		
		
		
	}

}
