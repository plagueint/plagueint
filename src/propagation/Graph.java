package propagation;
import java.util.ArrayList;

public class Graph {
	
	public Graph(ArrayList<Border>[][] edges, Cell[][] cells) {
		super();
		this.edges = edges;
		this.cells = cells;
	}
	
	private ArrayList<Border>[][] edges;
	private Cell[][] cells;
	
	
	public Graph (){
		//Extract information from CSV and fill up countries and edges
	}

	public ArrayList<Border>[][] getEdges() {
		return edges;
	}
	public void setEdges(ArrayList<Border>[][] edges) {
		this.edges = edges;
	}
	public Cell[][] getCells() {
		return cells;
	}
	public void setCells(Cell[][] cells) {
		this.cells = cells;
	}
	
}
