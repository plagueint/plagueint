package terminal;
import java.util.Comparator;
import propagation.ImpossibleValue;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.BooleanSupplier;
import propagation.Event;


public class MenuItem implements Menu{
	
	final static public PriorityQueue<Event> events = new PriorityQueue<Event>(Comparator.comparingDouble(Event::getPriority));

	
	private Consumer<String> function;
	private String menuName;
	private Supplier<String> current;
	private BooleanSupplier available;
	
	protected MenuItem(Consumer<String> function,String menuName, Supplier<String> current,BooleanSupplier available){
		this.function = function;
		this.menuName=menuName;
		this.current=current;
		this.available=available;
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
	
	public Boolean isAvailable(){
		return this.available.getAsBoolean();
	}
	
	public String getCurrentState(){
		return this.current.get();
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
				console.print("You might have not provided the right type\n");
			}
		}
		events.add(e.addChoice(choice));
	}
	
	public void getEventChoice(Event e){
		this.accept(e.getNextChoice());
	}
	
	@Override
	public String toString(){
		if (this.current != null && this.getCurrentState() != ""){
			return this.getMenuName() + "\n" + "current is : " + this.getCurrentState();
		}else{
			return this.getMenuName();
		}
		
	}
}