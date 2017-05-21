package propagation;

public class Country extends Cell{
	public Country(double id, double susceptibles, double infectives, double recovered, double population, double hygieneRate, String name) {
		super(id, susceptibles, infectives, recovered, population, hygieneRate);
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Country(){
		super();
		this.name="Défaut";		
	}
}
