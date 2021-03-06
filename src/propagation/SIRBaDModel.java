package propagation;

public class SIRBaDModel extends SIRModel {
	
	
	public SIRBaDModel(double beta, double gamma, Graph network, double susceptibles, double infectives, double dt, double recovered,double mu,String name) {
		super(beta, gamma, network, susceptibles, infectives, dt, recovered,name);
		this.mu=mu;
	}
	
	public SIRBaDModel(){
		super();
		this.mu=0;
	}
	
	private double mu;
	
	double getMu() {
		return mu;
	}
	public void setMu(double mu) {
		this.mu = mu;
	}
	
	public String toString (){
		String s= super.toString();
		return s + "mu : " + this.mu + "\n";
	}
	public void clear(){
		super.clear();
		this.mu=0;
	}
}
