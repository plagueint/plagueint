package terminal;
//import java.io.Console;
import terminal.Console;
import java.util.function.*;
import propagation.Event;
/**
 * @author varens
 *
 */

public class Util {
	
	/*
	 * Prend en argument la fonction qui change la valeur de l'attribut souhaité
	 * ex : voir la permière fonction sous les getters simples
	*/
	static float getFloat(Console console){
		String s="";
		float number=0;
		boolean ask=true;
		while (ask){
			try{
				s=console.readLine();
				number=Float.parseFloat(s);
				ask=false;
			} catch (NumberFormatException e){
				System.out.println(s + "is not a float");
				ask=true;
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return number;
	}
	
	static void applyFloat(Consumer<Float> function,Supplier<Float> input){
		function.accept(input.get());
	}
	
	static String getString(Console console){
		String s="";
		boolean ask=true;
		while (ask){
			try{
				s=console.readLine();
				ask=false;
			} catch (Exception e){
				System.out.println(s + "is not correct");
				ask=true;
			}
		}
		return "";
	}
	
	static void applyString(Consumer<String> function,Supplier<String> input){
		function.accept(input.get());
	}
	
	static double getDouble(Console console){
		String s="";
		boolean ask=true;
		double number=0;
		while(ask){
			try{
				s=console.readLine();
				ask=false;
				number = Double.parseDouble(s);
			} catch (NumberFormatException e){
				System.out.println(s + "is not a double");
				ask=true;
			}
		}
		return number;
	}
	
	
	static void applyDouble(Consumer<Double> function,Supplier<Double> input){
		function.accept(input.get());
	}
	
	static Integer getInteger(Console console){
		String s="";
		boolean ask=true;
		int number=0;
		while(ask){
			try{
				s=console.readLine();
				ask=false;
				number = Integer.parseInt(s);
			} catch (NumberFormatException e){
				System.out.println(s + "is not a Integer");
				ask=true;
			}
		}
		return number;
	}
	
	
	static void applyInteger(Consumer<Integer> function,Supplier<Integer> input){
		function.accept(input.get());
	}
		
	
	static int verifyMenuChoice(int limit, Supplier<Integer> function){
		int choice = 0;
		boolean ask=true;
		while (ask){
			choice=function.get();
			if (choice > 0 && choice <= limit){
				ask=false;
			}
			else{
				System.out.println(choice + " is not between 1 and " + limit);
			}
		}
		return choice;
	}
	
}
