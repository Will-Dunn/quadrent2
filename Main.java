
import rxtxrobot.*;
public class Main {
	private static int test=0;
	//our robots current heading or angle
	private static int heading=0;
	
	//beacon 1 2 3 are the beacons that will be scaned by the robot;
	private static beacon beacon1;
	private static beacon beacon2;
	private static beacon beacon3;
	private static int a1;
	private static int a2;
	private static int a3;
	private static double a1_2;
	private static double a2_3;
	private static int[] distances=new int[3];
	private static boolean b1d=false;
	private static boolean b2d=false;
	private static beacon b1;
	private static beacon b2;
	private static beacon b3;
	public static Servomotors IRServo;
	public static double[] soln = new double[2];
	//x and y are robots x and y corrdinats 
	
	private static int x;
	private static int y;
	//desx and desy our are target x and y
	private static double desx;
	private static double desy;
	public static boolean done=false;
	public static RXTXRobot Robot = new ArduinoNano();
	//general direction of desired heading up being 90/ left being 180/ down being 270, right being 0
	private static int direction=90;
	//private static int heading=85;
	//private static Servomotors Irmotor=new Servomotors(); 
	private static double[] cord= new double[2];
	public static void main(String[] args) {
		Robot.setPort("/dev/tty.usbmodem14101");
		Robot.connect();
		//one of these two is run during tests
		//RunMotors.distanceMove(32, 1);
		//RunMotors.turnRightByAngle(102);
		//Quadrent1_2();	
		//Quadrent3_4();
		//System.out.print(IRReadOut.ScanIR(' '));
		//angleBetween(' ',180);
		//
		//Servomotors.rotate(10, 10);
		//Robot.sleep(10000);
		//Servomotors.rotate(10, 10);
		//Robot.sleep(1000);
		//Servomotors.rotate(10, 170);
		//bumpSensor bumpity=new bumpSensor(7);
		//bumpity.bumped();
		quadrent1();
	//	RunMotors.distanceMove(10, 1);
		
		//System.out.println("heading is: "+curAngle());
		
		Robot.close();
		
}
	public static void location(double angle2, double angle1) {
		Navigation nav;
		int value;
		
		nav = new Navigation();
		 nav.setAngles(angle1,angle2);
		 value = nav.newton_raphson();
		
		    if (value == Navigation.RETURN_SUCCESS) {
		// Retrieve solution of coordinates
		      soln = nav.getSolution();
		      soln[0]-=Math.abs(b2.x);
		      soln[1]-=Math.abs(b2.y);
		      
		      System.out.println("(x,y) coordinates of robot = (" +
		                         soln[0] + "," + soln[1] + ")");
		    }
		    else if (value == Navigation.RETURN_RANGE) {
		      System.err.println("Angle out of range");
		    }
		    else if (value == Navigation.RETURN_SINGULAR) {
		      System.err.println("Singular Jacobian matrix");
		    }
		    else if (value == Navigation.RETURN_DIVERGENCE) {
		      System.err.println("Convergence failure in 100 iterations");
		    }
	}
	
	public static void angleBetween(char previous,int a) {
		 b1=findBeacon1(' ',180);
		 b2=findBeacon2(b1.charr,b1.angle);
		 b3=findBeacon3(b2.charr,b2.angle);
		//b=findBeacons();
		// a1 = b1.angle;
		// a2 = beacon2.angle;
		 a1_2= a1-a2;
		 a2_3= a2-a3;
		System.out.println("Angle Between 1-2:  "+a1_2);
		System.out.println("Angle Between 2-3:  "+a2_3);
		//return anglebetween;
		
	}
	public static beacon[] findBeacons() {
		beacon[] b=new beacon[3];
		b[0]=findBeacon1(' ',180);
		b[1]=findBeacon2(b[0].charr,b[0].angle);
		b[2]=findBeacon2(b[1].charr,b[1].angle);
		return b;
	}
	
