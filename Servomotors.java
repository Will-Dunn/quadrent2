

import rxtxrobot.*;
public class Servomotors extends Main {
	public static RXTXRobot Robot = new ArduinoNano();
	
	public static void main(String[] args, int a) {
		Robot.setPort("COM6");	
		Robot.connect();
		
		Robot.runPCAServo(11, 10 );
		Robot.sleep(1000);
		Robot.runPCAServo(11, a );
		Robot.sleep(1000);
		Robot.runPCAServo(11, 10 );
		Robot.sleep(1000);
		Robot.close();
	}
	public static void rotate(int angle) {
		//robot is the Arduino board instantiated in Main class
		//sets com port 3 to be input port
		
		//Robot.setVerbose(true); //debugging
		
		//servo is to be wired to digital pin 11
		//Robot.attachServo(RXTXRobot.SERVO1, 11);//connects the servo's format is the servo's name followed by pin #
		//rotates to angle a for time specified by var timeatangle  
		
		//closes out of robot
		//Robot.close();
	}
}
