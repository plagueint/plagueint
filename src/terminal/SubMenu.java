package terminal;
import java.util.ArrayList;
import propagation.Event;
import Main.Context;


public class SubMenu implements Menu{
	
	
	private ArrayList<Menu> submenus = new ArrayList<Menu>();
	private String name;
	private int length = submenus.size();
	
	public SubMenu (String name){
		this.name=name;
	}
	
	public void add(Menu menu){
		this.submenus.add(length, menu);
		this.length+=1;
	}
	
	public void remove(int i){
		this.submenus.remove(i);
		this.length-=1;
	}
	
	public void remove(Menu menu){
		this.submenus.remove(menu);
		this.length-=1;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void getUserChoice(Context context, Event e){
		int value=0;
		String choice = "";
		boolean ask=true;
		while(ask){
			ask=false;
			console.print(this.toString());
			console.print("\nChoice ?:");
			try{
				choice = console.readLine();
				value = Integer.parseInt(choice)-1;
				if (value != submenus.size()){
					submenus.get(value).getUserChoice(context,e.addChoice(choice));
				}else{
					ask=true;
				}
			}catch (NumberFormatException error){
				console.print("An Integer is expected");
			}catch (IndexOutOfBoundsException error){
				console.print(value + " is not between 1 and " + this.submenus.size());
			}finally{
				ask=true;
			}
		}
	}
	
	public void getEventChoice(Context context,Event e){
		submenus.get(Integer.parseInt(e.getNextChoice())).getEventChoice(context,e);
	}
	
	
	@Override
	public String toString(){
		String menuText = "---" + this.name + "---" + "\n";
		int i;
		for (i=0;i<submenus.size();i++){
			menuText += (i+1) + ") " + submenus.get(i).getName() + "\n";
		}
		menuText += (i+1) + ") Menu précédent\n";
		return menuText;
	}

	
}
