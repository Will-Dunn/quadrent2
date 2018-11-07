import rxtxrobot.*;

public class bumpsensor extends Main {
	
	
	public boolean getBumpSensor() {
		int a = getAnalogPin(int data);
		//if a is within certain tolerance of value the bump sensor is triggered by returning false
		if(Math.abs(a - value) <= tolerance) { //TOFIX:Insert Value:Insert tolerance
			return false; 
		}
		return true;
	
	}
}
