package Main;
import terminal.*;
import propagation.*;

/* La classe Main appelle les getters de terminal.Menu.
Dans la classe Main on a une boucle while[true] qui incrémente le temps de 1 à chaque boucle
Elle renvoie les résultats en sortie dans la classe output
*/

public class Context {
	
	private GenericModel model=new SIRModel();
	
	
	private Menu constructModelMenu(){
		// Pour ajouter un menu: new SubMenu("Titre", [ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice) ] )
		// ou bien menuPrincipal.add("Titre", [ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice) ] ).
		// Pour faire une entrée menu qui exécute une action sur le sous-menu sousMenu: sousMenu.add(inconnue String x -> void, "Titre",[ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice), ()->boolean pour rendre indisponible une entrée menu)]
		SubMenu modelMenu=new SubMenu("Simulation");
		SubMenu firstSubMenu=new SubMenu("Choisir une maladie personnalisée");
		SubMenu secondSubMenu=new SubMenu("Créer une maladie personnalisée");
		SubMenu modelChoice=new SubMenu("Choix d'un modèle",()->"Current model is " + this.model.getClass().getSimpleName());
		modelChoice.add(x-> this.model=new SIRModel(), "Modèle SIR",()->this.model.getClass().getSimpleName(),()->this.model.getClass()!=SIRModel.class);
		modelChoice.add(x-> this.model=new SIRBaDModel(), "Modèle SIR with Birth and Death",()->this.model.getClass().getName());
		secondSubMenu.add(modelChoice);
		SubMenu diseaseParameter=new SubMenu("Paramètres de la maladie",()-> "Current parameters are :\n" + this.model.toString());
		diseaseParameter.add(x->this.model.setDt(Double.parseDouble(x)),"Dt: unité de temps élémentaire");
		diseaseParameter.add(x->this.model.setBeta(Double.parseDouble(x)),"Beta: coefficient de propagation");
		diseaseParameter.add(x->((SIRModel) this.model).setGamma(Double.parseDouble(x)),"Gamma: coefficient de guérison",()->this.model.getClass()==SIRModel.class || this.model.getClass()==SIRBaDModel.class);
		diseaseParameter.add(x->((SIRBaDModel) this.model).setMu(Double.parseDouble(x)),"Mu: taux de mortalité",()->this.model.getClass()==SIRBaDModel.class);
		SubMenu startParameters=new SubMenu("Conditions de départ");
		startParameters.add("Choisir le pays");
		for (int i=0;i<this.model.getNetwork().getCells().length;i++){
			Country c=((Country) this.model.getNetwork().getCells()[i]);
			SubMenu country=new SubMenu(c.getName());
			country.add(x->c.setInfectives(Double.parseDouble(x)),"Nombre d'infectés");
		}
		secondSubMenu.add(diseaseParameter);
		modelMenu.add(firstSubMenu);
		modelMenu.add(secondSubMenu);
		return modelMenu;
	}

	
	public static void main(String[] args){
		Context context=new Context();
		Menu mainMenu=context.constructModelMenu();
		Event e=new Event("test",0);
		mainMenu.getUserChoice(e);
		System.out.println(MenuItem.events);
	}
}
