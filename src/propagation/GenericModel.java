package propagation;

public abstract class GenericModel {
	
	//Standard GenericModel
	public GenericModel(){
		this.beta=0.00218;
		this.susceptibles=1;
		this.infectives=0;
		this.network=new Graph();
		this.dt=1;
		
	}
	
	public GenericModel(double beta, Graph network, double susceptibles, double infectives, double dt) {
		this.beta = beta;
		this.network = network;
		this.susceptibles = susceptibles;
		this.infectives = infectives;
		this.dt = dt;
	}
		
	private double beta;
	private Graph network;
	private double susceptibles;
	private double infectives;
	private double dt;
	
	
	double getBeta() {
		return beta;
	}
	void setBeta(double beta) {
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
	double getDt() {
		return dt;
	}
	void setDt(double dt) {
		this.dt = dt;
	}
	
	
	
}
