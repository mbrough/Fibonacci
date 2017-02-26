/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package mytestpackage;

import static org.junit.Assert.*;

import java.util.Random;

import model.MyList;
import model.MyPeopleList;
import model.Person;

import org.junit.Before;
import org.junit.Test;
/**
 * Tests functionality of the MyPeopleList class.
 * @author Molly Brougham
 * @version 1.0
 *
 */
public class MyPeopleListTest {
    /** represents a person named william zoolander. */
    private static final Person WILLIAM_ZOOLANDER =
                    new Person("William", "Zoolander", 999, 9999859,
                               "wzoolander@aol.com", "1125 S 18th St");
    
    /** represents a person named john smith. */
    private static final Person JOHN_SMITH =
                    new Person("John", "Smith", 100, 1000000, "jasmith@gmail.com",
                               "123 S 5th St");

    /** represents a person named john jacobs. */
    private static final Person JOHN_JACOBS =
                    new Person("Z", "Jacobs", 999, 9999999, "jjacobs@gmail.com",
                               "1125 S 18th St");
    
    /** represents a person named garrett aaronson. */
    private static final Person GARRETT_AARONSON =
                    new Person("Garrett", "Aaronson", 253, 6703858, "aaaronson@yahoo.com",
                               "1125 S 18th St");
    
    /** represents a person named aaron ericson. */
    private static final Person AARON_AARONSON =
                    new Person("Aaron", "Aaronson", 253, 6703859, "Zumiez@yahoo.com",
                                    "1125 S 18th St");
    
    /** represents a person named joseph smith. */
    private static final Person JOSEPH_SMITH =
                    new Person("Joseph", "Smith", 800, 2662994, "jesmith@ymail.com",
                               "236 Olympic View Ave");


    /** a random number generator. */
    private final Random myR = new Random();
    
    /**
     * Represents a MyPeopleList.
     */
    private MyPeopleList myList1;
    
    /**
     * Represents a MyPeopleList.
     */
    private MyList myList2;

    
    /**
     * Pre-test set up.
     * @throws Exception throws an exception on failure of set up.
     */
    @Before
    public void setUp() throws Exception {
        myList1 = new MyPeopleList();
        myList2 = new MyPeopleList(2);
    }

    /**
     * tests the toString method inside the person class.
     */
    @Test
    public void testPersonToString() {
        final String string = "Zoolander, William: E-Mail: wzoolander@aol.com, "
                        + "Phone: 999-999-9859, Address: 1125 S 18th St";
        assertEquals(string, WILLIAM_ZOOLANDER.toString());

    }
    
    /** Tests the list toString method. */
    @Test
    public void testListToString() {
        myList1.add(WILLIAM_ZOOLANDER);
        assertEquals(WILLIAM_ZOOLANDER.toString(), myList1.toString());
        myList1.add(JOHN_JACOBS);
        final String string = WILLIAM_ZOOLANDER.toString() + "\n"
                        + JOHN_JACOBS.toString();
        assertEquals(string, myList1.toString());
    }
    
    /** Tests the getLength function. */
    @Test
    public void testGetLength() {
        assertEquals(0, myList1.getLength());
        myList1.add(WILLIAM_ZOOLANDER);
        assertEquals(1, myList1.getLength());
        myList1.add(AARON_AARONSON);
        assertEquals(2, myList1.getLength());
        myList1.add(GARRETT_AARONSON);
        assertEquals(3, myList1.getLength());
        myList1.add(JOHN_JACOBS);
        assertEquals(4, myList1.getLength());
        myList1.add(JOHN_SMITH);
        
        myList2 = generateLargeList();
        assertEquals(1000, myList2.getLength());
    }
    
    /**
     * Tests the adding a single entry to an empty list.
     */
    @Test
    public void testAddOne() {
        
        myList1.add(WILLIAM_ZOOLANDER);
        assertEquals(1, myList1.getLength());
        assertEquals(WILLIAM_ZOOLANDER.toString(), myList1.toString());
    }
    
    /** Tests removing one entry from a list, making it empty. */
    @Test
    public void testRemoveOne() {
        myList1.remove(WILLIAM_ZOOLANDER);
        assertEquals(0, myList1.getLength());
        assertEquals("", myList1.toString());
    }
    
