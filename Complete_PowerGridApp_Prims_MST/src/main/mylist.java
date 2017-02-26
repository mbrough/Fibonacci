package main;
/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */



import java.util.Arrays;

/**
 * A general list of elements.
 * @author Molly Brougham
 * @version 1.0
 */
public class mylist {

    /** represents the default size of the list. */
    protected static final int DEFAULT_SIZE = 10;

    /** default increase size. */
    protected static final int INCREASE_SIZE = 100;
    
    /** represents a line break. */
    private static final String LINE_BREAK = "\n";
    
    /** The number of entries in the list. */
    protected int myLength;
    
    /** an array that holds the elements of the list. */
    protected Object[] myElements;

    /** creates an empty list of elements with a default size of 10. */
    public mylist() {
        this(DEFAULT_SIZE);
    }
    

    /**
     * creates an empty list of elements with a given size.
     * @param theSize the size the list should be
     */
    public mylist(final int theSize) {
        myLength = 0;
        myElements = new Object[theSize];
    }
    /**
     *  Adds an Element to the list. 
     * @param theNewElement the element to be added.
     */
    public void add(final Object theNewElement) {
        if (myLength >= myElements.length) {
            resize();
        }
        myElements[myLength] = theNewElement;
        myLength++;
    }
    
    /**
     * removes a specified element from the list.
     * @param theOldElement the element to be removed
     */
    public void remove(final Object theOldElement) {
        for (int i = 0; i < myLength; i++) {
            if (myElements[i] == theOldElement) {
                for (int j = i; myElements[j + 1] != null; j++) {
                    myElements[j] = myElements[j + 1];
                }
                myLength--;
            }
        }
    }

    /**
     * Resizes the list to make room for more elements.
     */
    private void resize() {
        final int newCapacity;
        newCapacity = myElements.length + INCREASE_SIZE;
        myElements = Arrays.copyOf(myElements, newCapacity);
        
    }

    /**
     * Returns the length of the list.
     * @return the length of the list.
     */
    public int getLength() {
        return myLength;
    }
    
    /**
     * returns a string representation of all the elements in the list.
     * @return A string representation of all the elements in the list
     */
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < myLength; i++) {
            sb.append(myElements[i].toString() + LINE_BREAK);
        }
        if (sb.toString().contains(LINE_BREAK)) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
    
    /**
     * returns the element in the list at the specified index.
     * @param theIndex the index of the element to return
     * @return the element at the specified index
     */
    public Object getElementAt(final int theIndex) {
        return myElements[theIndex];
        
    }
    
    /**
     * Clears the list.
     */
    public void clear() {
        for (int i = 0; i < myLength; i++) {
            myElements[i] = null;
        }
        myLength = 0;
    }
}
