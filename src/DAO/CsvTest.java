package DAO;

import java.util.ArrayList;

import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;



//import junit.framework.Assert;

public class CsvTest {
	
	String file = "data/test_files/CSV.txt";
	String separator = ",";
	
	/* Contenu du fichier
	1,2,3
	a,b,c
	alpha,beta,gamma
	*/
	
	@Test
	public void read_EveryFields() {
		ArrayList<String[]> data = Csv.read(file, separator);
		Assert.assertEquals("1", data.get(0)[0]);
		Assert.assertEquals("2", data.get(0)[1]);
		Assert.assertEquals("3", data.get(0)[2]);
		Assert.assertEquals("a", data.get(1)[0]);
		Assert.assertEquals("b", data.get(1)[1]);
		Assert.assertEquals("c", data.get(1)[2]);
		Assert.assertEquals("alpha", data.get(2)[0]);
		Assert.assertEquals("beta", data.get(2)[1]);
		Assert.assertEquals("gamma", data.get(2)[2]);
	}
	
	
	@Test
	public void read_SelectedFields() {
		int[] position = {2,1};
		ArrayList<String[]> data = Csv.read(file, separator, position);
		Assert.assertEquals("2", data.get(0)[1]);
		Assert.assertEquals("3", data.get(0)[0]);
		Assert.assertEquals("b", data.get(1)[1]);
		Assert.assertEquals("c", data.get(1)[0]);
		Assert.assertEquals("beta", data.get(2)[1]);
		Assert.assertEquals("gamma", data.get(2)[0]);
	}

}
