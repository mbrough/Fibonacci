package main;
import java.util.ArrayList;

/**
 * The array implementation of a PriorityQueue. The child of a node is located
 * at indexes (2i+1) and (2i+2). 0 has children at 1 and 2, 1 has children at 3
 * and 4, and so on. By extension, the parent of a node is at the (i - 1)/2 (6's
 * parent is at 5/2, 2. 10's parent is at 9/2, 4) etc. This implementation is a
 * minimum priority queue.
 *
 * @author Robert Ferguson Primary coder.
 * @author Ian Cresse Code Review
 * @author Molly Brougham Edited for use with Prim's Algorithm
 * @param PrimHeapNode
 *            The object that the queue holds. Must implement comparable.
 *            compareTo is assumed to return a negative number of the object
 *            comparing is smaller than the object it is being compared to.
 */
public class PrimPriorityQueue {
	
	/**
	 * Changes to variables:
	 * - Scope now private
	 * - list name changed from prio to primList
	 * - list type changed from generic List to ArrayList
	 * - ArrayList now takes type PrimHeapNode instead of T
	 */
	private ArrayList<PrimHeapNode> primList;
	private int size;

	/**
	 * Creates a new priorityQueue
	 * changes:
	 * - ArrayList updated to take PrimHeapNode
	 */
	public  PrimPriorityQueue() {
		primList = new ArrayList<PrimHeapNode>();
	}

	/**
	 * Adds a new element to the queue.
	 * The element is added to the end and then bubbles up to it's proper
	 * priority in the queue.
	 * 
	 * @param element The element to add.
	 * 
	 * Changes:
	 * - element is now of type PrimHeapNode
	 */
	public void add(PrimHeapNode element) {
		primList.add(element);
		bubbleUp(size++);
		

		// Make sure the heap invariant is maintained.
		if (hasLeftChild(0)) {
			assert primList.get(0).compareTo(primList.get(leftChildOf(0))) < 0;
		}
		if (hasRightChild(0)) {
			assert primList.get(0).compareTo(primList.get(rightChildOf(0))) < 0;
		}
	}

	/**
	 * Removes and returns the item in the queue with the most priority. Brings
	 * the next item up to be removed.
	 * 
	 * This is accomplished by creating a reference to the top most (highest
	 * priority) element and then swapping it to the place of the lowest
	 * priority element. It is then removed. Since the lowest priority element
	 * is now out of place at the top of the queue, it is allowed to sink until
	 * it reaches where it is supposed to be in priority.
	 * ------This method is unchanged------
	 */
	public PrimHeapNode remove() {
		PrimHeapNode temp = getRoot();
		swapIndexes(0, --size);
		primList.remove(size);
		int test = sink();

		// Make sure the heap invariant is maintained.
		if (hasParent(test))
			assert primList.get(parentOf(test)).compareTo(primList.get(test)) < 0;
		if (hasLeftChild(test))
			assert primList.get(test).compareTo(primList.get(leftChildOf(test))) < 0;
		if (hasRightChild(test))
			assert primList.get(test).compareTo(primList.get(rightChildOf(test))) < 0;

		return temp;
	}

	/**
	 * Causes the index passed to rise up to its priority.
	 * @param index The index to bubbleUp.
	 * ------This method is unchanged------
	 */
	public void bubbleUp(int index) {
		// as long as you have a parent and you're of a higher priority than
		// your parent
		while (hasParent(index) && primList.get(index).compareTo(primList.get(parentOf(index))) < 0) {
			swapIndexes(index, parentOf(index));
			index = parentOf(index);
			
		}
		
	}