    /** tests removing three entries from the list. */
    @Test
    public void testRemoveThree() {
        myList2 = generateLargeList();
        assertEquals(1000, myList2.getLength());
        myList2.remove(myList2.getElementAt((myR.nextInt(9) + 1) * 100));
        myList2.remove(myList2.getElementAt((myR.nextInt(9) + 1) * 100));
        myList2.remove(myList2.getElementAt((myR.nextInt(9) + 1) * 100));
        assertEquals(997, myList2.getLength());
    }
    
    /** Tests clearing the entire list. */
    @Test
    public void testClearOne() {
        myList1.add(WILLIAM_ZOOLANDER);
        myList1.add(AARON_AARONSON);
        myList1.add(GARRETT_AARONSON);
        myList1.add(JOHN_JACOBS);
        myList1.add(JOHN_SMITH);
        myList1.add(JOSEPH_SMITH);
        assertEquals(6, myList1.getLength());
        myList1.clear();
        assertEquals(0, myList1.getLength());
        assertEquals("", myList1.toString());
    }
    
    /**
     * Tests adding 1000 entries to a list with an initial size of 2.
     */
    @Test
    public void testAddTwo() {
        myList2 = generateLargeList();
        assertEquals(1000, myList2.getLength());
    }
    
    /** tests clearing a list of 1000. */
    @Test
    public void testClearTwo() {
        myList2 = generateLargeList();
        myList2.clear();
        assertEquals(0, myList2.getLength());
    }
    
    /**
     * tests sort by name functionality.
     */
    @Test
    public void testSortByName() {
        myList1.add(WILLIAM_ZOOLANDER);
        myList1.add(AARON_AARONSON);
        myList1.add(GARRETT_AARONSON);
        myList1.add(JOHN_JACOBS);
        myList1.add(JOHN_SMITH);
        myList1.add(JOSEPH_SMITH);
        myList1.sortByName();
        final String sortedList = AARON_AARONSON.toString() + "\n"
                        + GARRETT_AARONSON.toString() + "\n"
                        + JOHN_JACOBS.toString() + "\n"
                        + JOHN_SMITH.toString() + "\n"
                        + JOSEPH_SMITH.toString() + "\n"
                        + WILLIAM_ZOOLANDER;
        assertEquals(sortedList, myList1.toString());
        
    }
    
    /**
     * tests sort by phone functionality.
     */
    @Test
    public void testSortByPhone() {
        myList1.add(WILLIAM_ZOOLANDER);
        myList1.add(AARON_AARONSON);
        myList1.add(GARRETT_AARONSON);
        myList1.add(JOHN_JACOBS);
        myList1.add(JOHN_SMITH);
        myList1.add(JOSEPH_SMITH);
        myList1.sortByPhone();
//        phone order:
//            john smith
//            garrett aaronson
//            aaron aaronson
//            joseph smith
//            william zoolander
//            john jacobs

        final String sortedList = JOHN_SMITH.toString() + "\n"
                        + GARRETT_AARONSON.toString() + "\n"
                        + AARON_AARONSON.toString() + "\n"
                        + JOSEPH_SMITH.toString() + "\n"
                        + WILLIAM_ZOOLANDER.toString() + "\n"
                        + JOHN_JACOBS;
        assertEquals(sortedList, myList1.toString());
        
    }
    
    /**
     * tests sort by email functionality.
     */
    @Test
    public void testSortByEmail() {
        myList1.add(WILLIAM_ZOOLANDER);
        myList1.add(AARON_AARONSON);
        myList1.add(GARRETT_AARONSON);
        myList1.add(JOHN_JACOBS);
        myList1.add(JOHN_SMITH);
        myList1.add(JOSEPH_SMITH);
        myList1.sortByEmail();
//        email order:
//            garrett aaronson
//            john smith
//            joseph smith
//            john jacobs
//            william zoolander
//            aaron aaronson
        final String sortedList = GARRETT_AARONSON.toString() + "\n"
                        + JOHN_SMITH.toString() + "\n"
                        + JOSEPH_SMITH.toString() + "\n"
                        + JOHN_JACOBS.toString() + "\n"
                        + WILLIAM_ZOOLANDER.toString() + "\n"
                        + AARON_AARONSON;
        assertEquals(sortedList, myList1.toString());
        
    }
    
