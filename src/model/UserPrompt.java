package model;
public class UserPrompt {
	public String country; //Demande la celulle où débute l'épidémie
	public double numberOfInfected; //Demande le nombre d'infectés de départ
	public String illness; //demande la maladie
	public double timeModelisation; //temps de la simulation
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country; //this.variable --> variable résultat de la fonction
	}
	
	public double getNumberOfInfected() {
		return numberOfInfected;
	}
	public void setNumberOfInfected(double numberOfInfected) {
		this.numberOfInfected = numberOfInfected;
	}
	
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
}
