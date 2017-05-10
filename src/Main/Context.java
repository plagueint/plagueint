package Main;
import terminal.*;
import propagation.*;

/* La classe Main appelle les getters de terminal.Menu.
Dans la classe Main on a une boucle while[true] qui incrémente le temps de 1 à chaque boucle
Elle renvoie les résultats en sortie dans la classe output
*/

public class Context {
	
	private GenericModel model=new SIRModel();
	
	
	private Menu constructModelMenu() {
		// Pour ajouter un menu: new SubMenu("Titre", [ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice) ] )
		// ou bien menuPrincipal.add("Titre", [ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice) ] ).
		// Pour faire une entrée menu qui exécute une action sur le sous-menu sousMenu: sousMenu.add(inconnue String x -> void, "Titre",[ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice), ()->boolean pour rendre indisponible une entrée menu)]
		SubMenu modelMenu=new SubMenu("Simulation");
		SubMenu firstSubMenu=new SubMenu("Maladie personnalisé",()->"Maladie actuelle " + this.model.getName());
		SubMenu secondSubMenu=new SubMenu("Autre maladie");
		SubMenu modelChoice=new SubMenu("Choix d'un modèle",()->"Current model is " + this.model.getClass().getSimpleName());
		modelChoice.add(x-> this.model=new SIRModel(), "Modèle SIR",()->this.model.getClass().getSimpleName(),()->this.model.getClass()!=SIRModel.class);
		modelChoice.add(x-> this.model=new SIRBaDModel(), "Modèle SIR with Birth and Death",()->this.model.getClass().getName());
		SubMenu diseaseParameter=new SubMenu("Paramètres de propagation",()-> "Current parameters are :\n" + this.model.getClass().getSimpleName() + "\n" + this.model.toString());
		diseaseParameter.add(modelChoice);
		SubMenu constantes=new SubMenu("Constantes");
		diseaseParameter.add(constantes);
		constantes.add(x->this.model.setBeta(Double.parseDouble(x)),"Beta: coefficient de propagation");
		constantes.add(x->((SIRModel) this.model).setGamma(Double.parseDouble(x)),"Gamma: coefficient de guérison",()->this.model.getClass()==SIRModel.class || this.model.getClass()==SIRBaDModel.class);
		constantes.add(x->((SIRBaDModel) this.model).setMu(Double.parseDouble(x)),"Mu: taux de mortalité",()->this.model.getClass()==SIRBaDModel.class);
		diseaseParameter.add(x->this.model.setDt(Double.parseDouble(x)),"Echelle de temps dt");
		SubMenu startParameters=new SubMenu("Conditions de départ");
		SubMenu countryChoice=new SubMenu("Choisir un pays");
		startParameters.add(countryChoice);
		for (int i=0;i<this.model.getNetwork().getCells().length;i++){
			Country c=((Country) this.model.getNetwork().getCells()[i]);
			SubMenu country=new SubMenu(c.getName(),()->"Current population state:\nTotal population:" + c.getPopulation() + "\nSusceptibles:" + c.getSusceptibles() + "\nInfectives:" + c.getInfectives() + "\nRecovered:" + c.getRecovered());
			country.add(x->c.setSusceptibles(Double.parseDouble(x)),"Nombre de sains");
			country.add(x->{
				double y =Double.parseDouble(x);
				try{
					c.setInfectives(y);
				} catch (ImpossibleValue e){
					System.out.println(e.getTitle());
				}
			},"Nombre d'infectés");
			country.add(x->{
				double y=Double.parseDouble(x);
				try{
					c.setRecovered(y);
				} catch (ImpossibleValue e){
					System.out.println(e.getTitle());
				}
			},"Nombre de guéris");
			countryChoice.add(country);
		}
		
		SubMenu eventParameters=new SubMenu("Evènements");
		
		
		
		firstSubMenu.add(diseaseParameter);
		firstSubMenu.add(startParameters);
		firstSubMenu.add(eventParameters);
		modelMenu.add(firstSubMenu);
		modelMenu.add(secondSubMenu);
		return modelMenu;
	}

	
	public static void main(String[] args) {
		Context context=new Context();
		Menu mainMenu=context.constructModelMenu();
		Event e=new Event("test",0);
		mainMenu.getUserChoice(e);
		System.out.println(MenuItem.events);
	}
}
