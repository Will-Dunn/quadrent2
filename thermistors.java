
import rxtxrobot.*;
public class thermistors extends Main {
	//
	 

	public static void main( int numbmes)
    {  
		int tempsum=0;
		for(int x=0;x<numbmes;x++) {
			AnalogPin temp = Robot.getAnalogPin(0);
			tempsum+=temp.getValue();
			//temp reading takes 3 seconds max
			Robot.sleep(3000/numbmes);
			
			
		}
		double tempc=-.4127*(tempsum/numbmes)+65.99+2;
		System.out.println("the temperature is: " + tempc );
	
}
}
