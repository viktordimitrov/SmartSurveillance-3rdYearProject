/* MockObject class replicates the behavior of:
 * the Android Application, Server, Camera, Motor and Ultrasonic Sensor
 * 
 */

import org.junit.*;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public static String getValidUrl() {
		return VALID_URL;
	}

	public static String getInvalidUrl() {
		return INVALID_URL;
	}

	
	///////////////////////////////////////////
	// server
	// https://stackoverflow.com/questions/19016363/java-creating-tables-in-mysql-database
	
	public class DbStuff {
	    private String jdbcDriver = "com.mysql.jdbc.Driver";
	    private String dbAddress = "jdbc:mysql://localhost:3306/";
	    private String userPass = "?user=root&password=";
	    private String dbName = "user_info";
	    private String userName = "root";
	    private String password = "";

	    private PreparedStatement preStatement;
	    private Statement statement;
	    private ResultSet result;
	    private Connection con;

	    public DbStuff() {
	        try {
	            Class.forName(jdbcDriver);
	            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
	        } 
	        catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } 
	        catch (SQLException e) {
	            createDatabase();
	            createTableCub1();
	        }
	    }

	    private void createDatabase() {
	        try {
	            Class.forName(jdbcDriver);
	            con = DriverManager.getConnection(dbAddress + userPass);
	            Statement s = con.createStatement();
	            int myResult = s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
	        } 
	        catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    	    	       
	    private void createTableCub1() {
	        String myTableName = "CREATE TABLE AgentDetail (" 
	            + "idNo INT(64) NOT NULL AUTO_INCREMENT,"  
	            + "initials VARCHAR(2)," 
	            + "agentDate DATE,"  
	            + "agentCount INT(64))";  
	        try {
	            Class.forName(jdbcDriver);
	            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
	            statement = con.createStatement();
	            //The next line has the issue
	            statement.executeUpdate(myTableName);
	            System.out.println("Table Created");
	        }
	        catch (SQLException e ) {
	            System.out.println("An error has occurred on Table Creation");
	        }
	        catch (ClassNotFoundException e) {
	            System.out.println("An Mysql drivers were not found");
	        }
	    }
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
