
public class Main {
	private static int test=0;
	private static int heading=85;
	private static int a=10;
	private static beacon beacon1;
	private static beacon beacon2;
	private static beacon beacon3;
	private static int[] distances=new int[3];
	private static boolean b1d=false;
	private static boolean b2d=false;
	private static double x;
	private static double y;
	private static int direction=90;
	//private static int heading=85;
	//private static Servomotors Irmotor=new Servomotors(); 
	public static void main(String[] args) {
		
		
		/*switch(test)
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
	*/
		
}
	public static void angles(int pos) 
	{
	
		while(IRReadOut.ScanIR().equals("")) {
			a+=5;
			Servomotors.rotate(a);
		}
		if(!IRReadOut.ScanIR().equals("")&&b1d==false) {
			beacon1=new beacon(a,IRReadOut.ScanIR());
			b1d=true;
			
			
			
		}
		if(!IRReadOut.ScanIR().equals("")&&b1d==true&&b2d==false) {
			beacon2=new beacon(a,IRReadOut.ScanIR());
			b2d=true;
			
			
			
		}
		if(!IRReadOut.ScanIR().equals("")&&b1d==true&&b2d==true) {
			beacon3=new beacon(a,IRReadOut.ScanIR());
			b2d=false;
			b1d=true;
			
			
			
		}
		
	}
	public static void triangulate() {
		/*double l1;
		double l2;
		angle 1 is equal to the middle beacons angle minus our heading 
		
		
		
		
		l1=java.lang.Math.sin(Math.toRadians(beacons[0].angle))*beacons[2].dist(beacons[1].charr)/beacons[0].dist(beacons[1].charr);
		l2=java.lang.Math.sin(Math.toRadians(beacons[1].angle))*beacons[0].dist(beacons[2].charr)/beacons[1].dist(beacons[2].charr);
		double x1=l1*Math.cos(Math.toRadians(90-beacons[1].angle));
		double x2=l2*Math.cos(Math.toRadians(90-beacons[2].angle));
		 x=16-x1-x2;
		double y1=l1*Math.sin(Math.toRadians(90-beacons[1].angle));
		double y2=l2*Math.sin(Math.toRadians(90-beacons[2].angle));
		 y=32-y1-y2;
		
	
		
	 */
		//diffrence between general direction
		int alpha=heading-direction;
		System.out.println("alpha is: "+alpha);
		//angle from heading to the left angle beacon
		int left= 90-(beacon3.angle-90);
		System.out.println("left angle is: "+left);
		//angle from heading to the right angle beacon
		int right=(beacon2.angle-beacon1.angle)-90;
		System.out.println("right angle is: "+right);
		
		int omega=180-(left+90);
		System.out.println("omega is: "+omega);
		int zeta= 180-(alpha+right+90);
		System.out.println("zeta is: "+zeta);
		double l1=(beacon1.dist(beacon2)+beacon2.dist(beacon3))*Math.sin(Math.toRadians(omega))/Math.sin(Math.toRadians(left+alpha+right));
		System.out.println("length from beacon 1 is: "+l1);
		double l2=(beacon1.dist(beacon2)+beacon2.dist(beacon3))*Math.sin(Math.toRadians(zeta))/Math.sin(Math.toRadians(left+alpha+right));
		System.out.println("length from beacon 2 is: "+l2);
		double x=Math.pow(Math.pow((beacon1.x-l1),2)+Math.pow((beacon1.y-l2),2),.5);
		System.out.println("x pos is : "+x);
		double y=Math.pow(Math.pow((beacon2.x-l1),2)+Math.pow((beacon2.y-l2),2),.5);
		System.out.println("y pos is: "+y);
		
		
		
	}
		
}

