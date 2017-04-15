package propagation;

public class SIRModel extends GenericModel{
	
	public SIRModel(float beta, float gamma, Graph network, double susceptibles, double infectives, float dt, double recovered) {
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
	
	//Définit la fonction f vérifiant: du=f(u) où u=(susceptibles,infectives,recovered)
	public double[] f(double[] u , double beta , double gamma) {
		double[] du = new double[3];
		du[0] = -beta*u[0]*u[1]/(u[0]+u[1]+u[2]);
		du[1] = beta*u[0]*u[1]/(u[0]+u[1]+u[2]) - gamma*u[1];
		du[2] = gamma*u[1];
		return du;
	}
		
}
