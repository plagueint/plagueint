package propagation;

public abstract class GenericModel {
	
	public GenericModel(float beta, Graph network, double susceptibles, double infectives, float dt) {
		this.beta = beta;
		
		this.network = network;
		this.susceptibles = susceptibles;
		this.infectives = infectives;
		this.dt = dt;
	}
	private float beta;
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
