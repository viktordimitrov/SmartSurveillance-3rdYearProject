import java.sql.*;

public class sampleDatabase {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost:3306/test";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "";
   static final String UserInfo = null;
   static boolean tableExists;
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      //checks if table in database exists
      tableExists = tableExist(conn, UserInfo);
      
      //if table exists printout this
      if (tableExists = false){
      System.out.println("Table is already created.");
      }
      
      //if table does not exist do this
      if (tableExists = true){
    	  String sql = "CREATE TABLE UserInfo " +
                  "(id TIMESTAMP not NULL, " +
                  " user_name VARCHAR(255), " + 
                  " password VARCHAR(255), " + 
                  " PRIMARY KEY ( id ))"; 

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
      }
      
      
   }
     catch (SQLException sqlException) {
       if (sqlException.getErrorCode() == 1007) {
           // Database already exists error
           System.out.println("Database is already created");
       } else {
           // Some other problems, e.g. Server down, no permission, etc
           sqlException.printStackTrace();
       }
   } catch (ClassNotFoundException e) {
       // No driver class found!
   }
   
   catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
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
   }//end try
   System.out.println("Goodbye!");
}//end main
   
   public static boolean tableExist(Connection conn, String tableName) throws SQLException {
	    boolean tExists = false;
	    try (ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null)) {
	        while (rs.next()) { 
	            String tName = rs.getString("UserInfo");
	            if (tName != null && tName.equals(tableName)) {
	                tExists = true;
	                break;
	            }
	        }
	    }
	    return tExists;
	}
}//end sampleDatabase