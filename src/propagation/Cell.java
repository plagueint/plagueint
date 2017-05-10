package propagation;

public class Cell {
	public Cell(double id, double susceptibles, double infectives, double recovered, double population, double hygieneRate) {
		this.id = id;
		this.susceptibles = susceptibles;
		this.infectives = infectives;
		this.recovered = recovered;
		this.population = population;
		this.hygieneRate = hygieneRate;
	}
	public Cell(){
		this.id = 1;
		this.susceptibles = 0;
		this.infectives = 0;
		this.recovered = 0;
		this.population = 0;
		this.hygieneRate = 0;
	}
	
	private double id;
	private double susceptibles;
	private double infectives;
	private double recovered;
	private double population;
	private double hygieneRate;
	
	public double getId() {
		return id;
	}
	public void setId(double id) {
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
	public void setInfectives(double infectives)  throws ImpossibleValue{
		if (this.susceptibles<(infectives-this.infectives)){
			this.susceptibles=this.susceptibles-(infectives-this.infectives);
		}
		else{
			throw new ImpossibleValue("Impossible d'ajouter plus d'infectés qu'il n'y a de sains.");
		}
				
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
	public double getHygieneRate() {
		return hygieneRate;
	}
	public void setHygieneRate(float hygieneRate) {
		this.hygieneRate = hygieneRate;
	}
}