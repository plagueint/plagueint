package propagation;

public class Graph {
	
	 
	public Graph(Border[][][] edges, Cell[] cells) {
		super();
		this.edges = edges;
		this.cells = cells;
	}
	
	private Border[][][] edges;
	private Cell[] cells;
	
	/* À décommenter lorsque les fichiers à la racine seront valides.
	public Graph (){
		int nb = 3;
		this.cells=new Cell[nb];
		this.cells=DAO.Csv.importCountryList("population_mondiale.txt",";"); //importe la liste de tous les pays [Fr, Al,..]
		
		
		
		
}
*/
	
	public Graph (){
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
