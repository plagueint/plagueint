package terminal;
import java.util.function.*;
import propagation.Event;


public class MenuItem implements Menu{
	
	private Consumer<String> function;
	private String text;
	
	public MenuItem(Consumer<String> function,String text){
		this.function = function;
		this.text=text;
	}

	public void apply (String value){
		this.function.accept(value);
	}
	
	public void getUserChoice(Event e){
		console.print(this.toString());
		console.print("\nChoice ?:");
		String choice = console.readLine();
		boolean ask=true;
		while(ask){
			ask=false;
			try{
				apply(choice);
			}catch (NumberFormatException error){
				console.print("You might have not provided the right type");
			}finally{
				ask=true;
			}
		}
		
		
		
	}
	
	public void getEventChoice(Event e){
		String choice = e.getNextChoice();
		this.apply(choice);
	}
	
	@Override
	public String toString(){
		return this.text;
	}
}
