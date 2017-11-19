import junit.framework.*;

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
	   
	   public boolean isStreamOn(){
		   assertTrue(true, MockObject.testCamera());
	   }

	public int getValue1() {
		return value1;
	}

	public void setValue1(int value1) {
		this.value1 = value1;
	}

	public int getValue2() {
		return value2;
	}

	public void setValue2(int value2) {
		this.value2 = value2;
	}

	public MockObject getObj() {
		return obj;
	}

	public void setObj(MockObject obj) {
		this.obj = obj;
	}
	
}
