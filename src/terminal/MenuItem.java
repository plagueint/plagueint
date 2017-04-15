package terminal;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import propagation.Event;


public class MenuItem implements Menu{
	
	final static public PriorityQueue<Event> events = new PriorityQueue<Event>(Comparator.comparingDouble(Event::getPriority));

	
	private Consumer<String> function;
	private String menuName;
	
	public MenuItem(Consumer<String> function,String menuName){
		this.function = function;
		this.menuName=menuName;
	}
	
	public String getMenuName(){
		return menuName;
	}

	public void setName(String menuName){
		this.menuName = menuName;
	}

	public void accept(String choice){
		this.function.accept(choice);;
	}
	
	public void getUserChoice(Event e){
		console.print(this.toString());
		String choice="";
		boolean ask=true;
		while(ask){
			try{
				choice=console.readLine();
				accept(choice);
				ask=false;
			}catch (NumberFormatException error){
				console.print("You might have not provided the right type");
			}
		}
		events.add(e.addChoice(choice));
	}
	
	public void getEventChoice(Event e){
		this.accept(e.getNextChoice());
	}
	
	@Override
	public String toString(){
		return this.getMenuName();
	}
}
