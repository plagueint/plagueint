package Main;
import terminal.*;
import propagation.*;

/* La classe Main appelle les getters de terminal.Menu.
Dans la classe Main on a une boucle while[true] qui incrémente le temps de 1 à chaque boucle
Elle renvoie les résultats en sortie dans la classe output
*/

public class Context {
	
	private GenericModel model=new SIRModel();
	
	
	private Menu constructMainMenu(){
		SubMenu modelMenu=new SubMenu("Simulation");
		SubMenu firstSubMenu=new SubMenu("Choisir une maladie personnalisée");
		SubMenu secondSubMenu=new SubMenu("Créer une maladie personnalisée");
		SubMenu modelChoice=new SubMenu("Choix d'un modèle");
		modelChoice.add(new MenuItem(x-> this.model=new SIRModel(), "Modèle SIR"));
		modelChoice.add(new MenuItem(x-> this.model=new SIRBaDModel(), "Modèle SIR with Birth and Death"));
		secondSubMenu.add(modelChoice);
		modelMenu.add(firstSubMenu);
		modelMenu.add(secondSubMenu);
		return modelMenu;
	}
	
	public static void main(String[] args){
		Context context=new Context();
		Menu mainMenu=context.constructMainMenu();
		Event e=new Event("test",0);
		mainMenu.getUserChoice(e);
		MenuItem test=new MenuItem(x-> System.out.println("creating fake item"),"test");
		System.out.println(test.events);
	}
}
