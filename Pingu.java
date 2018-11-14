import rxtxrobot.*;

public class Pingu
{
	final private static PING_PIN = 12;

	public void man()
	{
		RXTXRobot r = new ArduinoNano(); // Create RXTXRobot object
		r.setPort("COM3"); // Set the port to COM3
		r.connect();
		for (int x=0; x < 100; ++x)
		{
			//Read the ping sensor value, which is connected to pin 12
			System.out.println("Response: " + r.getPing(PING_PIN) + " cm");
			r.sleep(300);
		}
		r.close();
	}
}