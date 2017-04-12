package terminal;
import java.util.Scanner;



public class Console {

	
	private Scanner reader = new Scanner(System.in);
	
	public String readLine() {
        return reader.nextLine();
    }
	
	public void end(){
		reader.close();
	}
}
