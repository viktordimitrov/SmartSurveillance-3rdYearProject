
import java.net.DatagramPacket;
import org.junit.*;
import junit.framework.*;

public class test extends TestCase{
	protected DatagramPacket testPacket;
	protected packet p;
	//protected DatagramPacket origPacket;
	protected int speed = 40;
	protected SpeedSensor ss;
	
	protected void setUp(){
		ss = new SpeedSensor();
		ss.process();
		
		p = new packet();
		//origPacket = p.process();
	}
	
	/*public void testPack(){
		byte[] ddata = new byte[3];
		int a = 40;
		int b = 40;
		ddata[0] = 's';
		ddata[1] = (byte) a;
		ddata[2] = (byte) b;
		//testPacket = new DatagramPacket(ddata, 3);
		assertEquals(ddata, p.process().getData());
	}*/
	public void testleft(){
		int ll = ss.getLeft();
		assertEquals(speed, ll);	
	}
	public void testright(){
		int rr = ss.getRight();
		assertEquals(speed, rr);
	}

}
