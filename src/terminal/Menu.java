package terminal;
import java.io.Console;
import java.util.function.Consumer;
import propagation.*;

public class Menu {
	
	GenericModel model;
	
	final private static Console console=System.console();
	
	/*
	 * Prend en argument la fonction qui change la valeur de l'attribut souhaité
	 * ex : voir la permière fonction sous les getters simples
	*/
	float getFloat(Consumer<Float> function){
		String s="";
		float number=0;
		boolean ask=true;
		while (ask){
			try{
				s=console.readLine();
				number=Float.parseFloat(s);
				ask=false;
				function.accept(number);
			} catch (NumberFormatException e){
				System.out.println(s + "is not a float");
				ask=true;
			} catch (Exception e){
				System.out.println(e.getMessage());
			}
		}
		return number;
	}
	
	String getString(Consumer<String> function){
		String s="";
		boolean ask=true;
		while (ask){
			try{
				s=console.readLine();
				ask=false;
				function.accept(s);
			} catch (Exception e){
				System.out.println(s + "is not correct");
				ask=true;
			}
		}
		return "";
	}
	
	double getDouble(Consumer<Double> function){
		String s="";
		boolean ask=true;
		double number=0;
		while(ask){
			try{
				s=console.readLine();
				ask=false;
				number = Double.parseDouble(s);
				function.accept(number);
			} catch (NumberFormatException e){
				System.out.println(s + "is not a double");
				ask=true;
			}
		}
		return number;
	}
	
	int getMenuChoice(int limit){ //limite: numéro du dernier choix
		String s="";// La chaine de caractère que l'utilisateur rentre
		boolean ask=true;
		int number=0;// Le nombre que l'utilisateur veut rentrer
		while(ask){
			try{
				s=console.readLine();
				number = Integer.parseInt(s);
				if (number > 0 && number <= limit){
					ask=false;
				}
			} catch (NumberFormatException e){
				System.out.println(s + "is not an integer");
				ask=true;
			}
		}
		return number;
	}
	
	
	/*
	 * Menu paramètres initiaux : Pays + nbre infectés
	 */
	void cellParamMenu (Cell cell){
		boolean stay=true;
		while (stay){
			System.out.println("");
			switch (getMenuChoice(2)){
				case 1:
					//number of susceptibles
					getDouble(x -> cell.setSusceptibles(x));
					break;
				case 2:
					//number of infectives
					getDouble(x -> cell.setInfectives(x));
					break;
				case 3:
					//number recovered
					getDouble(x -> cell.setRecovered(x));
					break;
				case 4:
					stay=false;
					break;
			}
		}
	}
	
	public static void main(String[] args){
		// C'est cette méthode main qui gère tous les appels
			
		while (true)
		{
			
		}
		}
	
}
