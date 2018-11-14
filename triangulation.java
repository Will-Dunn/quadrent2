/*	Abandon all hope ye who enter here
 * your sanity shall fade and confusion shall grow
 * hours will fade by as your nights dwindle
 * leaving you exhausted and broken
 * for here lies Math work full of sadness and dispair
 * 
 */
public class triangulation {
	//Make 3 instances of Beacon
	private static beacon[] beacons=new beacon[3];
	public static int a=10;
	public static double x;
	public static double y;
	public static char temptag;
	
	//Make an instance of servo
	public  triangulation() {
		
		//call FindAngles method
		//a is the starting angle, i is the current beacon we are finding 1,2 or 3
		//iterate through the angle finding method 
		for(int i=0;i<3;i++) {
			//temp holds the returned angle for the next two lines
			int temp=FindAngles(a);
			//beacon 1,2,3 has its angle set to temp;
			beacons[i]=new beacon(temp,temptag);
			
			//global variable a is set to the returned angle with increased by 10;
			a=temp+10;
				}
		//Math();

	}
	public int FindAngles(int angle) {
		
		//check for a beacon tag if one is found return angle;
		Servomotors.rotate(angle);
		if(IRReadOut.ScanIR()=='G'||IRReadOut.ScanIR()=='N'||IRReadOut.ScanIR()=='V'||IRReadOut.ScanIR()=='K') {
			temptag=IRReadOut.tag;
			System.out.println(angle);
			return angle;
		}
		
		return (FindAngles(angle+10));
		
		
		
		
	}
	
	public void Trig() {
		//distance between beacon 1 and beacon 2
		int D1 = ( beacons[1].x - beacons[2].x ) + ( beacons[1].y - beacons[2].y );
		//distance between beacon 2 and beacon 3
		int D2 = ( beacons[2].x - beacons[3].x ) + ( beacons[2].y - beacons[3].y );
		//angle between 1st beacon and 3rd beacon or total angle
		double ΘT = Math.toRadians( beacons[3].angle - beacons[1].angle );
		//angle between 2nd beacon and 1st beacon
		double Θ1 = Math.toRadians( beacons[2].angle - beacons[1].angle );
		//angle between 3rd beacon and 2nd beacon
		double Θ2 = Math.toRadians( beacons[3].angle - beacons[2].angle );
		//angle we solve for first 
		double α1 = Math.atan(1 / Math.tan((Math.sin(Θ1)/Math.sin(Θ2)+Math.cos(360-90-ΘT))/Math.sin(360-90-ΘT)));
		//angle of the other triangle
		double α2 = 360-90-ΘT-α1;
		//last angle of first triangle
		double α3 = 180-Θ1-α1;
		//last angle of the second triangle 
		double α4 = 180-Θ2-α2;
		//distance from middle beacon
		double r  = (D1*Math.sin(α1))/Math.sin(Θ1);
		//last side length;
		double a  = (D1*Math.sin(α3))/Math.sin(Θ1);
		//gets our x corrdiante
		 x  = a * Math.sin(Θ1-α1);
		//gets our y corrdinate
		 y  = D1 - a * Math.cos(Θ1-α1);
		
		
		
		
		
		
	}

}
