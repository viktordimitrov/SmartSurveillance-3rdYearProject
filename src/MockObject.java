/* MockObject class replicates the behavior of:
 * the Android Application, Server, Camera, Motor and Ultrasonic Sensor
 * 
 */

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class MockObject {
	protected boolean streamOn = true;

	  
	class testApp{
		
	}
	
	class testServer{
		
	}
	
	/////////////////////////////////////////
	class testCamera{
		public boolean testStreamOn(){
			return streamOn;
		}
		
	}
	public boolean isStreamOn() {
		return streamOn;
	}

	public void setStreamOn(boolean streamOn) {
		this.streamOn = streamOn;
	}
	
	//////////////////////////////////////////////
	
	
	
	
	class testMotor{
		
	}
	
	class testSensor{
		
	}

	
	
}
