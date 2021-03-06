package terminal;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

import propagation.Event;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.BooleanSupplier;

public class SubMenu implements Menu{
	
	
	protected ArrayList<Menu> submenus = new ArrayList<Menu>();
	
	
	public ArrayList<Menu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(ArrayList<Menu> submenus) {
		this.submenus = submenus;
	}


	private String menuName;
	protected Supplier<String> current;
	private int length = submenus.size();
	private BooleanSupplier available;
	
	public SubMenu(String menuName,Supplier<String> current,BooleanSupplier available){
		this.menuName=menuName;
		this.current=current;
		this.available=available;
	}
	
	public SubMenu (String menuName,Supplier<String> current){
		this.menuName=menuName;
		this.current=current;
		this.available=()->true;
	}
	
	public SubMenu(String menuName,BooleanSupplier available){
		this.menuName=menuName;
		this.available=available;
	}
	
	public SubMenu (String menuName){
		this.menuName=menuName;
		this.current=null;
		this.available=()->true;
	}
	
	public void add(Menu menu){
		this.submenus.add(length, menu);
		this.length+=1;
	}
	
	public void add(String s,Supplier<String> current,BooleanSupplier available){
		this.add(new SubMenu(s,current,available));
	}
	
	public void add(String s,BooleanSupplier available){
		this.add(new SubMenu(s,available));
	}
	
	public void add(String s,Supplier<String> current){
		this.add(new SubMenu(s,current));
	}
	
	public void add(String s){
		this.add(s,()->"",()->true);
	}
	
	public void add(Consumer<String> consumer,String s,Supplier<String> actual,BooleanSupplier available){
		this.add(new MenuItem(consumer,s,actual,available));
	}
	
	public void add(Consumer<String> consumer, String s,Supplier<String> actual){
		this.add(consumer,s,actual,()->true);
	}
	
	public void add(Consumer<String> consumer, String s,BooleanSupplier available){
		this.add(consumer,s,()->"",available);
	}
	
	
	public void add(Consumer<String> consumer,String s){
		this.add(consumer,s,()->"",()->true);
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
	
	public Boolean isAvailable(){
		return this.available.getAsBoolean();
	}
	
	public String getCurrentState(){
		return this.current.get();
	}
	
	public void getNextMenu(int value,Event e,String choice){
		submenus.get(value).getUserChoice(e.addChoice(choice));
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
				if (value == -1){
					ask=false;
				}else if (submenus.get(value).isAvailable()){
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
	
	public void getEventChoice(Event e){
		submenus.get(Integer.parseInt(e.getNextChoice())-1).getEventChoice(e);
	}
	
	
	@Override
	public String toString(){
		String menuText = "---" + this.getMenuName() + "---" + "\n";
		if (this.current != null && this.getCurrentState() != ""){
			menuText+=this.getCurrentState() + "\n";
		}
		int i;
		menuText += 0 + ") Menu précédent\n";
		for (i=0;i<submenus.size();i++){
			menuText += (i+1) + ") " + submenus.get(i).getMenuName();
			if (!this.submenus.get(i).isAvailable()){
				menuText+=" [Indisponible]";
			}
			menuText+="\n";
		}
		return menuText;
	}
	
	public String readMenuPath(ConcurrentLinkedQueue<String> menuPath){
		if (menuPath.size()==2){
			return this.getMenuName() + " : " + this.submenus.get(Integer.parseInt(menuPath.poll())-1).readMenuPath(menuPath)  ;
		}else{
			return this.submenus.get(Integer.parseInt(menuPath.poll())-1).readMenuPath(menuPath);
		}
	}

	
}
