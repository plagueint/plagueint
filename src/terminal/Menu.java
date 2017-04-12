package terminal;

import java.io.Console;
import java.util.function.Supplier;

import propagation.*;
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
	
	
	static void userMenu(){
		boolean stay=true;
		while (stay){
			System.out.println("---Simulation---"
							+  "1) Choisir une maladie prédéfinie"
							+  "2) Créer une maladie personnalisée"
							+  "3) Quitter");
			switch(Util.getInteger(console)){
				case 1:
					chooseDisease(() -> Util.getInteger(console));
					break;
				case 2:
					createDisease(() -> Util.getInteger(console));
					break;
				case 3:
					stay=false;
					break;
			}
		}
	}
	
	static void eventMenu(Event e){
		boolean stay=true;
		while (stay){
			switch(Util.verifyMenuChoice(3,() -> e.getNextChoice())){
				case 1:
					chooseDisease(() -> e.getNextChoice());
					break;
				case 2:
					createDisease(() -> e.getNextChoice());
					break;
				case 3:
					stay=false;
					break;
			}
		}
	}
	
	static void chooseDisease(Supplier<Integer> choice){
		System.out.println("---Choix d'un modèle---"
						 + "1) Modèle SIR"
						 + "2) Précédent");
		switch(Util.verifyMenuChoice(2, choice)){
			case 1:
				break;
			case 2:
				break;
		}
	}
		
	static void createDisease(Supplier<Integer> choice){
		boolean stay=true;
		while (stay){
			System.out.println("---Création d'une maladie---"
							 + "1) Paramètres de la maladie"
							 + "2) Paramètres des cellules");
			switch (Util.verifyMenuChoice(1,choice)){
				case 1:
					
					break;
			}
		}
	}
	
	/*
	 * Menu paramètres initiaux : Pays + nbre infectés
	 */
	static void cellParamMenu (Supplier<Integer> choice, Supplier<Double> input, Cell cell){
		boolean stay=true;
		while (stay){
			System.out.println("");
			switch (Util.verifyMenuChoice(4,choice)){
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
		userMenu();
		while (true)
		{
			
		}
		}

}
