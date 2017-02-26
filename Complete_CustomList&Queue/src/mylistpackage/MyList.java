package mylistpackage;

/**
 * Represents MyList interface.
 * 
 * @author Monika
 * @version Apr. 12, 2015
 * @param <Type> is of any object type.
 */
public interface MyList<Type> {
    
    /**
     * Appends two lists together.
     * @param theOtherList is not null
     * @custom.post self = self + theOtherList
     */
    void add(MyList<Type> theOtherList);
    
    /**
     * Clears the list.
     * @custom.post the list is empty
     */
    void clear();
    
    /**
     * Returns whether value is in the list.
     * 
     * @param theValue assigned
     * @return true if value in the list, false otherwise.
     */
    boolean contains(Type theValue);
    
    /**
     * Returns a value in a list at the specified index.
     * @param theIdx is the valid list index
     * @return the element at specified index
     */
    Type getElementAt(int theIdx);
    
    /**
     * Returns the index of the first occurrence of the specified element.
     * @param theValue is not null
     * @return index of the specified element, or -1 if this list does
     *          not contain the element
     */
    int getIndex(Type theValue);

    /**
     * Returns the current number of elements in the list.
     * 
     * @return the current number of elements in the list >= 0
     */
    int getSize();    
    
    /**
     * Inserts an element into a list.
     * 
     * @param theValue assigned, not null
     * @custom.post theValue added to the list.
     */
    void insert(Type theValue);

    /**
     * Returns whether the list is empty.
     * 
     * @return true if list is empty, false otherwise.
     */
    boolean isEmpty();
//
//    /**
//     * Removes an element from the list.
//     * 
//     * @param theValue assigned, not null
//     * @custom.post theValue removed from the list
//     */
//    void remove(Type theValue);
//    
     /**
     * Returns a string representation of list contents.
     * 
     * @return a string representation of list contents.
     * @see Object#toString()
     */
    @Override
    String toString();
    
}
