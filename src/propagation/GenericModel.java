package propagation;

public abstract class GenericModel {
	
	//Standard GenericModel
	public GenericModel(){
		this.beta=0.00218;
		this.susceptibles=1;
		this.infectives=0;
		this.network=new Graph();
		this.dt=1;
		this.name="maladie par défaut";
		
	}
	
	public GenericModel(double beta, Graph network, double susceptibles, double infectives, double dt,String name) {
		this.beta = beta;
		this.network = network;
		this.susceptibles = susceptibles;
		this.infectives = infectives;
		this.dt = dt;
		this.name=name;
	}
		
	
	private double beta;
	private Graph network;
	private double susceptibles;
	private double infectives;
	private double dt;
	private String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	double getBeta() {
		return beta;
	}
	public void setBeta(double beta) {
		this.beta = beta;
	}
	
	public Graph getNetwork() {
		return network;
	}
	public void setNetwork(Graph network) {
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
	public void setDt(double dt) {
		this.dt = dt;
	}
	
	public String toString(){
		return "Dt : " + this.dt + " | beta : " + this.beta +"\n";
	}
	

}
