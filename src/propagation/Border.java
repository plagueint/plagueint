package propagation;

public class Border {
	public Border(boolean opened, float freqRate, float crossingTime, float hygieneRate) {
		this.opened = opened;
		this.freqRate = freqRate;
		this.crossingTime = crossingTime;
		this.hygieneRate = hygieneRate;
	}
	public Border(){
		this.opened=false;
		this.freqRate=0;
		this.crossingTime=0;
		this.hygieneRate=0;
	}
	
	private boolean opened;
	private float freqRate;
	private float crossingTime;
	private float hygieneRate;
	
	public boolean isOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	public float getFreqRate() {
		return freqRate;
	}
	public void setFreqRate(float freqRate) {
		this.freqRate = freqRate;
	}
	public float getCrossingTime() {
		return crossingTime;
	}
	public void setCrossingTime(float crossingTime) {
		this.crossingTime = crossingTime;
	}
	public float getHygieneRate() {
		return hygieneRate;
	}
	public void setHygieneRate(float hygieneRate) {
		this.hygieneRate = hygieneRate;
	}
}
