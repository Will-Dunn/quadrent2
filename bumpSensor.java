import rxtxrobot.DigitalPin;

public class bumpSensor extends Main {
	private static int Pin1=7;
	private static int Pin2=8;
	public void main() {
	
	}
	public static boolean bumped1() {
		Robot.refreshDigitalPins();
		DigitalPin i=Robot.getDigitalPin(Pin1);
		int b=i.getValue();
		if(b==0) {
			return true;
		}
		return false;
		
	}
	public static boolean bumped2() {
		Robot.refreshDigitalPins();
		DigitalPin i=Robot.getDigitalPin(Pin1);
		int b=i.getValue();
		if(b==0) {
			return true;
		}
		return false;
		
	}
}
