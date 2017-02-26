package mylistpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Deq test.
 * @author Molly Brougham
 * @version May 5, 2015
 *
 */
public class DeqTest {

    /**
     * list 1.
     */
    private Deq<Integer> myList1;
    
    /**
     * list 2.
     */
    private Deq<Integer> myList2;

    /**
     * pre-test list set up.
     * @throws Exception exception if lists are set up incorrectly.
     */
    @Before
    public void setUp() throws Exception {
        myList1 = new Deq<Integer>();
        myList2 = new Deq<Integer>();
        
        for (int i = 1; i <= 6; i++) {
            myList2.insert(i);
        }
        
    }

    /**
     * Test method for {@link mylistpackage.Deq#Deq()}.
     */
    @Test
    public void testDeq() {
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
        assertEquals(6, myList2.getSize());
        assertEquals(0, myList1.getSize());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#Deq(int)}.
     */
    @Test
    public void testDeqInt() {
        myList1 = new Deq<Integer>(50);
        assertEquals(0, myList1.getSize());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#Deq(int)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testDeqIntZero() {
        myList1 = new Deq<Integer>(0);
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#Deq(int)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testDeqIntNegative() {
        myList1 = new Deq<Integer>(-1);
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#insert(Object)}.
     */
    @Test
    public void testInsert1() {
        myList2.insert(1);
        assertEquals("[ 1, 2, 3, 4, 5, 6, 1 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#insert(Object)}.
     */
    @Test
    public void testInsert2() {
        for (int i = -5; i < 0; i++) {
            myList2.insert(i);
        }
        assertEquals("[ 1, 2, 3, 4, 5, 6, -5, -4, -3, -2, -1 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#insertFront(Object)}.
     */
    @Test
    public void testInsertFront1() {
        myList2.insertFront(5);
        assertEquals("[ 5, 1, 2, 3, 4, 5, 6 ]", myList2.toString());
        myList2.insertFront(-1);
        assertEquals("[ -1, 5, 1, 2, 3, 4, 5, 6 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#insertFront(Object)}.
     */
    @Test
    public void testInsertFront2() {
        myList2.insertFront(-5);
        assertEquals("[ -5, 1, 2, 3, 4, 5, 6 ]", myList2.toString());
        myList2.insertFront(-4);
        assertEquals("[ -4, -5, 1, 2, 3, 4, 5, 6 ]", myList2.toString());

        for (int i = -5; i < 0; i++) {
            myList2.insertFront(i);
        }
        assertEquals("[ -1, -2, -3, -4, -5, -4, -5, 1, 2, 3, 4, 5, 6 ]", myList2.toString());
    }

    /**
     * Test method for {@link mylistpackage.Deq#removeBack()}.
     */
    @Test
    public void testRemoveBack1() {
        myList2.removeBack();
        assertEquals("[ 1, 2, 3, 4, 5 ]", myList2.toString());
        myList2.removeBack();
        assertEquals("[ 1, 2, 3, 4 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#removeBack()}.
     */
    @Test
    public void testRemoveBack2() {
        myList2.insert(7);
        assertEquals("[ 1, 2, 3, 4, 5, 6, 7 ]", myList2.toString());
        myList2.removeBack();
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
        myList2.insertFront(1);
        assertEquals("[ 1, 1, 2, 3, 4, 5, 6 ]", myList2.toString());
        myList2.removeBack();
        assertEquals("[ 1, 1, 2, 3, 4, 5 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#removeFront()}.
     */
    @Test
    public void testRemoveFront1() {
        myList2.removeFront();
        assertEquals("[ 2, 3, 4, 5, 6 ]", myList2.toString());
        myList2.removeFront();
        assertEquals("[ 3, 4, 5, 6 ]", myList2.toString());
        myList2.removeFront();
        assertEquals("[ 4, 5, 6 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.Deq#removeFront()}.
     */
    @Test
    public void testRemoveFront2() {
        myList2.insert(7);
        assertEquals("[ 1, 2, 3, 4, 5, 6, 7 ]", myList2.toString());
        myList2.removeFront();
        assertEquals("[ 2, 3, 4, 5, 6, 7 ]", myList2.toString());
        myList2.insertFront(1);
        assertEquals("[ 1, 2, 3, 4, 5, 6, 7 ]", myList2.toString());
        myList2.removeFront();
        assertEquals("[ 2, 3, 4, 5, 6, 7 ]", myList2.toString());
    }
}
