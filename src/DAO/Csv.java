package DAO;
import propagation.*;
import terminal.MenuItem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Csv {
	
	final static String dir="countriesData";
	
	public static ArrayList<String[]> read(String file, String separator, int[] infoPosition){ // Il y a un polymorphisme sans infoPosition (voir plus bas)
		/*
		 * Retourne sous forme de tableau les données d'un Csv
		 * 
		 * file : fichier Csv
		 * separator : séparateur des données
		 * infoPosition : position des infos à récupérer
		 */
		
		
		ArrayList<String[]> table = new ArrayList<String[]>(2);
		BufferedReader br = null ;
		String line = "" ;
		int nud = infoPosition.length;				// Number of Useful Data
		
		
		try {

            br = new BufferedReader(new FileReader(file));
            
            
            
            while ((line = br.readLine()) != null) {

                String[] data = line.split(separator);  // On split la ligne dans un tableau
                String[] useful_data = new String[nud];	// Tableau temporaire où l'on stocke les données de la ligne
                
                for (int i = 0; i < nud; i++) {
					useful_data[i] = data[infoPosition[i]];
					}
                
                table.add(useful_data);

            }

        } catch (FileNotFoundException e) {  
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error while opening the file");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the file");
                }
            }
        }
		
		return table;
	}
	
	
	
	
	
	public static ArrayList<String[]> read(String file, String separator){ 
		/*
		 * Grâce à ce polymorphisme on récupère toute les données (utiles pour les événements)
		 */
		
		
		ArrayList<String[]> table = new ArrayList<String[]>(2);
		BufferedReader br = null ;
		String line = "" ;
		
		
		try {

            br = new BufferedReader(new FileReader(file));
            
            while ((line = br.readLine()) != null) {

                String[] data = line.split(separator);  // On split la ligne dans un tableau

                table.add(data);

            }

        } catch (FileNotFoundException e) {  
            System.out.println("File not found");;
        } catch (IOException e) {
            System.out.println("Error while opening the file");;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the file");;
                }
            }
        }
		
		return table;
	}
	
	
	public static void exportEvent(String fileToWrite){
		try {
	        BufferedWriter out = new BufferedWriter(new FileWriter(fileToWrite));
	        for(Event e : MenuItem.events){
				out.write(e.toCSV());;
				out.newLine();
			}
	        out.close();
	        } catch (IOException e) {
	        	System.out.println("Error while opening file");
	        }
	}
	
	public static Event importEvent(String[] liste){
		double time=0;
		try{
			time = Double.parseDouble(liste[0]);
		}catch (NumberFormatException e){
			System.out.println("Error in parsing event");
		}
		Event e = new Event(time);
		for(String s : liste){
			e.getMenuPath().add(s);
		}
		return e;
	}
	
	public static ArrayList<Event> importEventList(String file, String separator){
		ArrayList<String[]> tableau=read(file,separator);
		ArrayList<Event> result= new ArrayList<Event>();
		for(String[] t:tableau){
			result.add(importEvent(t));
		}
		return result;
	}
	
	public static Country importCountry(String[] liste , int id){
		double population = Double.parseDouble(liste[1]);
		return new Country(id,population,0,0,population,1,liste[0]);
	}
	
	public static Cell[] importCountryList(String file, String separator){
		ArrayList<String[]> table=read(file,separator);
		int id = 0;
		int total=table.size();
		Cell[] result=new Cell[total];
		for (id=0;id<total;id++){
			result[id]=importCountry(table.get(id),id);
		}
		return result;
	}
	
	public static Border importBorder(String[] liste){
		return new Border(true,1,1,1);
	}
	
	public static Border[][][] importBorderList(String file,String separator,int countryTotal) throws UnexpectedFile{
		ArrayList<String[]> table=read(file,separator);
		int i = 0;
		int total=table.size();
		Border[][][] result=new Border[countryTotal][countryTotal][3];
		for (i=0;i<total;i++){
			int firstCountry=Integer.parseInt(table.get(0)[0]);
			int secondCountry=Integer.parseInt(table.get(0)[1]);
			
			if (file=="maritime.txt"){
				result[firstCountry][secondCountry][0]=new Maritime(true,0,0,1);
			}else if (file=="terrestre.txt"){
				result[firstCountry][secondCountry][1]=new Terrestre(true,0,0,1);
			}else if (file=="aerienne.txt"){
				result[firstCountry][secondCountry][2]=new Aérienne(true,0,0,1);
			}else{
				throw new UnexpectedFile();
			}
			
		}
		
		return result;
	}
	
	
	public static String exportData(double time,Country c){
		return time + ";" + c.toCSV();
	}
	public static void exportAllCountry(double time,GenericModel m){
		double t = time * m.getDt();
		for (Cell cell : m.getNetwork().getCells()){
			Country c=(Country) cell;
			try {
		        BufferedWriter out = new BufferedWriter(new FileWriter(c.getName()));
		        out.write(exportData(t,c));;
		        out.close();
		    } catch (IOException e) {
		        	System.out.println("Error while opening file");
		    }
		}
	}
}
