package terminal;

public interface Menu {
	public String toString();
	public String getName();
	public void getUserChoice(propagation.Event e);
	public void getEventChoice(propagation.Event e);
	final static Console console = new Console();
}
