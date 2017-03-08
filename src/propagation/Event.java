package propagation;
import java.util.Hashtable;

public class Event {
	public Event(String name, double time, Hashtable<String, Float> parameters) {
		super();
		this.name = name;
		this.time = time;
		this.parameters = parameters;
	}
	
	private String name;
	private double time;
	private Hashtable<String , Float> parameters;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public Hashtable<String, Float> getParameters() {
		return parameters;
	}
	public void setParameters(Hashtable<String, Float> parameters) {
		this.parameters = parameters;
	}
	
}