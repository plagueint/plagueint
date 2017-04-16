package terminal;

public interface Menu {
	public String toString();
	public String getMenuName();
	public void getUserChoice(propagation.Event e);
	public void getEventChoice(propagation.Event e);
	public Boolean isAvailable();
	public String getCurrentState();
	final static Console console = new Console();
}
