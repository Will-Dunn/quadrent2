
import rxtxrobot.*;
public class inclinometer extends Main{
	//
	 

	public static void main( int numbmes)
    {    
		

		Robot.refreshAnalogPins(); // Cache the Analog pin information
		int inclinesum=0;
		for(int x=0;x<numbmes;x++) {
			AnalogPin temp = Robot.getAnalogPin(1);
			inclinesum+=temp.getValue();
			//temp reading takes 3 seconds max
			Robot.sleep(3000/numbmes);
			
			
		}
		double x=(inclinesum/numbmes);
		double tempi= -0.1553*x + 59.585;
		
		System.out.println("the incline is: " + tempi);
	
}
}
