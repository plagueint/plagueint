package terminal;
import propagation.Event;

public interface Menu {
	public String toString();
	public void getUserChoice(Event e);
	public void getEventChoice(Event e);
	public static final Console console=new Console();
}
