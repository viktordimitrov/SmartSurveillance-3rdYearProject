import junit.framework.*;
import org.junit.*;
import static org.junit.Assert.assertEquals;

// methods for server tests
public class Server extends TestCase {
	  protected int value1, value2;
	   
	   // assigning the values
	   protected void setUp(){
	      value1 = 3;
	      value2 = 3;
	   }

	   // test method to add two values
	   public void testAdd(){
	      double result = value1 + value2;
	      assertTrue(result == 6);
	   }
	   
	   ///////////////////////////
	   
	   MockObject obj = new MockObject();
	   
	   public void testStreamOn(){
		   assertEquals(true, obj.isStreamOn());
	   }
	
}
