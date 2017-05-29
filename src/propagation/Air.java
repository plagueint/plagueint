package propagation;

public class Air extends Border{

	public Air(boolean opened, float freqRate, float crossingTime, float hygieneRate) {
		super(opened, freqRate, crossingTime, hygieneRate);
	}
	
	public Air(){
		super();
	}
	
	@Override
	public String getMenuName(){
		return "aérienne";
	}
}
