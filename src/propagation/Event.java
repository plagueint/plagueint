package propagation;
import java.util.Queue;

public class Event {
	public Event(String name, double time, Queue<Float> parameters,Queue<Integer> choices) {
		super();
		this.setName(name);
		this.setTime(time);
		this.setParameters(parameters);
	}
	
	private String name;
	private double time;
	private Queue<Float> parameters;
	private Queue<Integer> choices;
	
	Queue<Integer> getChoices() {
		return choices;
	}
	void setChoices(Queue<Integer> choices) {
		this.choices = choices;
	}
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
	public Queue<Float> getParameters() {
		return parameters;
	}
	public void setParameters(Queue<Float> parameters) {
		this.parameters = parameters;
	}
	
	public float getNextEntry(){
		return parameters.remove();
	}
	
	public int getNextChoice(){
		return choices.remove();
	}
	
}