package mylistpackage;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
    
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
    }

    @Before
    public void setUp() throws Exception {

        myList1 = new ArrayListSorted<Integer>();
        myList2 = new ArrayListSorted<Integer>();
        myList3 = new ArrayListSorted<Integer>();
        
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
    public void testArrayListSorted() {
        assertEquals(0, myList1.getSize());
        assertEquals("[]", myList1.toString());
    }
    
    @Test
    public void testArrayListSortedInt() {
        myList1 = new ArrayListSorted<Integer>(50);
        assertEquals(0, myList1.getSize());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void testArrayListSortedIntZero() {
        myList1 = new ArrayListSorted<Integer>(0);
    }
    
    @Test
    public void testAdd1() {
        myList2.add(myList1);
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList2.toString());
    }
    
    @Test
    public void testAdd2() {
        myList1.add(myList2);
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList1.toString());
    }
   
    @Test
    public void testAdd3() {
        myList1.add(myList2);
        System.out.println(myList1.toString());
        assertEquals("[ 1, 2, 3, 4, 5, 6 ]", myList1.toString());

    }
    
    @Test
    public void testInsert1() {
        System.out.println(myList2.getSize());
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

    

    @Test
    public void test() {
        //TODO fail("Not yet implemented");
    }

}
