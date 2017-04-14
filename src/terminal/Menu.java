package terminal;
import Main.Context;

public interface Menu {
	public String toString();
	public String getName();
	public void getUserChoice(Context context, propagation.Event e);
	public void getEventChoice(Context context, propagation.Event e);
	final static Console console = new Console();
}
