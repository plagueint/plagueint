package propagation;

public class SIRModel extends GenericModel{
	
	public SIRModel(float beta, float gamma, Graph network, double susceptibles, double infectives, float dt, int recovered) {
		super(beta, gamma, network, susceptibles, infectives, dt);
		this.recovered=recovered;
	}

	private double recovered;

	double getRecovered() {
		return recovered;
	}
	void setRecovered(int recovered) {
		this.recovered = recovered;
	}
}
