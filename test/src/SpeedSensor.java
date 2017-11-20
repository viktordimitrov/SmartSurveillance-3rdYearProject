
public class SpeedSensor {
	
	private int left_counter;
	private int right_counter;
	
	public SpeedSensor(){
		left_counter = 0;
		right_counter = 0;
	}
	
	public void process(){
		left_counter = 40;//stub
		right_counter = 40;//stub
	}

	public int getLeft(){
		return left_counter;
	}
	
	public int getRight(){
		return right_counter;
	}
}
