
import rxtxrobot.RFIDSensor;

public class IRReadOut {
	public static void main(String[] Args) {
		System.out.println(ScanIR());
	}
	public static String ScanIR() {
		RFIDSensor IR= new RFIDSensor(); //makes IR sensors object named IR
		IR.setPort("COM5");
		IR.connect();
		//until it has a found a beacon it sleeps
		while (!IR.hasTag())
			return("");
		//once beacon if found prints out its tag and its angle 
		//System.out.println("tag: "+ IR.getTag()+" at angle: "+cur_angle);
		String tag=IR.getTag();
		IR.close();
		return tag;
		
		
		
		
		
		
		
	}

}
