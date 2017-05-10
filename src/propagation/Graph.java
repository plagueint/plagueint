package propagation;

public class Graph {
	
	 
	public Graph(Border[][][] edges, Cell[] cells) {
		super();
		this.edges = edges;
		this.cells = cells;
	}
	
	private Border[][][] edges;
	private Cell[] cells;
	
	
	public Graph (){
		//Extract information from CSV and fill up countries and edges
		this.edges=new Border[1][1][1];
		this.edges[0][0][0]=new Border();
		this.cells=new Cell[1];	
		this.cells[0]=new Country();
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
