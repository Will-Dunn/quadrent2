
/* The beacon class acts as a way to store a beacon objects data
 * This data includes its x and y cordinates and its tag, and its angle from the robot's IR sensor's starting possition 
 * in addition this class has a method to calculate the distance between itself and a second beacon passed to it when the methods called
 */
public class beacon {
	public static int angle;
	public static int x;
	public static int y;
	public static char charr;
	
	public  beacon(int a,char b) {
		angle=a;
		charr=b;
		if(b=='G') {
			x=-8;
			y=16;
		}
		if(b=='N') {
			x=8;
			y=16;
		}
		if(b=='K') {
			x=-8;
			y=0;
		}
		if(b=='V') {
			x=8;
			y=0;
			
		}
		}
		
		
	
	public static double dist(beacon oB) {
		double xdif=x-oB.x;
		double ydif=y-oB.y;
		double hypot=Math.pow(Math.pow(xdif, 2)+Math.pow(ydif, 2),.5);
			return hypot;

}
}
