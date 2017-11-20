import java.net.DatagramPacket;

public class packet {

	private SpeedSensor s;
	private DatagramPacket Packet;
	
	public packet(){
		s=new SpeedSensor();
	}
	
	public DatagramPacket process(){
		s.process();
		int l = s.getLeft();
		int r = s.getRight();
		byte[] data = new byte[3];
		data[0] = 's';
		data[1] = (byte) l;
		data[2] = (byte) r;
		
		Packet = new DatagramPacket(data, 3);
		return Packet;
	}
}
