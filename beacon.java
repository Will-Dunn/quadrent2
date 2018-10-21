
public class beacon {
	public static int angle;
	public static int x;
	public static int y;
	public static String charr;
	
	public beacon(int a,String b) {
		angle=a;
		charr=b;
		if(b.equals("G")) {
			x=-8;
			y=16;
		}
		if(b.equals("N")) {
			x=8;
			y=16;
		}
		if(b.equals("K")) {
			x=-8;
			y=0;
		}
		if(b.equals("V")) {
			x=8;
			y=0;
			
		}
		}
		//x=xpos;
		//y=ypos;
		
	}
	public static double dist(beacon oB) {
		double xdif=x-oB.x;
		double ydif=y-oB.y;
		double hypot=Math.pow(Math.pow(xdif, 2)+Math.pow(ydif, 2),.5);
		
		/*if(charr.equals("a")) {
			if(oB.charr.equals("b")||oB.charr.equals("b")||)
			/*switch(oB){
			case "b":
				return 8.0;
			case "c":
				return 16.0;
			case "d":
				return 22.627417;
			case "e":
				return 35.77708764;
			case "f":
				return 32.984845;
			case "g":
				return 32.0;
			case "h":
				return 16.0;
			
				
			
			}
		}
		if(charr.equals("b")) {
			switch(oB){
			case "a":
				return 8.0;
			case "c":
				return 8.0;
			case "d":
				return 17.88854382;
			case "e":
				return 32.984845;
			case "f":
				return 32;
			case "g":
				return 32.984845;
			case "h":
				return 17.88854382;
			
				
			
			}
	}
		if(charr.equals("c")) {
			switch(oB){
			case "a":
				return 16.0;
			case "b":
				return 8.0;
			case "d":
				return 16;
			case "e":
				return 32;
			case "f":
				return 32.984845;
			case "g":
				return 35.77708764;
			case "h":
				return 22.627417;
			
				
			
			}
	}
		if(charr.equals("d")) {
			switch(oB){
			case "a":
				return 22.627417;
			case "b":
				return 17.88854382;
			case "c":
				return 8;
			case "e":
				return 16;
			case "f":
				return 17.88854382;
			case "g":
				return 22.627417;
			case "h":
				return 16;
			
				
			
			}
	}
		if(charr.equals("h")) {
			switch(oB){
			case "c":
				return 22.627417;
			case "b":
				return 17.88854382;
			case "a":
				return 8;
			case "g":
				return 16;
			case "f":
				return 17.88854382;
			case "e":
				return 22.627417;
			case "d":
				return 16;
			
				
			
			}
	}
		if(charr.equals("g")) {
			switch(oB){
			case "f":
				return 8.0;
			case "e":
				return 16.0;
			case "d":
				return 22.627417;
			case "c":
				return 35.77708764;
			case "b":
				return 32.984845;
			case "h":
				return 16.0;
			case "a":
				return 32.0;
			
				
			
			}
		}
		if(charr.equals("f")) {
			switch(oB){
			case "g":
				return 8.0;
			case "e":
				return 8.0;
			case "d":
				return 17.88854382;
			case "c":
				return 32.984845;
			case "b":
				return 32;
			case "a":
				return 32.984845;
			case "h":
				return 17.88854382;
			
				
			
			}
	}
		if(charr.equals("e")) {
			switch(oB){
			case "g":
				return 16.0;
			case "f":
				return 8.0;
			case "d":
				return 16;
			case "c":
				return 32;
			case "b":
				return 32.984845;
			case "a":
				return 35.77708764;
			case "h":
				return 22.627417;
			
				
			
			}
	}*/
		return hypot;

}
}
