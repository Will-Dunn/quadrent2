/*
 * Conductivity class 
 * Holds the code for getting the conductivity of the 
 */
import rxtxrobot.*;
public class Conductivity extends Main{
	//
	 

	public static void main( )
    {    
		//refreshes pin data
		Robot.refreshAnalogPins(); // Cache the Analog pin information
		Robot.refreshDigitalPins();
		//x is the adc code
		int x=Robot.getConductivity();
		//converts to percentages
		double tempc=-0.0393*x + 40.778;
		
		//prints it out 
		System.out.println("the percentage is: " + tempc +"%");

}
}
