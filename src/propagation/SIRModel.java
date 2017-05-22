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
	public void setRecovered(double recovered) {
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
	public void update(){
		for (int i=0;i<this.getNetwork().getCells().length;i++){
			double[] u={this.getNetwork().getCells()[i].getSusceptibles(),this.getNetwork().getCells()[i].getInfectives(),this.getNetwork().getCells()[i].getRecovered()};
			double[] du=f(u);
			u[0]=u[0]+dt*du[0];
			u[1]=u[1]+dt*du[1];
			u[2]=u[2]+dt*du[2];
			try{
				this.getNetwork().getCells()[i].setSusceptibles(u[0]);
				this.getNetwork().getCells()[i].setInfectives(u[1]);
				this.getNetwork().getCells()[i].setRecovered(u[2]);
			}catch (ImpossibleValue e){
				System.out.println("Problème de propagation");
			}
			for (int j=0;j<this.getNetwork().getEdges().length;j++){
				double population = this.getNetwork().getCells()[j].getPopulation();
				double infectives = this.getNetwork().getCells()[j].getInfectives();
				double susceptibles = this.getNetwork().getCells()[j].getSusceptibles();
				double recovered = this.getNetwork().getCells()[j].getRecovered();
				for (Border b : this.getNetwork().getEdges()[i][j]){
					if (b.isOpened()){
						double number = b.getFreqRate()*dt;
						try{
							this.getNetwork().getCells()[i].setPopulation(this.getNetwork().getCells()[i].getPopulation() + number);
							this.getNetwork().getCells()[i].setSusceptibles(this.getNetwork().getCells()[i].getSusceptibles() + susceptibles/population * number + recovered/population * number);
							this.getNetwork().getCells()[i].setRecovered(this.getNetwork().getCells()[i].getRecovered() + recovered/population * number );
						}catch (ImpossibleValue e){
							System.out.println("Problème de transport entre les pays");
						}
					}
				}
			}
		}
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
