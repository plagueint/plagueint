package terminal;

import java.io.Console;
import java.util.function.Supplier;

import propagation.Cell;
/**
 * @author varens
 *
 */
public class Menu {
	
	final private static Console console=System.console();
	public Menu() {
		
	}
	
	/*
	 * Pour créer un menu :
	 * Créer une boucle qui utilise un booléen
	 * qui est mis à jour si l'utilisateur choisis le choix de retour en
	 * arrière dans les menus
	 */
	
	
	static void menu(){
		boolean stay=true;
		while (stay){
			System.out.println("---Simulation---"
							+  "1) Choisir une maladie prédéfinie"
							+  "2) Créer une maladie personnalisée"
							+  "3) Quitter");
			switch(Util.getUserMenuChoice(3,console)){
				case 1:
					chooseDisease();
					break;
				case 2:
					//createDisease();
					break;
				case 3:
					stay=false;
					break;
			}
		}
	}
	
	static void chooseDisease(){
		boolean stay=true;
		System.out.println("---Choix d'un modèle---"
						 + "1) Modèle SIR"
						 + "2) Précédent");
		switch(Util.getUserMenuChoice(2,console)){
			case 1:
				break;
			case 2:
				stay=false;
				break;
		}
		if (stay){
			
		}
	}
		
	static void createDisease (){
		boolean stay=true;
		while (stay){
			System.out.println("---Création d'une maladie---"
							 + "1) ");
		}
	}
	
	/*
	 * Menu paramètres initiaux : Pays + nbre infectés
	 */
	static void cellParamMenu (Supplier<Integer> choice, Supplier<Double> input, Cell cell){
		boolean stay=true;
		while (stay){
			System.out.println("");
			switch (Util.getUserMenuChoice(4, console)){
				case 1:
					//number of susceptibles
					Util.applyDouble(x -> cell.setSusceptibles(x),input);
					break;
				case 2:
					//number of infectives
					Util.applyDouble(x -> cell.setInfectives(x),input);
					break;
				case 3:
					//number recovered
					Util.applyDouble(x -> cell.setRecovered(x),input);
					break;
				case 4:
					stay=false;
					break;
			}
		}
	}
	
	public static void main(String[] args){
		// C'est cette méthode main qui gère tous les appels
		menu();
		while (true)
		{
			
		}
		}

}
