package terminal;

import propagation.Event;

public class EventListSubMenu extends SubMenu {
	public EventListSubMenu(String name){
		super(name);
	}
	
	@Override
	public void getNextMenu(int value,Event e,String choice){
		MenuItem.events.remove(value);
	}
	
	@Override
	public String toString(){
		String menuText = "---" + this.getMenuName() + "---" + "\n";
		if (this.current != null && this.getCurrentState() != ""){
			menuText+=this.getCurrentState() + "\n";
		}
		int i;
		menuText += 0 + ") Menu précédent\n";
		for (i=0;i<MenuItem.events.size();i++){
			menuText += (i+1) + ") " + MenuItem.events.get(i) +"\n";
		}
		return menuText;
	}
	
	
	@Override
	public void getUserChoice(Event e){
		int value=0;
		String choice = "";
		boolean ask=true;
		while(ask){
			console.print(this.toString());
			console.print("\nChoice ?:");
			try{
				choice = console.readLine();
				value = Integer.parseInt(choice)-1;
				if (value == -1){
					ask=false;
				}else if (value < MenuItem.events.size() && value >= 0){
					getNextMenu(value,e,choice);
				}else{
					throw new NotAvailableChoice();
				}
			}catch (NumberFormatException error){
				console.print("An Integer is expected\n");
			}catch (IndexOutOfBoundsException error){
				console.print((value+1) + " is not between 0 and " + this.submenus.size() +"\n");
			}catch (NotAvailableChoice error){
				console.print("choice " + (value+1) + " is not available\n");
			}
		}
	}
}
