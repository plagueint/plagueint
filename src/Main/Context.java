package Main;
import terminal.*;
import java.util.Comparator;
import java.util.PriorityQueue;

import propagation.*;

/* La classe Main appelle les getters de terminal.Menu.
Dans la classe Main on a une boucle while[true] qui incrémente le temps de 1 à chaque boucle
Elle renvoie les résultats en sortie dans la classe output
*/

public class Context {
	
	private GenericModel model=new SIRModel();
	private String fileToWrite="out";

	
	/* Arborescence du Menu
	 * modelMenu
	 * firstSubMenu
	 * * startParameters
	 * * * country
	 * * * * countryPopulation
	 * * * * countryBorders
	 * * diseaseParameter
	 * * * modelChoice
	 * * * constantes
	 * 
	 * secondSubMenu
	 * *
	 * *
	 * 
	 * eventSubMenu
	 * * createEvent
	 * * * constantes
	 * * * graphParameters
	 * * listEvent (Lister et supprimer)
	 * * deleteEvent
	 * 
	 * exportMenu
	 * importMenu
	 * 
	 */
	
	
	private Menu constructModelMenu() {
		// Pour ajouter un menu: new SubMenu("Titre", [ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice) ] )
		// ou bien menuPrincipal.add("Titre", [ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice) ] ).
		// Pour faire une entrée menu qui exécute une action sur le sous-menu sousMenu: sousMenu.add(inconnue String x -> void, "Titre",[ ()->String qui renvoie l'état que l'on veut indiquer (Ex: modelChoice), ()->boolean pour rendre indisponible une entrée menu)]
		SubMenu modelMenu=new SubMenu("Simulation");
		SubMenu secondSubMenu=new SubMenu("Choix de la maladie de départ");
		SubMenu firstSubMenu=new SubMenu("Personnalisation de la maladie",()->"Maladie actuelle " + this.model.getName());
		SubMenu modelChoice=new SubMenu("Choix d'un modèle",()->"Current model is " + this.model.getClass().getSimpleName());
		modelChoice.add(x-> this.model=new SIRModel(), "Modèle SIR",()->this.model.getClass().getSimpleName(),()->this.model.getClass()!=SIRModel.class);
		modelChoice.add(x-> this.model=new SIRBaDModel(), "Modèle SIR with Birth and Death",()->this.model.getClass().getName());
		SubMenu diseaseParameter=new SubMenu("Paramètres de propagation",()-> "Current parameters are :\n" + this.model.getClass().getSimpleName() + "\n" + this.model.toString());
		diseaseParameter.add(modelChoice);
		SubMenu constantes=new SubMenu("Constantes",()->"Constantes actuelles :\n" + this.model.toString());
		diseaseParameter.add(constantes);
		constantes.add(x->this.model.setBeta(Double.parseDouble(x)),"Beta: coefficient de propagation");
		constantes.add(x->((SIRModel) this.model).setGamma(Double.parseDouble(x)),"Gamma: coefficient de guérison",()->this.model.getClass()==SIRModel.class || this.model.getClass()==SIRBaDModel.class);
		constantes.add(x->((SIRBaDModel) this.model).setMu(Double.parseDouble(x)),"Mu: taux de mortalité",()->this.model.getClass()==SIRBaDModel.class);
		diseaseParameter.add(x->this.model.setDt(Double.parseDouble(x)),"Echelle de temps dt");
		SubMenu startParameters=new SubMenu("Paramètres de départ",()->"Choix du pays");
		for (int i=0;i<this.model.getNetwork().getCells().length;i++){
			Country c=((Country) this.model.getNetwork().getCells()[i]);
			SubMenu country=new SubMenu(c.getName());
			startParameters.add(country);
			SubMenu countryPopulation=new SubMenu("Population du pays",()->"Population totale:" + c.getPopulation() + "\nSains:" + c.getSusceptibles() + "\nInfectés:" + c.getInfectives() + "\nGuéris:" + c.getRecovered());
			country.add(countryPopulation);
			countryPopulation.add(x->{
				double y = Double.parseDouble(x);
				try{
					c.setSusceptibles(y);
					} catch (ImpossibleValue e){
						System.out.println(e.getTitle());}
				},"Nombre de sains");
			countryPopulation.add(x->{
				double y =Double.parseDouble(x);
				try{
					c.setInfectives(y);
				} catch (ImpossibleValue e){
					System.out.println(e.getTitle());
				}
			},"Nombre d'infectés");
			countryPopulation.add(x->{
				double y=Double.parseDouble(x);
				try{
					c.setRecovered(y);
				} catch (ImpossibleValue e){
					System.out.println(e.getTitle());
				}
			},"Nombre de guéris");
			SubMenu countryBorders=new SubMenu("Etat des frontières du pays");
			country.add(countryBorders);
			for (int j=0;j<this.model.getNetwork().getCells().length;j++){
				Border[] b = this.model.getNetwork().getEdges()[i][j];
				Country l = ((Country) this.model.getNetwork().getCells()[j]);
				SubMenu border = new SubMenu("Frontière avec " + l.getName());
				countryBorders.add(border);
				for (int k=0;k<3;k++){
					Border z = b[k];
					SubMenu borderType = new SubMenu("Frontière "+ this.model.getNetwork().getEdges()[i][j][k].getClass().getSimpleName() + " avec " + l.getName(), ()->z.returnOpened() + "\nTemps de voyage: " + z.getCrossingTime() + "\nNombre de voyageurs par unité de temps: " + z.getFreqRate());
					border.add(borderType);
					borderType.add(x-> z.setOpened(true),"Ouvrir la frontière");
					borderType.add(x-> z.setOpened(false),"Fermer la frontière");
					borderType.add(x->{
						double y = Double.parseDouble(x);
						try{
							z.setCrossingTime(y);
							} catch (ImpossibleValue e){
								System.out.println(e.getTitle());
							}
						},"Temps de voyage");
					borderType.add(x->{
						double y = Double.parseDouble(x);
						try{
							z.setFreqRate(y);
						} catch (ImpossibleValue e){
							System.out.println(e.getTitle());
						}
					},"Nombre de voyageurs par unité de temps");
					}
				}
			}
		
		//on définit les subMenu de choix de Maladie (secondSubMenu)
		//Les valeurs 1 et 2 sont à changés dans les deux lignes qui suivent
		secondSubMenu.add(x->this.model=new SIRModel(1, 2, this.model.getNetwork(), this.model.getSusceptibles(), this.model.getInfectives(), this.model.getDt(),this.model.getRecovered(), "Peste"),"Peste");
		secondSubMenu.add(x->this.model=new SIRModel(1, 2, this.model.getNetwork(), this.model.getSusceptibles(), this.model.getInfectives(), this.model.getDt(),this.model.getRecovered(), "Lèpre"),"Lèpre");
		
		//On veut pouvoir créer des événements en cours de propagation pour modifier des données:
		SubMenu eventSubMenu=new SubMenu("Gérer les évenements");
		modelMenu.add(eventSubMenu);
		SubMenu createEvent=new EventCreationSubMenu("Créer un évenement");		
		SubMenu listEvent=new EventListSubMenu("Lister et supprimer l'évènement choisi");
		eventSubMenu.add(listEvent);	
		createEvent.add(constantes);
		SubMenu graphParameters=new SubMenu("Paramètres du graphe",()->"Choix du pays");
		graphParameters.setSubmenus(startParameters.getSubmenus());
		MenuItem exportMenu=new NoEventMenuItem(x->DAO.Csv.writeToFile(x),"Exporter les paramètres et évènements");
		modelMenu.add(exportMenu);
		createEvent.add(graphParameters);
		eventSubMenu.add(createEvent);
		firstSubMenu.add(diseaseParameter);
		firstSubMenu.add(startParameters);
		modelMenu.add(firstSubMenu);
		modelMenu.add(secondSubMenu);
		
		return modelMenu;
		
		
	}

	
	public static void main(String[] args) {
		Context context=new Context();
		Menu mainMenu=context.constructModelMenu();
		Event e=new Event(0);
		mainMenu.getUserChoice(e);
		PriorityQueue<Event> events=new PriorityQueue<Event>(Comparator.comparingDouble(Event::getPriority));
		events.addAll(MenuItem.events);
		System.out.println(events);
	}
}
