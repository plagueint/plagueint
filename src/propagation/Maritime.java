package propagation;

public class Maritime extends Border{

	public Maritime(boolean opened, float freqRate, float crossingTime, float hygieneRate) {
		super(opened, freqRate, crossingTime, hygieneRate);
	}
	public Maritime(){
		super();
	}
	
	public String getMenuName(){
		return "Maritime";
	}
}
