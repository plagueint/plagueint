package propagation;



public class SIRModel extends GenericModel{
	
	//Standard SIRModel
	public SIRModel(){
		super();
		this.recovered=0;
		this.gamma=0;
	}

	public SIRModel(double beta, double gamma, Graph network, double susceptibles, double infectives, double dt, double recovered,String name) {
		super(beta, network, susceptibles, infectives, dt,name);
		this.recovered=recovered;
		this.gamma = gamma;
	}
	
	private double recovered;
	private double gamma;

	public double getRecovered() {
		return recovered;
	}
	public void setRecovered(int recovered) {
		this.recovered = recovered;
	}
	double getGamma() {
		return gamma;
	}
	public void setGamma(double gamma) {
		this.gamma = gamma;
	}
	
	//Définit la fonction f vérifiant: du=f(u) où u=(susceptibles,infectives,recovered)
	public double[] f(double[] u , double beta , double gamma) {
		double[] du = new double[3];
		du[0] = -beta*u[0]*u[1]/(u[0]+u[1]+u[2]);
		du[1] = beta*u[0]*u[1]/(u[0]+u[1]+u[2]) - gamma*u[1];
		du[2] = gamma*u[1];
		for(int i=0;i<u.length;i++){
			u[i]=u[i]+du[i]*this.dt;
		}
		return u;
	}
	
	@Override
	public String toString (){
		String s=super.toString() ;
		return s + "gamma : " + this.gamma + "\n";
	}
}
