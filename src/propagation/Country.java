package propagation;

public class Country extends Cell{
	public Country(int id, double susceptibles, double infectives, double recovered, double population, float hygieneRate, String name) {
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
}
