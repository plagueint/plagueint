package propagation;

import DAO.UnexpectedFile;

public class Graph {
	
	 
	public Graph(Border[][][] edges, Cell[] cells) {
		super();
		this.edges = edges;
		this.cells = cells;
	}
	
	private Border[][][] edges;
	private Cell[] cells;
	
	public Graph (){
		/* À décommenter si l'on veut rentrer 3 pays à la main 
		int nb = 3; //Nombre de pays
		this.cells=new Cell[nb];
		*/
		this.cells=new Cell[18];
		this.cells=DAO.Csv.importCountryList("data/linuxmap/country.txt",","); //importe la liste de tous les pays [Fr, Al,..]
		
		//3 car il y a trois types de borders: maritime, terreste, aérien
		this.edges=new Border[18][18][3];
		//countryTotal est le nombre de pays
		
		//On n'utilise un try/catch car les throws renvoie la gestion de l'erreur à la classe qui appelle
		try {
			this.edges=DAO.Csv.importBorderList("data/linuxmap/maritime.txt",",",18);
		} catch (UnexpectedFile e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			this.edges=DAO.Csv.importBorderList("data/linuxmap/terreste.txt",",", 18);
		} catch (UnexpectedFile e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

	
/*	public Graph (){
		//Extract information from CSV and fill up countries and edges
		int nb = 3;
		this.cells=new Cell[nb];	
		for (int i=0;i<nb;i++) {
			this.cells[i]=new Country();
		}
		this.edges=new Border[nb][nb][3];
		for (int i=0;i<nb;i++) {
			for (int j=0;j<nb;j++) {
				this.edges[i][j][0]=new Land();
				this.edges[i][j][1]=new Air();
				this.edges[i][j][2]=new Maritime();
			}
		}
	}
	*/

	public Border[][][] getEdges() {
		return edges;
	}
	public void setEdges(Border[][][] edges) {
		this.edges = edges;
	}
	public Cell[] getCells() {
		return cells;
	}
	public void setCells(Cell[] cells) {
		this.cells = cells;
	}
	
}
