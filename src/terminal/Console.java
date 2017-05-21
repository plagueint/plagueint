package terminal;
import java.io.PrintStream;
import java.util.Scanner;



public class Console {

	
	private Scanner reader = new Scanner(System.in);
	private PrintStream printer = new PrintStream(System.out);
	private PrintStream error= new PrintStream(System.err);
	
	public String readLine() {
        return reader.nextLine();
    }
	
	public void print(String s){
		printer.print(s);
	}
	
	public void printErr(String s){
		error.print(s);
	}
	
	public void close(){
		reader.close();
		printer.close();
		error.close();
	}
}
