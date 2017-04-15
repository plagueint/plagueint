package terminal;

public interface Menu {
	public String toString();
	public String getName();
	public void getUserChoice(Main.Context context, propagation.Event e);
	public void getEventChoice(Main.Context context, propagation.Event e);
	final static Console console = new Console();
}
