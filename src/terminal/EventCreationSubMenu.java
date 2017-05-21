package terminal;

import propagation.Event;

public class EventCreationSubMenu extends SubMenu{
	public EventCreationSubMenu(String name){
		super(name);
	}
	
	private double time;
	
	public void getUserTime(){
		double value=0;
		String choice = "";
		boolean ask=true;
		while(ask){
			console.print("\nAt which time does the event trigger ? :");
			try{
				choice = console.readLine();
				value = Double.parseDouble(choice);
				if (value >= 0){
					ask=false;
				}else{
					console.print("A time must be positive");
				}
			}catch (NumberFormatException error){
				console.print("A Double is expected");
			}
		}
		this.time=value;
	}
	
	double getTime(){
		return this.time;
	}
	
	@Override
	public void getNextMenu(int value,Event e,String choice){
		Event next = new Event(getTime(),e.getMenuPath());
		submenus.get(value).getUserChoice(next);
	}
	
	@Override
	public void getUserChoice(Event e){
		getUserTime();
		super.getUserChoice(e);
	}
}
