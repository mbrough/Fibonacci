/**
 * 
 */
package mylistpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Monika
 * @version Apr. 14, 2015
 */
public class ArrayUnsortedTest {
    /**
     * list 1.
     */
    private ArrayListUnsorted<Integer> myList1;
    
    /**
     * list 2.
     */
    private ArrayListUnsorted<Integer> myList2;
    
    /**
     * list 3.
     */
    private ArrayListUnsorted<Integer> myList3;

    /**
     * @throws java.lang.Exception if object not constructed
     */
    @Before
    public void setUp() throws Exception {
        myList1 = new ArrayListUnsorted<Integer>();
        myList2 = new ArrayListUnsorted<Integer>();
        myList3 = new ArrayListUnsorted<Integer>();   
        
        for (int i = 1; i <= 6; i++) {
            myList2.insert(i);
        }
        
        for (int i = 1; i <= 25000; i++) {
            myList3.insert(i);
        }
    }

    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#ArrayListUnsorted()}.
     */
    @Test
    public void testArrayListUnsorted() {
        assertEquals(0, myList1.getSize());
        assertEquals("[]", myList1.toString());
    }

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#ArrayListUnsorted(int)}.
     */
    @Test
    public void testArrayListUnsortedInt() {
        myList1 = new ArrayListUnsorted<Integer>(50);
        assertEquals(0, myList1.getSize());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#ArrayListUnsorted(int)}.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testArrayListUnsortedIntZero() {
        myList1 = new ArrayListUnsorted<Integer>(0);
    }

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#add(mylistpackage.MyList)}.
     */
    @Test
    public void testAdd1() {
        myList2.add(myList1);
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#add(mylistpackage.MyList)}.
     */
    @Test
    public void testAdd2() {
        myList1.add(myList2);
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList1.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#add(mylistpackage.MyList)}.
     */
    @Test
    public void testAdd3() {
        myList1.add(myList2);
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList1.toString());
    }

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#clear()}.
     */
    @Test
    public void testClearEmpty() {
        myList1.clear();
        assertEquals("[]", myList1.toString());
    }


    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#clear()}.
     */
    @Test
    public void testClearFull() {
        myList3.clear();
        assertEquals("[]", myList3.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#contains(java.lang.Object)}.
     */
    @Test
    public void testContains1() {
        assertFalse(myList1.contains(1));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#contains(java.lang.Object)}.
     */
    @Test
    public void testContains2() {
        assertTrue(myList2.contains(1));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#contains(java.lang.Object)}.
     */
    @Test
    public void testContains3() {
        assertFalse(myList2.contains(7));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#contains(java.lang.Object)}.
     */
    @Test
    public void testContains4() {
        myList1.insert(1);
        assertTrue(myList1.contains(1));
    }

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#contains(java.lang.Object)}.
     */
    @Test
    public void testContains5() {
        assertTrue(myList3.contains(250));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#contains(java.lang.Object)}.
     */
    @Test
    public void testContains6() {
        assertTrue(myList3.contains(1));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getElementAt(int)}.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testElementAtEmpty() {
        myList1.getElementAt(0);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getElementAt(int)}.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testElementAtNegative() {
        myList1.getElementAt(-1);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getElementAt(int)}.
     */
    @Test (expected = IndexOutOfBoundsException.class)
    public void testElementAtTooHigh() {
        myList2.getElementAt(6);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getElementAt(int)}.
     */
    @Test
    public void testElementAtValid() {
        assertTrue(myList3.getElementAt(400).equals(401));
    }

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getIndex(java.lang.Object)}.
     */
    @Test
    public void testGetElementEmpty() {
        assertEquals(-1, myList1.getIndex(4));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getIndex(java.lang.Object)}.
     */
    @Test
    public void testGetElementTrue1() {
        assertEquals(0, myList3.getIndex(1));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getIndex(java.lang.Object)}.
     */
    @Test
    public void testGetElementTrue2() {
        assertEquals(24999, myList3.getIndex(25000));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#getIndex(java.lang.Object)}.
     */
    @Test
    public void testGetElementFalse1() {
        assertEquals(-1, myList2.getIndex(200));
    }
    

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#insert(java.lang.Object)}.
     */
    @Test
    public void testInsert1() {
        assertEquals(6, myList2.getSize());
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
        System.out.println(myList2);
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#insert(java.lang.Object)}.
     */
    @Test
    public void testInsert2() {     
        String s = "[ ";
        for (int i = 1; i <= 25000; i++) {
            s += i + ", ";
        }
        s = s.substring(0, s.length() - 2);
        s += " ]";
        assertEquals(25000, myList3.getSize());
        assertEquals(s, myList3.toString());
    }

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#isEmpty()}.
     */
    @Test
    public void testIsEmpty1() {
        assertTrue(myList1.isEmpty());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#isEmpty()}.
     */
    @Test
    public void testIsEmpty2() {
        assertFalse(myList2.isEmpty());
        assertFalse(myList3.isEmpty());
    }

    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveEmpty() {
        myList1.remove(0);
        assertTrue(myList1.isEmpty());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveInvalid() {
        myList2.remove(10);
        assertFalse(myList2.contains(10));
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveValidEnd() {
        myList2.remove(6);
        assertFalse(myList2.contains(6));
        assertEquals("[ 1, 2, 3, 4, 5 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveValidFront() {
        myList2.remove(1);
        assertFalse(myList2.contains(1));
        assertEquals("[ 6, 2, 3, 4, 5 ]", myList2.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveValid1El() {
        myList1.insert(6);
        myList1.remove(6);
        assertFalse(myList1.contains(6));
        assertEquals("[]", myList1.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveSingleResize() {
        for (int i = 1; i <= 24999; i++) {
            myList3.remove(i);
        }
       
        assertEquals("[ 25000 ]", myList3.toString());
    }
    
    /**
     * Test method for {@link mylistpackage.ArrayListUnsorted#remove(java.lang.Object)}.
     */
    @Test
    public void testRemoveMultipleResize() {
        for (int i = 1; i <= 24999; i++) {
            myList3.remove(i);
        }
        for (int i = 1; i <= 200; i++) {
            myList3.insert(i);
        }
        for (int i = 1; i <= 199; i++) {
            myList3.remove(i);
        }
        
        assertEquals("[ 25000, 200 ]", myList3.toString());
    }

    
    
   
}
