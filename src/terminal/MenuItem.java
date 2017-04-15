package terminal;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;
import propagation.Event;


public class MenuItem implements Menu{
	
	final static public PriorityQueue<Event> events = new PriorityQueue<Event>(Comparator.comparingDouble(Event::getPriority));

	
	private Consumer<String> function;
	private String menuName;
	private Supplier<String> current;
	
	protected MenuItem(Consumer<String> function,String menuName, Supplier<String> current){
		this.function = function;
		this.menuName=menuName;
		this.current=current;
	}
	
	public String getMenuName(){
		return menuName;
	}

	protected void setName(String menuName){
		this.menuName = menuName;
	}

	protected void accept(String choice){
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
		if (this.current != null && this.current.get() != ""){
			return this.getMenuName() + "\n" + "current is : " + this.current.get();
		}else{
			return this.getMenuName();
		}
		
	}
}
