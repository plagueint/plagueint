package terminal;
import java.util.ArrayList;
import propagation.Event;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class SubMenu implements Menu{
	
	
	private ArrayList<Menu> submenus = new ArrayList<Menu>();
	private String menuName;
	private Supplier<String> current;
	private int length = submenus.size();
	
	public SubMenu (String menuName,Supplier<String> current){
		this.menuName=menuName;
		this.current=current;
	}
	
	public SubMenu (String menuName){
		this.menuName=menuName;
		this.current=null;
	}
	
	public void add(Menu menu){
		this.submenus.add(length, menu);
		this.length+=1;
	}
	
	public void add(String s,Supplier<String> current){
		this.add(new SubMenu(s,current));
	}
	
	public void add(String s){
		this.add(s,null);
	}
	
	public void add(Consumer<String> consumer,String s,Supplier<String> actual){
		this.add(new MenuItem(consumer,s,actual));
	}
	
	public void add(Consumer<String> consumer,String s){
		this.add(consumer,s,null);
	}
	
	public void remove(int i){
		this.submenus.remove(i);
		this.length-=1;
	}
	
	public void remove(Menu menu){
		this.submenus.remove(menu);
		this.length-=1;
	}
	
	public String getMenuName() {
		return menuName;
	}

	protected void setName(String name) {
		this.menuName = name;
	}
	
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
				if (value != submenus.size()){
					submenus.get(value).getUserChoice(e.addChoice(choice));
				}else{
					ask=false;
				}
			}catch (NumberFormatException error){
				console.print("An Integer is expected");
			}catch (IndexOutOfBoundsException error){
				console.print(value + " is not between 1 and " + this.submenus.size());
			}
		}
	}
	
	public void getEventChoice(Event e){
		submenus.get(Integer.parseInt(e.getNextChoice())).getEventChoice(e);
	}
	
	
	@Override
	public String toString(){
		String menuText = "---" + this.getMenuName() + "---" + "\n";
		if (this.current != null && this.current.get() != ""){
			menuText+=this.current.get() + "\n";
		}
		int i;
		for (i=0;i<submenus.size();i++){
			menuText += (i+1) + ") " + submenus.get(i).getMenuName() + "\n";
		}
		menuText += (i+1) + ") Menu précédent\n";
		return menuText;
	}

	
}
