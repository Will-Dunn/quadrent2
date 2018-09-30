package quadrent2;
import rxtxrobot.*;
public class thermistors {
	public static void main(String[] args)
    {    
		RXTXRobot r = new ArduinoNano(); //Create RXTXRobot object

		r.setPort("COM5"); // Sets the port to COM5
	
		r.connect();

		r.refreshAnalogPins(); // Cache the Analog pin information

		for (int x=0; x < RXTXRobot.NUM_ANALOG_PINS; ++x)
		{
			AnalogPin temp = r.getAnalogPin(x);
			System.out.println("Sensor " + x + " has value: " + temp.getValue());
		}
		r.close();
}
}
