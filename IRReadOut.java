
import rxtxrobot.ArduinoNano;
import rxtxrobot.RFIDSensor;
import rxtxrobot.RXTXRobot;

public class IRReadOut {
	public static void main(String[] Args) {
		ScanIR();
		System.out.println("2");
	}
	public static void ScanIR() {
		RXTXRobot Robot = new ArduinoNano();
		//RFIDSensor IR= new RFIDSensor(); //makes IR sensors object named IR
		Robot.setPort("COM6");
		Robot.connect();
		//until it has a found a beacon it sleeps
		System.out.println("hi");
		//for(int i=1; i<=50; i++) {
			//System.out.println(IR.getTag());
			//refreshDigialPins();
			
		//	IR.sleep(300);
		//}
		Robot.refreshDigitalPins();
		//while (!IR.hasTag()) {
			//System.out.println("hi");
			//IR.sleep(300);}
		//once beacon if found prints out its tag and its angle 
		//System.out.println("tag: "+ IR.getTag()+" at angle: "+cur_angle);
		//String tag =IR.getTag();
		//System.out.println(IR.getTag());
		System.out.println(Robot.getIRChar());
		Robot.close();
		//return tag;
		
		
		
		
		
		
		
	}

}
