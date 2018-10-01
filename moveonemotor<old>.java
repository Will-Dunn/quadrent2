//this program runs one DC motor forward at max speed for 5 seconds
import rxtxrobot.*;

public class moveonemotor {
	public static void main(String[] args) {
		RXTXRobot r = new ArduinoNano(); //creates robot object
		r.setPort("COM3");
		r.connect();
		
		r.runMotor(RXTXRobot.MOTOR1, 125, 500); // Run motor 1 forward (speed of 125) for 5 seconds
		r.close(); //exits the run command 
	}
}
 
/*
From the examples folder:
// This example shows how to move only one DC motor.  
The motor will run for the specified time, 
which pauses the execution of the program until the motor stops.
import rxtxrobot.*;

public class RunOneMotor
{
	public static void main(String[] args)
	{
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object
		r.setPort("COM3"); // Set port to COM3
		r.connect();
		
		r.runMotor(RXTXRobot.MOTOR1, 125, 500); // Run motor 1 forward (speed of 125) for 5 seconds
		// Program stops until the command above is completed (5 seconds)
		r.runMotor(RXTXRobot.MOTOR1, -125, 300); // Run motor 1 backward (speed of 125) for 3 seconds
		r.close();
	}
}

*/
