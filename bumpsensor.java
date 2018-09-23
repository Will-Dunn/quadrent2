//this program determines if the bump sensor is triggered
import rxtxrobot.*;

public class bumpsensor {
	public static void main(String[] args) {
		int control; 
		
		RXTXRobot r = new ArduinoNano(); 
		r.setPort("COM5");
		
		r.refreshAnalogPins(); //Cache the analog pins information
		
		AnalogPin bump = r.getAnalogPin(/*wire to specific pin*/);
		System.out.println("Sensor bump" + x + "has value: " + bump.getValue() );
		r.close();
		//determine if something is touching bump sensro
		
		while (//bump sensor = activated) 
				{
				control = 0; }
		while (//bump sensor == not activated)
				{
					control = 1;
				}
		
		
		
	}
}
