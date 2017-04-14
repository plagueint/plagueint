package terminal;
import java.util.List;
import java.util.ArrayList;
import propagation.Event;


public class SubMenu implements Menu{
	
	
	private List<Menu> submenus = new ArrayList<Menu>();
	private String text;
	
	public SubMenu (String text){
		console.readLine();
		this.text=text;
	}
	
	public void add(Menu menu){
		this.submenus.add(menu);
	}
	
	public void remove(int i){
		this.submenus.remove(i);
	}
	
	public void remove(Menu menu){
		this.submenus.remove(menu);
	}
	
	
	public void getUserChoice(Event e){
		console.print(this.toString());
		console.print("\nChoice ?:");
		int value=0;
		String choice = "";
		boolean ask=true;
		while(ask){
			ask=false;
			try{
				choice = console.readLine();
				value = Integer.parseInt(choice);
				submenus.get(value).getUserChoice(e);
			}catch (NumberFormatException error){
				console.print("An Integer is expected");
			}catch (IndexOutOfBoundsException error){
				console.print(value + " is not between 1 and " + this.submenus.size());
			}finally{
				ask=true;
			}
			
		}
		e.addChoice(choice);
		
	}
	
	public void getEventChoice(Event e){
		submenus.get(Integer.parseInt(e.getNextChoice())).getEventChoice(e);
	}
	
	
	@Override
	public String toString(){
		String menuText = this.text;
		for (int i=0;i<submenus.size();i++){
			menuText += (i+1) + ") " + submenus.get(i).toString();
		}
		return menuText;
	}
	
}
