//scans for beacons




import rxtxrobot.ArduinoNano;
import rxtxrobot.RFIDSensor;
import rxtxrobot.RXTXRobot;
public class IRReadOut extends Main{
	public static char Tag;
	public static void main(String[] Args) {
		//ScanIR();
		
	}
	public static char ScanIR(char target) {
	
		Robot.refreshDigitalPins();
	
		char tag= Robot.getIRChar();
		if(tag!='K'&&tag!='G'&&tag!='V'&&tag!='N'&&tag!='S'&&tag!='M'|| tag==target) {
			return 0;}
		//sets global Tag to be the tag
		Tag=tag;
		//returns tag
		return tag;
		
		
		
		
		
	}

}
