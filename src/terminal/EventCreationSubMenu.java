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
			console.print("\nA quel instant l'évènement doit-il être déclenché ?");
			try{
				choice = console.readLine();
				value = Double.parseDouble(choice);
				if (value >= 0){
					ask=false;
				}else{
					console.print("Le temps doit être positif");
				}
			}catch (NumberFormatException error){
				console.print("Un double est attendu");
			}
		}
		this.time=value;
	}
	
	double getTime(){
		return this.time;
	}
	
	@Override
	public void getNextMenu(int value,Event e,String choice){
		Event next = e.addChoice(choice);
		next.setTime(getTime());
		submenus.get(value).getUserChoice(next);
		
	}
	
	@Override
	public void getUserChoice(Event e){
		getUserTime();
		super.getUserChoice(e);
	}
}
