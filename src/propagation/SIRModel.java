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
	public double[] f(double[] u) {
		double[] du = new double[3];
		du[0] = -getBeta()*u[0]*u[1]/(u[0]+u[1]+u[2]);
		du[1] = getBeta()*u[0]*u[1]/(u[0]+u[1]+u[2]) - gamma*u[1];
		du[2] = gamma*u[1];
		return du;
	}
	public double[][] update(double[][] u){
		double [][] du = new double[this.getNetwork().getCells().length][3];
		for (int i=0;i<this.getNetwork().getCells().length;i++){
			du[i]=f(u[i]);
		}
		return du;
	}
	@Override
	public String toString (){
		String s=super.toString() ;
		return s + "gamma : " + this.gamma + "\n";
	}
	
	public void clear(){
		super.clear();
		this.recovered=0;
		this.gamma=0;
	}
}
