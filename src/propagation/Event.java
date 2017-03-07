package propagation;

public abstract class Event {
	// La classe event contient le nom d'un évenement, le temps
	private String name;
	private double time;
	private Map<String, float> M= new HashMap<String, float>();
}
