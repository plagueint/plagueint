package terminal;

public interface Menu {
	public String toString();
	public String getMenuName();
	public void getUserChoice(propagation.Event e);
	public void getEventChoice(propagation.Event e);
	public Boolean isAvailable();
	final static Console console = new Console();
}
