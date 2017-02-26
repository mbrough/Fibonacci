package main;
/**
 * A class to find the largest distance between two numerically, not 
 * indexed, adjacent values in an array.
 * @author Molly Brougham
 * @version 2/24/2017
 *
 */
public class CalculationDriver {
	
	/**
	 * Creates an array and finds the maximum index distance between two unique numbers 
	 * in the array, such that if P is equal to one value in the array and Q is equal to 
	 * another value, there is no number Z such that P <= Z <= Q. Prints a solution, X, 
	 * which defines the distance in indices between two such numbers P and Q.  
	 * @param theArgs - unused
	 */
	public static void main(String[] args) {
		//create an array of numbers.
		int[] A = {1, 4, 7, 3, 3, 5};
		
		//create an array of tuples with the same length as the original array A.
		Tuple[] indices = new Tuple[A.length];
		
		//fill the array of Tuples(X,Y) such that X = original array value and 
		//Y = original array index. 
		for(int i = 0; i < A.length; i++) {
			Tuple current = new Tuple();
			current.setValue(A[i]);
			current.setIndex(i);
			indices[i] = current;
		}
		
		//sort the array of tuples by value, rather than index
		indices = sort(indices, 0, indices.length - 1);
		
		//find the solution of the tuple array and prints it.
		System.out.println("solution: " + findSolution(indices));
	
	}
	
	/**
	 * Takes a sorted array of tuples and finds X, such that X is the maximum distance
	 * between in indices of two values P and Q, where there is no value Z such that 
	 * P <= Z <= Q.
	 * @param indices The sorted array of Tuples(value, index)
	 * @return the maximum index distance between adjacent values, or -1 if there are
	 * no acceptable solutions.
	 */
	private static int findSolution(Tuple[] indices) {
		//set solution base case
		int solution = -1;
		
		//sets the first test case index
		int prev = indices[0].index; 
		
		//iterate tuple list
		for (int i = 1; i < indices.length; i++) {
			//determine current index
			int cur = indices[i].index;
			
			if ((i+1) < indices.length) {
				int curVal = indices[i].getValue();
				int nextVal = indices[i+1].getValue();
				if (curVal == nextVal) {
					continue;
				}
			}
			
			//calculate the distance between the current index and the previous index
			int dist = Math.abs(cur - prev);
			
			//if the new distance is greater than the current maximum distance, replace it 
			if (dist > solution) {
				solution = dist;
			}
			
		}
		
		return solution;
	}
	
	/**
	 * Takes an array of tuples and sorts them by their first value via MergeSort
	 * @param array The array of tuples to sort.
	 * @param low The left index of the subarray.
	 * @param high The right index of the subarray.
	 * @return the sorted array of tuples.
	 */
	private static Tuple[] sort(Tuple[] array, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort(array, low, mid);
			sort(array, mid + 1, high);
			merge(array, low, mid, high);
		}
		
		return array;
	}
	
	/**
	 * Main merge function of MergeSort, sorts by the numeric value of the tuple.
	 * @param array The array of tuples.
	 * @param low The left index of the subarray.
	 * @param mid The median index of the subarray.
	 * @param high The right index of the subarray.
	 * @return
	 */
	private static Tuple[] merge(Tuple[] array, int low, int mid, int high) {
        int lSize = mid - low + 1;
        int rSize = high - mid;
        
		//temporarily store array elements in seperate arrays.
        Tuple[] leftArray = new Tuple[lSize];
        Tuple[] rightArray = new Tuple[rSize];
		
        for (int i=0; i<lSize; i++) {
        	leftArray[i] = array[low + i];
        }
		
        for (int j=0; j<rSize; j++) {
            rightArray[j] = array[mid + 1+ j];
        }
		
		int i = 0;
		int j = 0;
		int k = low;
		
		while (i < lSize && j < rSize) {

			if (leftArray[i].getValue() <= rightArray[j].getValue()) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while (i < lSize) {
			array[k] = leftArray[i];
			i++;
			k++;
		}
		
		while (j < rSize) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
		

		return array;
		
	}

	/**
	 * A tuple class which holds both a numeric value and an index.
	 * @author Molly Brougham
	 * @version 2/24/2017
	 *
	 */
	private static class Tuple {
		private int value;
		private int index;
		
		/**
		 * Gets the value of the tuple element.
		 * @return the value.
		 */
		private int getValue() {
			return value;
		}

		/**
		 * Sets the value of the tuple.
		 * @param v The value to set.
		 */
		private void setValue(int v) {
			value = v;
		}
		/**
		 * Sets the index of the tuple.
		 * @param i The index to set.
		 */
		private void setIndex(int i) {
			index = i;
		}
	}	
	
}


