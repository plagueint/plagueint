package terminal;

//import java.io.Console;
import java.util.function.Supplier;

import propagation.*;
import terminal.Console;
/**
 * @author varens
 *
 */

public class Menu {
	
	
    

	final private static Console console=new Console();
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
			System.out.println("---Simulation---\n"
							+  "1) Choisir une maladie prédéfinie\n"
							+  "2) Créer une maladie personnalisée\n"
							+  "3) Quitter\n");
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
			switch(Util.verifyMenuChoice(3,() -> Integer.parseInt(e.getNextChoice()))){
				case 1:
					chooseDisease(() -> Integer.parseInt(e.getNextChoice()));
					break;
				case 2:
					createDisease(() -> Integer.parseInt(e.getNextChoice()));
					break;
				case 3:
					stay=false;
					break;
			}
		}
	}
	
	
	/*
	 * Menus génériques qui peuvent gérer des évènements ou bien l'entrée utilisateur grâce aux suppliers
	 */
	
	static void chooseDisease(Supplier<Integer> choice){
		System.out.println("---Choix d'un modèle---\n"
						 + "1) Modèle SIR\n"
						 + "2) Précédent\n");
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
			System.out.println("---Création d'une maladie---\n"
							 + "1) Paramètres de la maladie\n"
							 + "2) Paramètres des cellules\n");
			switch (Util.verifyMenuChoice(2,choice)){
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
//		while (true)
//		{
//			
//		}
	}

}
