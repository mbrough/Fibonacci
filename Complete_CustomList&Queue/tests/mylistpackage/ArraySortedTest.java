package mylistpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests sorted array list functionality.
 * @author Molly Brougham
 * @version May 5, 2015
 *
 */
public class ArraySortedTest {

    /**
     * list 1.
     */
    private ArrayListSorted<Integer> myList1;
    
    /**
     * list 2.
     */
    private ArrayListSorted<Integer> myList2;
    
    /**
     * list 3.
     */
    private ArrayListSorted<Integer> myList3;


    /**
     * pre-test list set up.
     * @throws Exception Exception if set up incorrectly
     */
    @Before
    public void setUp() throws Exception {

        myList1 = new ArrayListSorted<Integer>();
        myList2 = new ArrayListSorted<Integer>();
        myList3 = new ArrayListSorted<Integer>();
        
        for (int i = 1; i <= 6; i++) {
            myList2.insert(i);
        }
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#ArrayListSorted()}.
     */
    @Test
    public void testArrayListSorted() {
        assertEquals(0, myList1.getSize());
        assertEquals("[]", myList1.toString());
        assertEquals(6, myList2.getSize());
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#ArrayListSorted(int)}.
     */
    @Test
    public void testArrayListSortedInt() {
        myList1 = new ArrayListSorted<Integer>(50);
        assertEquals(0, myList1.getSize());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#ArrayListSorted(int)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testArrayListSortedIntZero() {
        myList1 = new ArrayListSorted<Integer>(0);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#ArrayListSorted(int)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testArrayListSortedIntNegative() {
        myList1 = new ArrayListSorted<Integer>(-1);
    }
    
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(Comparable)}.
     */
    @Test
    public void testInsert1() {
        assertEquals(6, myList2.getSize());
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(Comparable)}.
     */
    @Test
    public void testInsert2() {
        
        myList3.insert(5);
        myList3.insert(2);
        myList3.insert(1);
        myList3.insert(10);
        myList3.insert(7);
        assertEquals("[ 1, 2, 5, 7, 10 ]", myList3.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(Comparable)}.
     */
    @Test
    public void testInsert3() {
        myList2.insert(10);
        assertEquals("[ 1, 2, 3, 4, 5, 6, 10 ]", myList2.toString());
        myList2.insert(10);
        assertEquals("[ 1, 2, 3, 4, 5, 6, 10, 10 ]", myList2.toString());
        myList2.insert(3);
        assertEquals("[ 1, 2, 3, 3, 4, 5, 6, 10, 10 ]", myList2.toString());
        myList2.insert(3);
        assertEquals("[ 1, 2, 3, 3, 3, 4, 5, 6, 10, 10 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#remove(Comparable)}.
     */
    @Test
    public void testRemove() {
        myList2.remove(1);
        assertEquals("[ 2, 3, 4, 5, 6 ]", myList2.toString());
        myList2.remove(4);
        assertEquals("[ 2, 3, 5, 6 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListSorted#insert(Comparable)}
     * and {@link mylistpackage.ArrayListSorted#remove(Comparable)}.
     */
    @Test
    public void testAddAndRemove() { 
        myList2.remove(2);
        assertEquals("[ 1, 3, 4, 5, 6 ]", myList2.toString());
        myList2.remove(3);
        myList2.remove(4);
        myList2.remove(5);
        assertEquals("[ 1, 6 ]", myList2.toString());
        myList2.insert(2);
        assertEquals("[ 1, 2, 6 ]", myList2.toString());
        myList2.insert(7);
        assertEquals("[ 1, 2, 6, 7 ]", myList2.toString());
        myList2.insert(-1);
        assertEquals("[ -1, 1, 2, 6, 7 ]", myList2.toString());
        
    }
    
    /**
     * Test class for {@link mylistpackage.ArrayListSorted#getIndex(Comparable)}.
     */
    @Test
    public void testGetIndex() {
        assertEquals(0, myList2.getIndex(1));
        assertEquals(1, myList2.getIndex(2));
        assertEquals(2, myList2.getIndex(3));
        assertEquals(3, myList2.getIndex(4));
        assertEquals(4, myList2.getIndex(5));
        myList2.insert(21);
        assertEquals(6, myList2.getIndex(21));
    }

}
