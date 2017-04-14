package terminal;
import java.util.function.BiConsumer;
import Main.Context;
import propagation.Event;


public class MenuItem implements Menu{
	
	private BiConsumer<Context,Event> function;
	private String name;
	
	public MenuItem(BiConsumer<Context,Event> function,String name){
		this.function = function;
		this.name=name;
	}
	
	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public void accept(Context context,Event e){
		this.function.accept(context,e);;
	}
	
	public void getUserChoice(Context context, Event e){
		console.print(this.toString());
		boolean ask=true;
		while(ask){
			ask=false;
			try{
				accept(context,e);
			}catch (NumberFormatException error){
				console.print("You might have not provided the right type");
			}finally{
				ask=true;
			}
			
		}
	}
	
	public void getEventChoice(Context context, Event e){
		this.accept(context,e);
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}
