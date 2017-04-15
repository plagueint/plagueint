package service;

public class Solve {

	//SIR peuvent être des réels car on stockera les valeurs dans un fichier de toute façon.
	public double N; //population totale de la celulle
	public double S; //compartment used for susceptibles
	public double I; //compartment for infectives
	public double R; //compartment used for individuals who have been infected and then removed from the disease, either due to immunization or death.
	
	public double contaminationRate;
	public double recoveryRate;
	public double deathRate;
	public double birthRate;
	
	public double timeframe; // pas de temps de la méthode d'Euler
	
	
	//S+I+R=N
	
	//dS/dt=birthRate*N-deathRate*S-contaminationRate*S*I 
	
	//dI/dt=contaminationRate*S*I -(deathRate+recoveryRate)*I
	
	//dR/dt=recoveryRate*I-deathRate*R
	
	//Notons sir le vecteur (S,I,R) et dsir le vecteur (dS/dt,dI/dt,dR/dt)
	//double[] sir = 
	//double[] dsir = 
	
	
	//this.SIR=SIR+derSIR*timeframe
}
