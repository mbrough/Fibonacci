
package mylistpackage;

/**
 * A sorted list of objects. 
 * 
 * @author Molly Brougham
 * @version May 5, 2015
 * @param <E> is of any object type.
 * @custom.inv 0 <= mySize <= array length
 */
public class ArrayListSorted<E extends Comparable<? super E>> extends AbstractArrayMyList<E> {

    /**
     * Constructs an empty list of default capacity.
     * @custom.post list of size 10 created
     */
    public ArrayListSorted() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructs an empty list of the given capacity.
     * @param theCapacity > 0
     * @custom.post list of specified size constructed
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
     * @see mylistpackage.MyList#getIndex()
     */
    @Override
    public int getIndex(final E theValue) {
        int index = -1;
        for (int i = 0; i < mySize; i++) {
            if (myElements[i].equals(theValue)) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Adds a specified value to the list in a sorted position.
     * @param theValue theValue to be added to the list.
     */
    @Override
    public void insert(final E theValue) {
     
        if (mySize == 0) {
            //if list is empty, add element to first position in list
            myElements[mySize] = theValue;
            //increase list size
            mySize++;
        } else {
            //list is not empty
            //find where element should go
            for (int i = 0; i <= mySize; i++) {
                if (myElements[i].compareTo(theValue) > 0) {
                    // the element in this position is greater than theValue
                    // all elements including element current position should be moved forward
                    // current position in list should be occupied by theValue.
                    for (int j = mySize; j > i; j--) {
                        //starting at end of the list, moving towards myElements[i]
                        myElements[j] = myElements[j - 1];
                    }
                    //add element at myElements[i]
                    myElements[i] = theValue;
                    break;
                } else {
                    // no elements in the list are greater than theValue
                    // theValue should be placed at the end of the list
                    myElements[mySize] = theValue;
                }
            }
            mySize++;
            
            
        }
        
        if (mySize >= myElements.length) {
            resize(true);
        }
   

    }

    /**
     * Removes an element from the list.
     * @param theValue assigned, not null
     * @custom.post theValue removed from the list
     */
    public void remove(final E theValue) {        
        final double oneThird = 0.3;
        final int indexOfValue = getIndex(theValue);
        if (indexOfValue >= 0) {
            for (int i = indexOfValue; i < mySize; i++) {
                myElements[i] = myElements[i + 1];
            }
            mySize--;
        }
        if (myElements.length > DEFAULT_CAPACITY 
                        && ((double) mySize / myElements.length) < oneThird) {
            resize(false);
        }
    }
}