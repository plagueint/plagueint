package terminal;
import java.io.Console;
import java.util.function.Function;
import propagation.GenericModel;

public class Menu {
	
	GenericModel model;
	
	final private static Console console=System.console();
	
	/*
	 * Prend en argument la fonction qui change la valeur de l'attribut souhaité
	 * ex : voir la permière fonction sous les getters simples
	*/
	float getFloat( Function <Float,Void> function){
		String s="";
		float number=0;
		boolean ask=true;
		while (ask){
			try{
				s=console.readLine();
				number=Float.parseFloat(s);
				ask=false;
				function.apply(number);
			} catch (NumberFormatException e){
				System.out.println(s + "is not a float");
				ask=true;
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return number;
	}
	
	String getString(){
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
	
	double getDouble(){
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
	
	
	/*
	 * Fonction exemple 
	 */
	void menuPrincipal(){
		String s="";// La chaine de caractère que l'utilisateur rentre
		boolean ask=true;
		int number=0;// Le nombre que l'utilisateur veut rentrer
		while(ask){
			try{
				s=console.readLine();
				ask=false;
				number = Integer.parseInt(s);
			} catch (NumberFormatException e){
				System.out.println(s + "is not an integer");
				ask=true;
			}
		}
		
		switch (number){
			case 1:getFloat(model.setInfectives);
		}
	}
	
}
