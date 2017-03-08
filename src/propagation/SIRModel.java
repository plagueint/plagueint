package propagation;

public class SIRModel extends GenericModel{
	
	public SIRModel(float beta, float gamma, Graph network, double susceptibles, double infectives, float dt, int recovered) {
		super(beta, network, susceptibles, infectives, dt);
		this.recovered=recovered;
		this.gamma = gamma;
	}

	private double recovered;
	private float gamma;

	double getRecovered() {
		return recovered;
	}
	void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	float getGamma() {
		return gamma;
	}
	void setGamma(float gamma) {
		this.gamma = gamma;
	}
}
