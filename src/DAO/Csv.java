package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Csv {
	public static ArrayList<String[]> read(String file, String separator, int[] infoPosition){ 
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
            
            String[] useful_data = new String[nud];	// Tableau temporaire où l'on stocke les données de la ligne
            
            while ((line = br.readLine()) != null) {

                String[] data = line.split(separator);  // On split la ligne dans un tableau
                
                for (int i = 0; i < nud; i++) {
					useful_data[i] = data[infoPosition[i]];
				}
                System.out.println(useful_data[0]);
                table.add(useful_data);

            }

// Début de la partie empruntée
        } catch (FileNotFoundException e) {  
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
// Fin de la partie empruntée
		
		return table;
	}
	
}
