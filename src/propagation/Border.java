package propagation;

public class Border {
	public Border(boolean opened, double freqRate, double crossingTime, double hygieneRate) {
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
	private double freqRate;
	private double crossingTime;
	private double hygieneRate;
	
	public boolean isOpened() {
		return opened;
	}
	public void setOpened(boolean opened) {
		this.opened = opened;
	}
	public double getFreqRate() {
		return freqRate;
	}
	public void setFreqRate(double freqRate) throws ImpossibleValue{
		if (freqRate<0){throw new ImpossibleValue("Le nombre de voyageurs doit être positif");}
		else {	this.freqRate = freqRate;}
	}
	public double getCrossingTime() {
		return crossingTime;
	}
	public void setCrossingTime(double crossingTime) throws ImpossibleValue{
		if (crossingTime<0){throw new ImpossibleValue("Le temps de voyage doit être positif");}
		else {this.crossingTime = crossingTime;}
	}
	public double getHygieneRate() {
		return hygieneRate;
	}
	public void setHygieneRate(double hygieneRate) {
		this.hygieneRate = hygieneRate;
	}
	
	public String returnOpened(){
		if (this.isOpened()){return "Frontière ouverte";}
		else {return "Frontière fermée";}
	}
}
