package qs;

import java.util.ArrayList;

/**
 * Contains methods to calculate and display the Fibonacci sequence.
 * @author Molly Brougham
 */
public class Fibonacci {

	/**
	 * Calculates the Fibonacci sequence up to the position passed as a parameter.
	 * @param index The index for which to calculate the sequence up to.
	 * @return A string representation of the Fibonacci sequence up to the given index.
	 */
	protected static String fibonacci(int index) {
		String str = "";
		
		if (index < 0) { 
			throw new IllegalArgumentException("Index cannot be less than 0");
		} else if (index == 0) {
			return "{ 0 }";
		} else if (index == 1) {
			return "{ 0, 1 }";
		} else {
			int[] fib = new int[index + 1];
			fib[0] = 0;
			fib[1] = 1;
			str += "{ 0, 1, ";
			for (int i = 2; i <= index; i++) {
				fib[i] = fib[i-1] + fib[i-2];
				if (i == index) {
					str += fib[i] + " }";
				} else {
					str += fib[i] + ", ";
				}
			}
		}
		return str;
	}
	
	/** 
	 * Determines whether the search parameter exists within the Fibonacci sequence, and if not, the closest value to 
	 * the search parameter within the sequence.
	 * @param searchParameter The value to search for.
	 * @return A string describing the results of the search.
	 */
	protected static String fibonacci2(int searchParameter) {
		if (searchParameter < 0) {
			throw new IllegalArgumentException("A negative value cannot exist within the Fibonacci sequence.");
		} else if (searchParameter == 0) {
			return searchParameter + " is a value in the Fibonacci sequence, it's position is 0. Sequence: { 0 }";
		} else if (searchParameter == 1) {
			return searchParameter + " is a value in the Fibonacci sequence, it exists twice within the sequence, at positions 1 and 2. Sequence: { 0, 1, 1 }";
		} else if (searchParameter == 2) {
			return searchParameter + " is a value in the Fibonacci sequence, it's position is 3. Sequence: { 0, 1, 1, 2 }";
		}
		ArrayList<Integer> fib = new ArrayList<Integer>();
		String str = "";
		String seq = "";
		fib.add(0, 0);
		fib.add(1, 1);
		int m = searchParameter;
		seq += "{ 0, 1, 1, 2, ";
		for (int i = 2; i < m; i++) {
			fib.add(i, fib.get(i-1) + fib.get(i-2));
			seq += fib.get(i) + ", ";
			if (fib.get(i) == searchParameter) {
				seq += "}";
				str+= searchParameter + " is a value in the Fibonacci sequence, it's position is " + i + ". Sequence: " + seq;
				
			}
			if (fib.get(i) > m) {
				str += searchParameter + " is not a value in the Fibonacci sequence, it's closest value is ";
				fib.add(i+1, fib.get(i) + fib.get(i-1));
				int differenceLess = searchParameter - fib.get(i-1);
				int differenceMore = fib.get(i) - searchParameter;
				if (differenceLess < differenceMore) {
					int k = i - 1;
					str += fib.get(k) + " at position " + k + ". ";
					seq += fib.get(k) + " }";
				} else {
					str += fib.get(i) + " at position " + i;
					seq += "}";
				}
				str += "Sequence: " + seq;
				return str;
			}
			if (i >= m && searchParameter > fib.get(i)) {
				m = 2*m;				
			}
		}
		return str;
	}
}