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
	private static String VALID_URL = "http://www.google.com";
	private static String INVALID_URL = "";
	  
	////////////////////////////////////////////////
	class testPing{
		public String testValid_URL(){
			return VALID_URL;
		}
		public String testINValid_URL(){
			return INVALID_URL;
		}
		
	}
	
	public String isvalidURL() {
		return VALID_URL;
	}
	
	public void setValidURL(String VALID_URL) {
		this.VALID_URL = VALID_URL;
	}
	
	public String isInvalidURL() {
		return INVALID_URL;
	}
	
	public void setINValidURL(String INVALID_URL) {
		this.INVALID_URL =INVALID_URL;
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
