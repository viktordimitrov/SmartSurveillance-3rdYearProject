import java.sql.*;

public class Database {
   //STEP 1 : declare variables 
   //JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  		    // mySQL driver
   static final String DB_URL = "jdbc:mysql://localhost:3306/test";		// database URL

   //  Database credentials
   static final String USER = "root"; //mySQL account username
   static final String PASS = "";	//mySQL account password (password is set to null by default)
   static final String UserInfo = null;	// table name
   
   static boolean tableExists;	//variable declaration that states if the table exists or not
   
   
   // method that checks if the table in the database exists
   public static boolean tableExist(Connection conn, String tableName) throws SQLException {
	    DatabaseMetaData meta = conn.getMetaData(); 
	    ResultSet res = meta.getTables(null, null, tableName, null); 
	    while(res.next()){
	    	return tableExists = true;
	    }
	    return tableExists = false;
	    
	}
   
   public static void main(String[] args) {

   Connection conn = null;
   Statement stmt = null;
   
   try{
  //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

  //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      // create a connection and name it "conn"
      conn = DriverManager.getConnection(DB_URL, USER, PASS);		
      // outputs this unless if it was unsuccessful which would be caught by the error handlers
      System.out.println("Connected database successfully... \nSession started.");
      
      
   //STEP 4: Execute a query
      //Query here is a table being created in the database
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();  // creates an instance of a connection and call it "stmt"
      
      //Checks if table in database exists
      tableExists = tableExist(conn, UserInfo); 
      
      //If the table under that name exists printout this
      if (tableExists == false){
      System.out.println("Table is already created.");
      }
      
      //If the table under that name does not exist, create the table under that name 
      //and output saying that the table has been created
      if (tableExists == true){
    	  // String sql is an sql command that creates a table with the following columns
    	  String sql = "CREATE TABLE UserInfo " + //creates a table under the name "UserInfo" with 4 columns
                  "(PRIMARY KEY ( id ) , " +	  //column 1 will store the unique key for this each entry
                  " user_name VARCHAR(255), " +   //column 2 will store the user name in VARCHAR
                  " password VARCHAR(255), " + 	  //column 3 will store the password also under VARCHAR
                  " time TIMESTAMP not NULL))";   //column 4 stores the time the entry was added to the database

	      //The sql string is then passed through as a statement through the 
	      //established connection as an SQL query for the database
	      stmt.executeUpdate(sql);	
	      
	      // if the query was not successfully executed an error will be thrown
	      System.out.println("Created table in given database."); 
      } // end if
    } // end try
   
   	  // START of error handling block
	  catch (SQLException sqlException){
		  System.out.println("A connection could not be made with the database.");
	  }catch (ClassNotFoundException e){
	       // No driver class found!
	  }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	  }
   //STEP 5: Close Resources
   		finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	    }//end finally
      // END of error handling block
   
	   System.out.println("Session Closed!");
	}//end main
	     
}//end Database