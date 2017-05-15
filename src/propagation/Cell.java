package propagation;

public class Cell {
	public Cell(int id, double susceptibles, double infectives, double recovered, double population, float hygieneRate) {
		this.id = id;
		this.susceptibles = susceptibles;
		this.infectives = infectives;
		this.recovered = recovered;
		this.population = population;
		this.hygieneRate = hygieneRate;
	}
	
	private int id;
	private double susceptibles;
	private double infectives;
	private double recovered;
	private double population;
	private float hygieneRate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getSusceptibles() {
		return susceptibles;
	}
	public void setSusceptibles(double susceptibles) {
		this.susceptibles = susceptibles;
	}
	public double getInfectives() {
		return infectives;
	}
	public void setInfectives(double infectives) {
		this.infectives = infectives;
	}
	public double getRecovered() {
		return recovered;
	}
	public void setRecovered(double recovered) {
		this.recovered = recovered;
	}
	public double getPopulation() {
		return population;
	}
	public void setPopulation(double population) {
		this.population = population;
	}
	public float getHygieneRate() {
		return hygieneRate;
	}
	public void setHygieneRate(float hygieneRate) {
		this.hygieneRate = hygieneRate;
	}
}