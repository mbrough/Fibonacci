package main;
public class PrimHeapNode {
	
	private static int INFINITY = Integer.MAX_VALUE;
	
	private double label;
	private Vertex myVertex;
	private Vertex mySource; //edge that connects to label
	private boolean isVisited;
	private int heapPosition;
	
	@SuppressWarnings("unused")
	private PrimHeapNode() {
		//prevent default instantiation
	}
	
	public PrimHeapNode(Vertex name, int position) {
		label = INFINITY;
		myVertex = name;
		mySource = null;
		isVisited = false;
		heapPosition = position;
		
	}


	public Vertex getVertex() {
		return myVertex;
	}


	public Vertex getSource() {
		return mySource;
	}


	public void setSource(Vertex theSource) {
		this.mySource = theSource;
	}


	public boolean isVisited() {
		return isVisited;
	}


	public void setVisited(boolean visited) {
		this.isVisited = visited;
	}


	public int getHeapPosition() {
		return heapPosition;
	}
	

	public void setHeapPosition(int newPosition) {
		this.heapPosition = newPosition;
	}

	public int compareTo(PrimHeapNode that) {
		return (int) (this.label - that.label);
	}
	
	public void setLabel(double theWeight) {
		label = theWeight;
	}
	
	public double getLabel() {
		return label;
	}
	
	public String toString() {
		return "" + label;
	}
}