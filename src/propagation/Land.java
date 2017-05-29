package propagation;

public class Land extends Border{

	public Land(boolean opened, float freqRate, float crossingTime, float hygieneRate) {
		super(opened, freqRate, crossingTime, hygieneRate);
	}
	
	public Land(){
		super();
	}
	
	@Override
	public String getMenuName(){
		return "terrestre";
	}
}
