package terminal;
import java.io.Console;
import java.util.function.*;
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
	
	
	static int getUserMenuChoice(int limit,Console console){ //limite: numéro du dernier choix
		String s="";// La chaine de caractère que l'utilisateur rentre
		boolean ask=true;
		int number=0;// Le nombre que l'utilisateur veut rentrer
		while(ask){
			try{
				number=getInteger(console);
				if (number > 0 && number <= limit){
					ask=false;
				}
			} catch (NumberFormatException e){
				System.out.println(s + "is between 1 and" + limit);
				ask=true;
			}
		}
		return number;
	}
	
	
	
	
}
