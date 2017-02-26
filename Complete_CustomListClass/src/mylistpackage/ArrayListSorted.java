
package mylistpackage;

import java.util.Arrays;

/**
 * @author Molly Brougham
 * @version 1.0
 * @param <E> is of any object type.
 */
public class ArrayListSorted<E extends Comparable<? super E>> extends AbstractArrayMyList<E> {

    /**
     * the default size of the list.
     */
    private static final int DEFAULT_SIZE = 10;
    
    /**
     * default increase size.
     */
    private static final int INCREASE_SIZE = 100;

    /**
     * The size of the list.
     */
    private int mySize;

    /**
     * the list of elements.
     */
    private E[] myElements;

    /**
     * Constructs an empty list of a certain size.
     * @param theCapacity the size of the list
     */
    @SuppressWarnings("unchecked")
    public ArrayListSorted(final int theCapacity) {
        if (theCapacity <= 0) {
            throw new IllegalArgumentException("capacity: " + theCapacity);
        }
        myElements = (E[]) new Comparable[theCapacity];
        mySize = 0;
    }

    /**
     * Constructs an empty list of default size.
     */
    public ArrayListSorted() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adds another list to the existing list of elements.
     * @param theOtherList the list to be added.
     */
    @Override
    public void add(final MyList<E> theOtherList) {
        final int size = theOtherList.getSize();
        for (int i = 0; i <= size; i++) {
            insert(theOtherList.getElementAt(i));
        }
    }

    /**
     * Adds a specified value to the list.
     */
    @Override
    public void insert(final E theValue) {
        if (mySize >= myElements.length) {
            resize(true);
        }
        myElements[mySize] = theValue;
        mySize++;
        sort();
    }

    /**
     * Sorts the elements in the list.
     */
    private void sort() {
//        System.out.println("Unsorted Array = " + this);
        
        if (mySize > 1) {
            
            for (int i = 0; i < mySize; i++) {
                
                final E temp = myElements[i];
                int j;
                //move until temp is less than myElements[j]
                //move until temp.compareTo(myElements[j]) is less than 0
                for (j = i - 1; j >= 0 && myElements[i].compareTo(myElements[j]) <= 0; j--) {
                    myElements[j + 1] = myElements[j];
                }
                myElements[j + 1] = temp;
            }

        }
//        System.out.println("Sorted Array = " + this);

    }

    /**
     * Creates a comma-separated, bracketed version of the list.
     */
    @Override
    public String toString() {
        final StringBuffer result = new StringBuffer();
        if (mySize == 0) {
            result.append("[]");
        } else {
            result.append("[ " + myElements[0]);
            for (int i = 1; i < mySize; i++) {
                result.append(", ");
                result.append(myElements[i]);
            }
            result.append(" ]");
        }
        return result.toString();
    }
    
    /**
     * @see mylistpackage.MyList#getSize()
     */
    @Override
    public int getSize() {
        return mySize;
    }
    
    
    /**
     * Resizes the array holding list elements.
     * 
     * @param theGrowth is not null
     * @custom.post underlying array increases by 100 elements,
     *  if the argument is true; otherwise it shrinks to half its size
     */
    private void resize(final boolean theGrowth) {
        final int newCapacity;
        if (theGrowth) {
            newCapacity = myElements.length + INCREASE_SIZE;
        } else {
            newCapacity = myElements.length / 2;
        }
        myElements = Arrays.copyOf(myElements, newCapacity);
        
    }

}