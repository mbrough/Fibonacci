package main;
import java.util.*;

/**
 * PowerGridApp is an implementation of Prim's minimum spanning tree algorithm.
 * Given a text file with well formed input representing a series of edges,
 * PowerGridApp will produce a minimum spanning tree from an arbitrary starting
 * vertex. This implementation utilizes a heap, and updates possible paths from the current vertex
 * via the heap.
 * @author Ian Cresse - primary coder.
 * @author Molly Brougham - code review.
 * @author Jason Nam - code review.
 *
 */
public class PowerGridApp {
	
	/**
	 * Executes PowerGridApp and produces a minimum spanning tree.
	 * @param theArgs - unused
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] theArgs) {
		SimpleGraph g = new SimpleGraph();
		Hashtable<String, Vertex> table = GraphInput.LoadSimpleGraph(g);
		PrimPriorityQueue heap = new PrimPriorityQueue(); //prioq. needs a lot of adjustments.
		List<PrimHeapNode> output = new ArrayList<PrimHeapNode>();

//		System.out.println("heap, output and table created successfully");
		initializeHeap(table, heap);
//		System.out.println("heap initialized.");
//		System.out.println(heap);
		System.out.println();
		buildGrid(g, heap, output);
		output(output);
	}
	
	/**
	 * Sets up the heap given a SimpleGraph with a list of vertices, and the
	 * heap to put the vertices into. Also sets an arbitrary vertex to be the
	 * beginning of the algorithm's traversal.
	 * @param theTable - the table containing the vertices.
	 * @param theHeap - the heap to add vertices to.
	 */
	public static void initializeHeap(
			Hashtable<String, Vertex> theTable, PrimPriorityQueue theHeap) {
		for (String s : theTable.keySet()) {
			PrimHeapNode temp = new PrimHeapNode(theTable.get(s), theHeap.size());
			theTable.get(s).setData(temp);
			theHeap.add(temp);
		}
		PrimHeapNode starter = theHeap.remove();
		System.out.println("Name of starting vertex: " + (String) starter.getVertex().getName());
		starter.setLabel(0);
		starter.setSource(starter.getVertex());
		theHeap.add(starter);
	}
	
	/**
	 * Builds the actual minimum spanning tree given a heap with |V| elements,
	 * where V is the set of vertices.
	 * @param theGraph - used to retrieve edges connected to a particular vertex
	 * @param theHeap - contains all vertices
	 * @param theOutput - the list of removed PrimHeapNodes that contain the best path.
	 */
	public static void buildGrid(SimpleGraph theGraph, PrimPriorityQueue theHeap, 
			List<PrimHeapNode> theOutput) {
		while (!theHeap.isEmpty()) {
//			System.out.println("New Node");
			PrimHeapNode current = theHeap.remove();
			current.setVisited(true);
			Iterator<Edge> edgeList = theGraph.incidentEdges(current.getVertex());

			while (edgeList.hasNext()) {
//				System.out.println("New Edge");
//				declare variables for readability
				Edge edge = (Edge) edgeList.next();
				Vertex first = edge.getFirstEndpoint();
				Vertex second = edge.getSecondEndpoint();
//				System.out.println(edge.getData());
				
//				check first vertex
				if (!((PrimHeapNode) first.getData()).isVisited()
						&& ((PrimHeapNode) second.getData()).isVisited()) {
//					System.out.println("First unvisited, second is");
					PrimHeapNode firstNode = (PrimHeapNode) first.getData();
					if (firstNode.getLabel() > (double) edge.getData()) {
//						System.out.println("Updating first vertex label. Old heapPosition: " + firstNode.getHeapPosition());
						firstNode.setLabel((double) edge.getData());
						firstNode.setSource(current.getVertex());
						theHeap.bubbleUp(firstNode.getHeapPosition());
//						System.out.println("New HeapPosition: " + firstNode.getHeapPosition());
					}
					
//				check second vertex
				} else if (((PrimHeapNode) first.getData()).isVisited() 
						&& !((PrimHeapNode) second.getData()).isVisited()) {
//					System.out.println("Second unvisited, first is");
					PrimHeapNode secondNode = (PrimHeapNode) second.getData();
					if (secondNode.getLabel() > (double) edge.getData()) {
//						System.out.println("Updating second vertex label. Old heapPos: " + secondNode.getHeapPosition());
						secondNode.setLabel((double) edge.getData());
						secondNode.setSource(current.getVertex());
						theHeap.bubbleUp(secondNode.getHeapPosition());
//						System.out.println("New HeapPosition: " + secondNode.getHeapPosition());
					}
				}
			}
//			spacing
//			System.out.println();
			theOutput.add(current);
		}
	}
	
	/**
	 * Constructs readable output representing a minimum spanning tree.
	 * @param theOutput - list that contains all removed PrimHeapNodes with ideal paths.
	 */
	public static void output(List<PrimHeapNode> theOutput) {
		for (int i = 0; i < theOutput.size(); i++) {
			PrimHeapNode current = theOutput.get(i);
			System.out.println((String) current.getSource().getName() + 
					" to " + (String) current.getVertex().getName() + 
					": " + current.getLabel());
		}
	}
}