	/**
	 * Sinks the element at the highest priority until it reaches their actual
	 * priority.
	 * ------This method is unchanged------
	 */
	public int sink() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChild = childToPromote(index);
			if (primList.get(index).compareTo(primList.get(smallerChild)) >= 0)
				swapIndexes(index, smallerChild);
			else
				return index; // it's sunk as low as it needs to
			index = smallerChild;
		}
		return index;
	}

	/**
	 * Swaps the indexes in a priority queue.
	 * @param index the first index.
	 * @param swap the index it's swapping with.
	 * 
	 * Changes:
	 * Updates heapPosition variable of PrimHeapNode to its new location
	 */
	public void swapIndexes(int index, int swap) {
		PrimHeapNode temp = primList.get(index);
		primList.set(index, primList.get(swap));
		primList.set(swap, temp);
		
		primList.get(index).setHeapPosition(index);
		primList.get(swap).setHeapPosition(swap);
	}

	/**
	 * Returns the index of a child element that is of a higher priority than
	 * the other child element.
	 * 
	 * @param index The index that has child to test against each other.
	 * @return The index of the winner.
	 * ------This method is unchanged------
	 */
	private int childToPromote(int index) {
		if (!hasRightChild(index)) 
			return leftChildOf(index);
		else
			return (primList.get(leftChildOf(index)).compareTo(primList.get(rightChildOf(index)))) <= 0 ? leftChildOf(index)
					: rightChildOf(index);
	}

	/**
	 * Get the index of the left child of the index you passed to it. Does not
	 * guarantee that the index exists in the list.
	 * @param index the index to check.
	 * @return The index that the left child is located at.
	 * ------This method is unchanged------
	 */
	private int leftChildOf(int index) {
		return (2 * index) + 1;
	}

	/**
	 * Get the index of the right child of the index you passed to it. Does not
	 * guarantee that the index exists in the list.
	 * @param index the index to check.
	 * @return The index that the right child is located at.
	 * ------This method is unchanged------
	 */
	private int rightChildOf(int index) {
		return (2 * index) + 2;
	}

	/**
	 * Returns whether or not an element has a child to it's left. Elements are
	 * defined as having a left child if the index equal to twice their index,
	 * plus 1, exists in the priority queue.
	 * 
	 * @param index The index to check.
	 * @return Whether or not the node has a left child.
	 * ------This method is unchanged------
	 */
	private boolean hasLeftChild(int index) {
		return leftChildOf(index) < size;
	}

	/**
	 * Returns whether or not an element has a child to it's right. Elements are
	 * defined as having a left right if the index equal to twice their index,
	 * plus 2, exists in the priority queue.
	 * 
	 * @param index The index to check.
	 * @return Whether or not the node has a right child.
	 * ------This method is unchanged------
	 */
	private boolean hasRightChild(int index) {
		return rightChildOf(index) < size;
	}

	/**
	 * Get the index of the parent of the index you passed to it. Does not
	 * guarantee that the index exists in the list.
	 *
	 * @param index the index to check.
	 * @return The index that the parent is located at.
	 * ------This method is unchanged------
	 */
	private int parentOf(int index) {
		return (index - 1) / 2;
	}

	/**
	 * Checks to see if the priority queue is empty.
	 *
	 * @return Returns true if there is nothing in the queue, false otherwise.
	 * ------This method is unchanged------
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns how many objects are currently in the queue.
	 *
	 * @return Size of the queue.
	 * ------This method is unchanged------
	 */
	public int size() {
		return size;
	}

	/**
	 * Gives a reference to the first object in the queue.
	 *
	 * @return The element in the queue with the most priority.
	 * ------This method is unchanged------
	 */
	private PrimHeapNode getRoot() {
		return primList.get(0);
	}

	/**
	 * Returns a boolean of whether or not a given element has a parent.
	 * 
	 * @param index the index of the element to check.
	 * @return whether that element has a parent.
	 * 
	 * Changes:
	 * JavaDoc added
	 */
	private boolean hasParent(int index) {
		return index > 0; // only the root does not have a parent.
	}

	
	/**
	 * Returns the list of elements as a string.
	 * 
	 * Changes:
	 * JavaDoc added
	 */
	public String toString() {
		StringBuilder tempString = new StringBuilder();
		for (PrimHeapNode element : primList) {
			tempString.append(element.toString());
		}
		return tempString.toString();
	}
}
