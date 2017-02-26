package mylistpackage;

import java.util.Arrays;

/**
 * @author Molly Brougham
 * @version 1.0
 * @param <E> is of any object type
 */
public abstract class AbstractArrayMyList<E> implements MyList<E> {

    /**
     * default list capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    

    /**
     * default increase size.
     */
    private static final int INCREASE_SIZE = 100;

    /**
     * array of list values.
     */
    private E[] myElements;

    /**
     * current number of elements in the list.
     */
    private int mySize;

    /**
     * Constructs an empty list of default capacity.
     * @custom.post list of size 10 created
     */
    public AbstractArrayMyList() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * Constructs an empty list of the given capacity.
     * 
     * @param theCapacity > 0
     * @throws IllegalArgumentException if capacity <= 0
     * @custom.post list of specified size constructed
     */
    @SuppressWarnings("unchecked")
    public AbstractArrayMyList(final int theCapacity) {
        if (theCapacity <= 0) {
            throw new IllegalArgumentException("capacity: " + theCapacity);
        }
        myElements = (E[]) new Object[theCapacity];
        mySize = 0;
    }
    
    /**
     * @see mylistpackage.MyList#add(java.lang.Object)
     */
    @Override
    public void add(final MyList<E> theOtherList) {
        final int size = theOtherList.getSize();
        for (int i = 0; i < size; i++) {
            insert(theOtherList.getElementAt(i));
        }        
    }
    
    /**
     * @see mylistpackage.MyList#clear()
     */
    @Override
    public void clear() {
        final E object = null;
        for (int i = 0; i < mySize; i++) {
            myElements[i] = object;
        }
        mySize = 0;
    }
    
    /**
     * @see mylistpackage.MyList#contains(java.lang.Object)
     */
    @Override
    public boolean contains(final E theValue) {
        final int index = getIndex(theValue);
        boolean flag = false;
        if (index >= 0) {
            flag = true;
        }
        return flag;
    }
    
    /**
     * Returns the value at the given index in the list.
     * 
     * @param theIndex < size and index >= 0
     * @throws IndexOutOfBoundsException if index < 0 or index >= size
     * @return the value at the given index in the list.
     */
    public E getElementAt(final int theIndex) {
        if (theIndex < 0 || theIndex >= mySize) {
            throw new IndexOutOfBoundsException();
        }
        return myElements[theIndex];
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
     * @see mylistpackage.MyList#getSize()
     */
    @Override
    public int getSize() {
        return mySize;
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
     * @see mylistpackage.MyList#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return mySize == 0;
    }  
    
    /**
     * @see mylistpackage.MyList#remove(java.lang.Object)
     */
    @Override
    public void remove(final E theValue) {
        final E object = null;
        final int index = getIndex(theValue);
        if (index >= 0) {
            myElements[index] = myElements[mySize - 1];
            myElements[mySize - 1] = object;
            mySize--;
        }
        if (myElements.length > DEFAULT_CAPACITY 
            && ((double) mySize / myElements.length) < 0.3) {
            resize(false);
        }
    }

    /**
     * Creates a comma-separated, bracketed version of the list.
     * 
     * @see java.lang.Object#toString()
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

    /**
     * 
     */
    

}
