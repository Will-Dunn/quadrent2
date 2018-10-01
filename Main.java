
public class Main {
	private static int test=0;
	private static int a=0;
	//private static Servomotors Irmotor=new Servomotors(); 
	public static void main(String[] args) {
		switch(test)
		{
		//Rotate servo motor to angle a where it will then rotate back
		case 0:
			//a is the angle
			Servomotors.main(args, a);
			break;
		//Read IR sensor
		case 1:
			IRReadOut.main(args);
			break;
		//Move forward 3 meters
		case 2:
			//0 is test type.
			RunMotor.main(args,0);
			break;
		//run motor until ping sensor is trigered.
		case 3:
			//1 is test type
			RunMotor.main(args,1);
			break;
		//get temp
		case 4:
			//10 indicates that the thermistor will take 10 measurments in 3 seconds that will be averaged out and converted to degrees C
			thermistors.main(args,10);
			break;
		case 5:
			break;
			
	}
}
}