    /**
     * tests functionality of containsPersonWithName method.
     */
    @Test
    public void testContainsPersonWithName() {
        myList1.add(WILLIAM_ZOOLANDER);
        myList1.add(AARON_AARONSON);
        myList1.add(GARRETT_AARONSON);
        myList1.add(JOHN_JACOBS);
        myList1.add(JOHN_SMITH);
        myList1.add(JOSEPH_SMITH);
        assertEquals(true, myList1.containsPersonWithName(WILLIAM_ZOOLANDER.getFullName()));
        assertEquals(false, myList1.containsPersonWithName("b"));
        assertEquals(true, myList1.containsPersonWithName(AARON_AARONSON.getFullName()));
        assertEquals(true, myList1.containsPersonWithName(GARRETT_AARONSON.getFullName()));
        assertEquals(true, myList1.containsPersonWithName(JOHN_JACOBS.getFullName()));
        assertEquals(true, myList1.containsPersonWithName(JOHN_SMITH.getFullName()));
        assertEquals(true, myList1.containsPersonWithName(JOSEPH_SMITH.getFullName()));
        assertEquals(false, myList1.containsPersonWithName("bob barker"));
        assertEquals(false, myList1.containsPersonWithName("william zoolander"));
        assertEquals(true, myList1.containsPersonWithName("William Zoolander"));
    }
    
    /**
     * tests functionality of testGetPersonWithName method.
     */
    @Test
    public void testGetPersonWithName() {
        myList1.add(WILLIAM_ZOOLANDER);
        myList1.add(AARON_AARONSON);
        myList1.add(GARRETT_AARONSON);
        myList1.add(JOHN_JACOBS);
        myList1.add(JOHN_SMITH);
        myList1.add(JOSEPH_SMITH);
        assertEquals(WILLIAM_ZOOLANDER, 
                     myList1.getPersonWithName(WILLIAM_ZOOLANDER.getFullName()));
        assertEquals(WILLIAM_ZOOLANDER, 
                     myList1.getPersonWithName("William Zoolander"));
        assertEquals(JOHN_JACOBS, 
                     myList1.getPersonWithName(JOHN_JACOBS.getFullName()));
        assertEquals(JOSEPH_SMITH, 
                     myList1.getPersonWithName("Joseph Smith"));
    }
    
    /**
     * tests functionality of testGetPersonWithName method.
     */
    @Test
    public void testGetIndexOf() {
        myList1.add(WILLIAM_ZOOLANDER);
        myList1.add(AARON_AARONSON);
        myList1.add(GARRETT_AARONSON);
        myList1.add(JOHN_JACOBS);
        myList1.add(JOHN_SMITH);
        assertEquals(0, myList1.getIndexOf(WILLIAM_ZOOLANDER.getFirstName(), 
                                           WILLIAM_ZOOLANDER.getLastName()));
        assertEquals(2, myList1.getIndexOf(GARRETT_AARONSON.getFirstName(), 
                                           GARRETT_AARONSON.getLastName()));
        assertEquals(3, myList1.getIndexOf(JOHN_JACOBS.getFirstName(), 
                                           JOHN_JACOBS.getLastName()));
        assertEquals(1, myList1.getIndexOf(AARON_AARONSON.getFirstName(), 
                                           AARON_AARONSON.getLastName()));
    }
    
    /**
     * generates a list of 1000 random entries.
     * @return the list of 1000 random entries.
     */
    public MyPeopleList generateLargeList() {
        final MyPeopleList aList = new MyPeopleList();
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        // generates 1000 random people to add to list
        for (int i = 0; i < 1000; i++) {

            
            String firstName = "";
            String lastName = "";
            String address = "";
            int areaCode;
            int phoneNumber;
            String email = "";
            
            firstName = Character.toString(alphabet.charAt(myR.nextInt(alphabet.length())));
            lastName =  Character.toString(alphabet.charAt(myR.nextInt(alphabet.length())));
            address =  Character.toString(alphabet.charAt(myR.nextInt(alphabet.length())));
            areaCode = (myR.nextInt(9) + 1) * 121;
            phoneNumber = (myR.nextInt(9) + 1) * 1231411;
            email = Character.toString(alphabet.charAt(myR.nextInt(alphabet.length()))) 
                            + "@gmail.com";
            final Person person = new Person(firstName, lastName, areaCode, 
                                       phoneNumber, email, address);
            aList.add(person);
        }
        return aList;
    }
}
