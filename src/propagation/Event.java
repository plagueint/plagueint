package propagation;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Event {
	public Event(String name, double time, ConcurrentLinkedQueue<String> menuPath) {
		super();
		this.setName(name);
		this.setTime(time);
		this.setMenuPath(menuPath);
	}
	
	public Event(String name,double time){
		super();
		this.setName(name);
		this.setTime(time);
		this.setMenuPath(new ConcurrentLinkedQueue<String> ());
	}
	
	private String name;
	private double time;
	private ConcurrentLinkedQueue<String> menuPath;
	
	public ConcurrentLinkedQueue<String> getMenuPath() {
		return menuPath;
	}
	void setMenuPath(ConcurrentLinkedQueue<String> menuPath) {
		this.menuPath = menuPath;
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
	
	public String getNextChoice(){
		return menuPath.remove();
	}
	public Event addChoice(String s){
		Event next=new Event(this.name,this.time,this.menuPath);
		next.menuPath.add(s);
		return next;
	}
	
	public static double getPriority(Event e){
		return e.getTime();
	}
	
	public String toString(){
		String s=name + ":";
		for (String i : menuPath){
			s += i; 
		}
		return s;
	}
	
}