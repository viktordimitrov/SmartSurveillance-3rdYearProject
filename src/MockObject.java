/* MockObject class replicates the behavior of:
 * the Android Application, Server, Camera, Motor and Ultrasonic Sensor
 * 
 */

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class MockObject {
	
	// camera
	protected boolean streamOn = true;

	// android
	private static final String VALID_URL = "http://www.google.com";
	private static final String INVALID_URL = "http://invalid.url.doesnotexist987.com";
	  
	////////////////////////////////////////////////
	class testPing{
		public String testValid_URL(){
			return VALID_URL;
		}
		
	}
	
	public String isvalidURL() {
		return VALID_URL;
	}
	
	public static String getValidUrl() {
		return VALID_URL;
	}

	public static String getInvalidUrl() {
		return INVALID_URL;
	}

	
	///////////////////////////////////////////
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
