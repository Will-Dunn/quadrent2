
import rxtxrobot.*;
public class thermistors {
	//
	 

	public static void main(String[] args, int numbmes)
    {    
		RXTXRobot r = new ArduinoNano(); //Create RXTXRobot object

		r.setPort("COM6"); // Sets the port to COM5
	
		r.connect();

		r.refreshAnalogPins(); // Cache the Analog pin information
		int tempsum=0;
		for(int x=0;x<numbmes;x++) {
			AnalogPin temp = r.getAnalogPin(0);
			tempsum+=temp.getValue();
			//temp reading takes 3 seconds max
			r.sleep(3000/numbmes);
			
			
		}
		double tempc=-.4127*(tempsum/numbmes)+64;
		System.out.println("the temperature is: " + tempc );
		r.close();
}
}
