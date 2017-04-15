package terminal;
import java.util.function.Consumer;
import propagation.Event;


public class MenuItem implements Menu{
	
	private Consumer<Event> function;
	private String menuName;
	
	public MenuItem(Consumer<Event> function,String menuName){
		this.function = function;
		this.menuName=menuName;
	}
	
	public String getMenuName(){
		return menuName;
	}

	public void setName(String menuName){
		this.menuName = menuName;
	}

	public void accept(Event e){
		this.function.accept(e);;
	}
	
	public void getUserChoice(Event e){
		console.print(this.toString());
		boolean ask=true;
		while(ask){
			ask=false;
			try{
				accept(e);
			}catch (NumberFormatException error){
				console.print("You might have not provided the right type");
			}finally{
				ask=true;
			}
			
		}
	}
	
	public void getEventChoice(Event e){
		this.accept(e);
	}
	
	@Override
	public String toString(){
		return this.getMenuName();
	}
}
