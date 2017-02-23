package propagation;

public class SIRBaDModel extends SIRModel {
	
	
	public SIRBaDModel(float beta, float gamma, Graph network, double susceptibles, double infectives, float dt, int recovered) {
		super(beta, gamma, network, susceptibles, infectives, dt, recovered);
		this.mu=mu;
	}
	
	private float mu;
	
	double getMu() {
		return mu;
	}
	void setMu(int mu) {
		this.mu = mu;
	}
}
