package mylistpackage;

/**
 * A double-ended queue of objects.
 * 
 * @author Molly Brougham
 * @version May 5, 2015
 * @param <E> is of any object type.
 * @custom.inv 0 <= mySize <= array length
 */
public class Deq<E> extends AbstractArrayMyList<E> {
    
    /**
     * Constructs an empty list of default capacity.
     * @custom.post list of size 10 created
     */
    public Deq() {
      super();
    }
    
    /**
     * Constructs an empty list of the given capacity.
     * @param theCapacity > 0
     * @custom.post list of specified size constructed
     */
    public Deq(final int theCapacity) {
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
     * Adds an element to the back of the list.
     * @param theValue the element to be added to the back of the list.
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
     * Adds an element to the front of the list.
     * @param theValue the element to be added to the front of the list.
     */
    public void insertFront(final E theValue) {
        if (mySize >= myElements.length - 1) {
            resize(true);
        }
        
        if (mySize == 0) {
            myElements[mySize] = theValue;
            mySize++;
        } else {
            //list is not empty, element should go in the front
            final E temp = myElements[mySize];
            for (int i = mySize; i > 0; i--) {
                //starting at end of the list, moving towards myElements[i]
                myElements[i] = myElements[i - 1];
            }
            mySize++;
            myElements[mySize] = temp;
            myElements[0] = theValue;
        }
    }
    
    /**
     * Removes the first element from the list.
     */
    public void removeFront() {
        //TODO
        for (int i = 0; i < mySize; i++) {
            myElements[i] = myElements[i + 1];
        }
        mySize--;
    }
    
    /**
     * Removes the last element from the list.
     */
    public void removeBack() {
        mySize--;
    }

}
