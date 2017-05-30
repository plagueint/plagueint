package propagation;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Event {
	
	public Event(double time, ConcurrentLinkedQueue<String> menuPath) {
		super();
		this.setTime(time);
		this.setMenuPath(menuPath);
	}

	
	public Event(double time){
		super();
		this.setTime(time);
		this.setMenuPath(new ConcurrentLinkedQueue<String> ());
	}
	
	private double time;
	private ConcurrentLinkedQueue<String> menuPath;
	
	public ConcurrentLinkedQueue<String> getMenuPath() {
		return menuPath;
	}
	void setMenuPath(ConcurrentLinkedQueue<String> menuPath) {
		this.menuPath = menuPath;
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
		ConcurrentLinkedQueue<String> newMenuPath= new ConcurrentLinkedQueue<String>(this.menuPath);
		Event next=new Event(this.time,newMenuPath);
		next.menuPath.add(s);
		return next;
	}
	
	public static double getPriority(Event e){
		return e.getTime();
	}
	
	public String toString(){
		String s=String.valueOf(time);
		for (String i : menuPath){
			s += ";" + i ; 
		}
		return s;
	}
	
	public String toCSV(){
		String s=String.valueOf(time);
		for (String i : menuPath){
			s += ";" + i ;
		}
		return s;
	}
	
}
