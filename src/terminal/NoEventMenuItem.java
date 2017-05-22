package terminal;

import java.util.function.Consumer;
import java.util.function.Supplier;

import propagation.Event;

public class NoEventMenuItem extends MenuItem{
	public NoEventMenuItem(Consumer<String> function,String menuName){
		super(function,menuName,()->"",()->true);
	}
	public NoEventMenuItem(Consumer<String> function, String menuName, Supplier<String> current){
		super(function,menuName,current,()->true);
	}
	
	@Override
	protected void generateEvent(Event e,String choice){}
	
	@Override
	public String toString(){
		if (this.current != null && this.getCurrentState() != ""){
			return this.getMenuName() + "\n" + this.getCurrentState();
		}else{
			return this.getMenuName();
		}
		
	}

}
