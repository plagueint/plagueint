package propagation;
import java.util.Queue;

public class Event {
	public Event(String name, double time, Queue<String> menuPath) {
		super();
		this.setName(name);
		this.setTime(time);
		this.setMenuPath(menuPath);
	}
	
	private String name;
	private double time;
	private Queue<String> menuPath;
	

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
	
	
	Queue<String> getMenuPath() {
		return menuPath;
	}
	void setMenuPath(Queue<String> menuPath) {
		this.menuPath = menuPath;
	}
	public String getNextEntry(){
		return menuPath.remove();
	}
	
	public String getNextChoice(){
		return menuPath.remove();
	}
	
}