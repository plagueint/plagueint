package propagation;

public abstract class GenericModel {
	
	private float beta;
	private float gamma;
	private Graph network;
	private double susceptibles;
	private double infectives;
	private float dt;
	
	
	float getBeta() {
		return beta;
	}
	void setBeta(float beta) {
		this.beta = beta;
	}
	float getGamma() {
		return gamma;
	}
	void setGamma(float gamma) {
		this.gamma = gamma;
	}
	Graph getNetwork() {
		return network;
	}
	void setNetwork(Graph network) {
		this.network = network;
	}
	double getSusceptibles() {
		return susceptibles;
	}
	void setSusceptibles(int susceptibles) {
		this.susceptibles = susceptibles;
	}
	double getInfectives() {
		return infectives;
	}
	void setInfectives(int infectives) {
		this.infectives = infectives;
	}
	float getDt() {
		return dt;
	}
	void setDt(float dt) {
		this.dt = dt;
	}
	
	
}
