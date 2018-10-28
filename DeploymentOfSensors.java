import rxtxrobot.*;

public class DeploymentOfSensors {
	public static RXTXRobot Robot = new ArduinoNano();
	public static Servomotors servo = new Servomotors();//creates an object for the servo motors 
	
	public static void DeployByAngle (int angle) {
		servo.RunServo(angle);
		//servo.main(null, angle);
		
	}
}
