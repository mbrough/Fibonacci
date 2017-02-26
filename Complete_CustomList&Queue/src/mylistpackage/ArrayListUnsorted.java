package mylistpackage;

/**
 * Dynamic representation of a basic unsorted array-based list.
 * 
 * @author modified from Building Java Programs 3rd ed.
 * @version Apr. 12, 2015
 * @param <E> is of any object type
 * @custom.inv 0 <= mySize <= array length
 */
public class ArrayListUnsorted<E> extends AbstractArrayMyList<E> {

    /**
     * Constructs an empty list of default capacity.
     * @custom.post list of size 10 created
     */
    public ArrayListUnsorted() {
      super();
    }

    /**
     * Constructs an empty list of the given capacity.
     * @param theCapacity > 0
     * @custom.post list of specified size constructed
     */
    public ArrayListUnsorted(final int theCapacity) {
        super(theCapacity);
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
     * @see mylistpackage.MyList#insert(java.lang.Object)
     */
    @Override
    public void insert(final E theValue) {
        if (mySize >= myElements.length) {
            resize(true);
        }
        myElements[mySize] = theValue;
        mySize++;
    }
    
    /**
     * Removes an element from the list.
     * @param theValue assigned, not null
     * @custom.post theValue removed from the list
     */
    public void remove(final E theValue) {
        final double oneThird = 0.3;
        final E object = null;
        final int index = getIndex(theValue);
        if (index >= 0) {
            myElements[index] = myElements[mySize - 1];
            myElements[mySize - 1] = object;
            mySize--;
        }
        if (myElements.length > DEFAULT_CAPACITY 
            && ((double) mySize / myElements.length) < oneThird) {
            resize(false);
        }
    }
  

}
