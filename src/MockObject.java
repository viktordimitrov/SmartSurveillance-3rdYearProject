/* MockObject class replicates the behavior of:
 * the Android Application, Server, Camera, Motor and Ultrasonic Sensor
 * 
 */

import static org.easymock.EasyMock.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;

public class MockObject {

	
	String message = "Hello World";	
	   MessageUtil messageUtil = new MessageUtil(message);

	   @Test
	   public void testPrintMessage() {	  
	      assertEquals(message,messageUtil.printMessage());
	   }
	  
	class testApp{
		
	}
	
	class testServer{
		
	}
	
	class testCamera{
		
	}
	
	class testMotor{
		
	}
	
	class testSensor{
		
	}
	
}
