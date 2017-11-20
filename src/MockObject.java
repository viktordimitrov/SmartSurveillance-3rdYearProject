/* MockObject class replicates the behavior of:
 * the Android Application, Server, Camera, Motor and Ultrasonic Sensor
 * 
 */

import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.io.File;



public class MockObject {
	
	// camera
	protected boolean streamOn = true;

	// android
	private static String VALID_URL = "http://www.google.com";
	private static String INVALID_URL = "";
	
	//server
	public boolean databaseCreated = true;
	  
	////////////////////////////////////////////////
	// App
	
	public String isvalidURL() {
		return VALID_URL;
	}
	
	public String isInvalidURL() {
		return INVALID_URL;
	}

	
	///////////////////////////////////////////
	// server
	// https://stackoverflow.com/questions/19016363/java-creating-tables-in-mysql-database
	
	 public boolean isDatabaseAvaialable(){
		   File tmpDir = new File("c:\\userinfo.ibd");
		   boolean exists = tmpDir.exists();
		   return exists;
	 }
	
	/////////////////////////////////////////
	// camera
	public boolean isStreamOn() {
		return streamOn;
	}
	
	//////////////////////////////////////////////
	
	
	
	
	class testMotor{
		
	}
	
	class testSensor{
		
	}
	
	
	
}
