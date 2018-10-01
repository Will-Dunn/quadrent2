

import rxtxrobot.*;
public class Servomotors extends Main {
	public static RXTXRobot Robot = new ArduinoNano();
	
	public static void main(String[] args, int a) {
		rotate(0);
		rotate(a);
		rotate(0);
	}
	public static void rotate(int angle) {
		//robot is the Arduino board instantiated in Main class
		//sets com port 3 to be input port
		Robot.setPort("COM5");
		Robot.setVerbose(true); //debugging
		Robot.connect();
		//servo is to be wired to digital pin 11
		Robot.attachServo(RXTXRobot.SERVO1, 11);//connects the servo's format is the servo's name followed by pin #
		//rotates to angle a for time specified by var timeatangle  
		Robot.runPCAServo(11, angle );
		//closes out of robot
		Robot.close();
	}
}