	public static beacon findBeacon1(char target,int a) {
		beacon B = new beacon(0,'0');
		Servomotors.rotate(11, a);
		if(IRReadOut.ScanIR(target)==0) {
			//System.out.println("not the target");
			return findBeacon1( target, a-5);
			
		}
		else {
			System.out.println("target aquired. tag: "+IRReadOut.Tag+" Angle: "+a);
			B.charr=IRReadOut.Tag;
			B.angle=a;
			a1=B.angle;
			switch (B.charr)
			{
			case 'N':
				B.x=8;
				B.y=16;
				break;
			case 'G':
				B.x=-8;
				B.y=16;
				break;
			case 'K':
				B.x=-8;
				B.y=0;
				break;
			case 'V':
				B.x=8;
				B.y=0;
				break;
			}
			return B;
		}
	
		
	}
	public static beacon findBeacon2(char target,int a) {
		beacon B = new beacon(0,'0');
		Servomotors.rotate(11, a);
		if(IRReadOut.ScanIR(target)==0) {
			//System.out.println("not the target");
			return findBeacon2( target, a-5);
			
		}
		else {
			System.out.println("target aquired. tag: "+IRReadOut.Tag+" Angle: "+a);
			B.charr=IRReadOut.Tag;
			B.angle=a;
			a2=B.angle;
			switch (B.charr)
			{
			case 'N':
				B.x=8;
				B.y=16;
				break;
			case 'G':
				B.x=-8;
				B.y=16;
				break;
			case 'K':
				B.x=-8;
				B.y=0;
				break;
			case 'V':
				B.x=8;
				B.y=0;
				break;
			}
			return B;
		}
		
	}
	public static beacon findBeacon3(char target,int a) {
		beacon B = new beacon(0,'0');
		Servomotors.rotate(11, a);
		if(IRReadOut.ScanIR(target)==0) {
			//System.out.println("not the target");
			return findBeacon3( target, a-5);
			
		}
		else {
			System.out.println("target aquired. tag: "+IRReadOut.Tag+" Angle: "+a);
			B.charr=IRReadOut.Tag;
			B.angle=(a);
			a3=B.angle;
			switch (B.charr)
			{
			case 'N':
				B.x=8;
				B.y=16;
				break;
			case 'G':
				B.x=-8;
				B.y=16;
				break;
			case 'K':
				B.x=-8;
				B.y=0;
				break;
			case 'V':
				B.x=8;
				B.y=0;
				break;
			}
			return B;
		}
		
	}
	public static int curAngle() {
		int angle=0;
		int b1F90=90-(b1.angle-180);
		int b1AFO=(int)Math.atan2(b1.y,b1.x);
		angle=b1AFO-b1F90;
		
		
		return angle;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void quadrent1() { 
		RunMotors.distanceMove(3, 1);
		angleBetween(' ',180);
		location(a1_2,a2_3);
		x=(int) soln[0];
		y=(int) soln[1];
		heading=curAngle();
		if(x<14){
			while(heading!=0) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
				Robot.sleep(10);
			}
			RunMotors.distanceMove((14-x), 1);
			
		}
		if(x>14) {
			while(heading!=180) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((x-14), 1);
			
			
		}
		if(y<3) {
			while(heading!=90) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((3-y), 1);
			
		}
		if(y>3) {
			while(heading!=270) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((y-3), 1);
			
		}
		while(bumpSensor.bumped1()==false||bumpSensor.bumped2()==false) {
			RunMotors.timed(10,1);
		}
		Servomotors.rotate(10, 170);
		Robot.sleep(500);
		thermistors.main(10);
		Robot.sleep(1000);
		Servomotors.rotate(10, 10);
		Robot.sleep(500);
		RunMotors.distanceMove(1, -1);
		angleBetween(' ',180);
		location(a1_2,a2_3);
		x=(int) soln[0];
		y=(int) soln[1];
		if(x<(16+5)){
			while(heading!=0) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
				Robot.sleep(10);
			}
			RunMotors.distanceMove((5-x), 1);
			
		}
		if(x>(16+5)) {
			while(heading!=180) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((x-5), 1);
			
			
		}
		if(y<(16+5)) {
			while(heading!=90) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((5-y), 1);
			
		}
		if(y>(16+5)) {
			while(heading!=270) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((y-5), 1);
			
		}
		while(heading!=225) {
			RunMotors.turnRightByAngle(5);
			heading=curAngle();
		}
			RunMotors.distanceMove(10, 1);
		
		

		
		
	}
	public static void quadrent2() { 
		RunMotors.distanceMove(3, 1);
		angleBetween(' ',180);
		location(a1_2,a2_3);
		x=(int) soln[0];
		y=(int) soln[1];
		heading=curAngle();
		if(x<6){
			while(heading!=0) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
				Robot.sleep(10);
			}
			RunMotors.distanceMove((14-x), 1);
			
		}
		if(x>6) {
			while(heading!=180) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((x-14), 1);
			
			
		}
		if(y<8) {
			while(heading!=90) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((3-y), 1);
			
		}
		if(y>8) {
			while(heading!=270) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((y-3), 1);
			
		}
		while(bumpSensor.bumped1()==false||bumpSensor.bumped2()==false) {
			RunMotors.timed(10,1);
		}
		Servomotors.rotate(10, 170);
		Robot.sleep(500);
		Conductivity.main();
		Robot.sleep(1000);
		Servomotors.rotate(10, 10);
		Robot.sleep(500);
		RunMotors.distanceMove(1, -1);
		angleBetween(' ',180);
		location(a1_2,a2_3);
		x=(int) soln[0];
		y=(int) soln[1];
		if(x<5){
			while(heading!=0) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
				Robot.sleep(10);
			}
			RunMotors.distanceMove((5-x), 1);
			
		}
		if(x>5) {
			while(heading!=180) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((x-5), 1);
			
			
		}
		if(y<5) {
			while(heading!=90) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((5-y), 1);
			
		}
		if(y>5) {
			while(heading!=270) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((y-5), 1);
			
		}
		while(heading!=225) {
			RunMotors.turnRightByAngle(5);
			heading=curAngle();
		}
			RunMotors.distanceMove(10, 1);
		
		

		
		
	}
	public static void quadrent3() {
		RunMotors.distanceMove(3, 1);
		angleBetween(' ',180);
		location(a1_2,a2_3);
		x=(int) soln[0];
		y=(int) soln[1];
		heading=curAngle();
		if(x<5){
			while(heading!=0) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
				Robot.sleep(10);
			}
			RunMotors.distanceMove((5-x), 1);
			
		}
		if(x>5) {
			while(heading!=180) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((x-5), 1);
			
			
		}
		if(y<5) {
			while(heading!=90) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((5-y), 1);
			
		}
		if(y>5) {
			while(heading!=270) {
				RunMotors.turnRightByAngle(15);
				heading=curAngle();
			}
			RunMotors.distanceMove((y-5), 1);
			
		}
		while(heading!=45) {
			RunMotors.turnRightByAngle(5);
			heading=curAngle();
		}
			RunMotors.distanceMove(5, 1);
			inclinometer.main(10);
			RunMotors.holdpos(3000);
			RunMotors.distanceMove(5, 1);
			RunMotors.turnRightByAngle(180);
			Robot.sleep(1000);
			Servomotors.rotate(9, 170);
			Robot.sleep(1000);
			Servomotors.rotate(9, 10);
			
			
			
		
		
	}
	
	public static void quadrent4() { 
		RunMotors.distanceMove(3, 1);
		angleBetween(' ',180);
		location(a1_2,a2_3);
		x=(int) soln[0];
		y=(int) soln[1];
		heading=curAngle();
		while(bumpSensor.bumped1()==false) {
			RunMotors.timed(10,1);
		}
		RunMotors.timed(50,-1);
		Robot.allPCAStop();
		RunMotors.turnRightByAngle(90);
		int rt=RunMotors.ping();
		RunMotors.turnLeftByAngle(170);
		int lt=RunMotors.ping();
		if(rt>=lt) {
			RunMotors.turnRightByAngle(180);
		}
		while(bumpSensor.bumped1()==false) {
			RunMotors.timed(10,1);
		}
		
	}
	
}

