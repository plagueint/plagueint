package terminal;

import java.io.Console;

import service.Solve;
import utils.Euler;

public class Menu {
		
	final private static Console console=System.console();
	
	float getFloat(){
		String s="";
		float number=0;
		boolean ask=true;
		while (ask){
			try{
				s=console.readLine();
				number=Float.parseFloat(s);
				ask=false;
			} catch (NumberFormatException e){
				System.out.println(s + "is not a float");
				ask=true;
			}
		}
		return number;
	}
	
	String getString(){
		String s="";
		boolean ask=true;
		while (ask){
			try{
				s=console.readLine();
				ask=false;
			} catch (Exception e){
				System.out.println(s + "is not correct");
				ask=true;
			}
		}
		return "";
	}
	
	double getDouble(){
		String s="";
		boolean ask=true;
		double number=0;
		while(ask){
			try{
				s=console.readLine();
				ask=false;
				number = Double.parseDouble(s);
			} catch (NumberFormatException e){
				System.out.println(s + "is not a double");
				ask=true;
			}
		}
		return number;
	}
	
	public static void main(String[] args){
	// C'est cette méthode main qui gère tous les appels
		
		while (true)
		{
			// Gestion des Event
			EulerSolve(dt,u,du);//Appel à la méthode d'Euler
			//Écriture dans le .csv
			t=t+1 // On incrémente le temps de 1
		}
	}
}
