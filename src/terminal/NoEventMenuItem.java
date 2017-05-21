package terminal;

import java.util.function.Consumer;

import propagation.Event;

public class NoEventMenuItem extends MenuItem{
	public NoEventMenuItem(Consumer<String> function,String menuName){
		super(function,menuName,()->"",()->true);
	}
	
	@Override
	protected void generateEvent(Event e,String choice){}

}
