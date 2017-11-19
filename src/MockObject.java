/* MockObject class replicates the behavior of:
 * the Android Application, Server, Camera, Motor and Ultrasonic Sensor
 * 
 */

import static org.easymock.EasyMock.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class MockObject {


	  
	class testApp{
		
	}
	
	class testServer{
		
	}
	
	class testCamera{
		public boolean testStreamOn(){
			return true;
		}
		
	}
	
	
	
	class testMotor{
		
	}
	
	class testSensor{
		
	}
	
}
