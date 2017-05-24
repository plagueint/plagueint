package terminal;

import java.util.concurrent.ConcurrentLinkedQueue;

public interface Menu {
	public String toString();
	public String getMenuName();
	public void getUserChoice(propagation.Event e);
	public void getEventChoice(propagation.Event e);
	public Boolean isAvailable();
	public String getCurrentState();
	public String readMenuPath(ConcurrentLinkedQueue<String> menuPath);
	final static Console console = new Console();
}
