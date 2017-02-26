package tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import student.Gender;
import student.UndergradStatus;
import student.UndergradStudent;

/**
 * Tests functionality of UndergradStudentClass.
 * @author Molly Brougham
 * @version 1.0
 *
 */
public class UndergradStudentTest {

    /**
     * tolerance.
     */
    private static final double T = 0.000000;
    
    /**
     * student object.
     */
    private UndergradStudent myUS;

    /**
     * second student object.
     */
    private UndergradStudent myUS2;

    /**
     * 
     * @throws Exception if 
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * 
     * @throws Exception exception
     */
    @SuppressWarnings("deprecation")
    @Before
    public void setUp() throws Exception {
        myUS = new UndergradStudent(createName("John", "Jacobs"), "980395981", 
                                    0, 4.0, UndergradStatus.JUNIOR, Gender.MALE, 
                                    new Date(1987, 12, 1));
        myUS2 = new UndergradStudent(createName("John", "Jacobs"), "980395981", 
                                     0, 4.0, UndergradStatus.JUNIOR, Gender.MALE, 
                                     new Date(1987, 12, 1));
    }
    
    /**
     * tests getFirstName().
     */
    @Test
    public void getFirstNameTest() {
        assertEquals("John", myUS.getFirstName());
        
    }
    
    /**
     * tests getLastName().
     */
    @Test
    public void getLastNameTest() {
        assertEquals("Jacobs", myUS.getLastName());
        
    }
    
    /**
     * tests setFirstName().
     */
    @Test
    public void setFirstNameTest() {
        myUS.setFirstName("Jonathan");
        assertEquals("Jonathan", myUS.getFirstName());
    }
    
    /**
     * tests for exception when sending null parameter to setFirstName().
     */
    @Test (expected = IllegalArgumentException.class)
    public void setNullFirstName() {
        myUS.setFirstName(null);
    }
    
    /**
     * tests for exception when sending null parameter to setLastName().
     */
    @Test (expected = IllegalArgumentException.class)
    public void setNullLastName() {
        myUS.setLastName(null);
    }
    
    /**
     * tests setLastName().
     */
    @Test
    public void setLastNameTest() {
        myUS.setLastName("Jacobson");
        assertEquals("Jacobson", myUS.getLastName());
    }
    
    /**
     * tests setCreditHours().
     */
    @Test
    public void setCreditHoursTest() {
        myUS.setCreditHours(5);
        assertEquals(5, myUS.getCreditHours());
        myUS.setCreditHours(500);
        assertEquals(500, myUS.getCreditHours());
        myUS.setCreditHours(41321321);
        assertEquals(41321321, myUS.getCreditHours());
    }
    
    /**
     * tests for an exception when sending a negative number to setCreditHours().
     */
    @Test (expected = IllegalArgumentException.class)
    public void setNegativeCreditHoursTest() {
        myUS.setCreditHours(-5);
    }

    /**
     * test setGPA().
     */
    @Test
    public void setGPATest() {
        myUS.setGPA(3.9);
        assertEquals(3.9, myUS.getGPA(), T);
        myUS.setGPA(2.0);
        assertEquals(2.0, myUS.getGPA(), T);
    }
    
    /**
     * test setGPA() with a negative parameter.
     */
    @Test (expected = IllegalArgumentException.class)
    public void setNegativeGPATest() {
        myUS.setGPA(-1);
    }
    
    /**
     * test setGPA() with a parameter that is over 4.0.
     */
    @Test (expected = IllegalArgumentException.class)
    public void setTooHighGPATest() {
        myUS.setGPA(4.1);
    }
    
    /**
     * test setStatus().
     */
    @Test
    public void setStatusTest() {
        myUS.setStatus(UndergradStatus.SENIOR);
        assertEquals(UndergradStatus.SENIOR, myUS.getStatus());
    }
    
    /**
     * test setStatus() with null parameter.
     */
    @Test (expected = IllegalArgumentException.class)
    public void setNullStatusTest() {
        myUS.setStatus(null);
    }
    
    /**
     * test setBirth().
     */
    @SuppressWarnings("deprecation")
    @Test
    public void setBirthTest() {
        myUS.setBirth(new Date(1987, 12, 2));
        assertEquals(new Date(1987, 12, 2), myUS.getBirth());
    }
    
    /**
     * tests getID().
     */
    @Test
    public void getIDTest() {
        assertEquals("980395981", myUS.getID());
    }
    
    /**
     * tests getCreditHours().
     */
    @Test
    public void getCreditHoursTest() {
        assertEquals(0, myUS.getCreditHours());
    }
    
    /**
     * tests getStatus().
     */
    @Test
    public void getStatusTest() {
        assertEquals(UndergradStatus.JUNIOR, myUS.getStatus());
    }
    
    /**
     * tests getGender().
     */
    @Test
    public void getGenderTest() {
        assertEquals(Gender.MALE, myUS.getGender());
    }
    
    /**
     * Tests .equals().
     */
    @Test
    public void equalsTest() {
        assertTrue(myUS.equals(myUS2));
    }
    
    /**
     * Test .equals() for exceptions.
     */
    @Test (expected = IllegalArgumentException.class) 
    public void equalsNullTest() {
        myUS.equals(null);
    }
    
    /**
     * tests getGPA().
     */
    @Test
    public void getGPATest() {
        assertEquals(4.0, myUS.getGPA(), T);
    }
    
    /**
     * Tests getBirth().
     */
    @SuppressWarnings("deprecation")
    @Test
    public void getBirthTest() {
        assertEquals(new Date(1987, 12, 1), myUS.getBirth());
    }
    
    /**
     * tests toString().
     */
    @Test
    public void toStringTest() {
        assertEquals("Student [myFirstName=John, "
                        + "myLastName=Jacobs, "
                        + "myID=980395981, "
                        + "myCreditHours=0, "
                        + "myGPA=4.0, "
                        + "myStatus=JUNIOR, "
                        + "myGender=MALE, "
                        +  "myBirth=" + myUS.getBirth()
                        + "]", myUS.toString());
    }
    
    /**
     * a method to create a string array holding the first and last name of a person.  
     * @param theFirstName the first name of the person
     * @param theLastName the last name of the person
     * @return a string array containing first and last name
     */
    public String[] createName(final String theFirstName, final String theLastName) {
        final String[] nameArray = new String[2];
        nameArray[0] = theFirstName;
        nameArray[1] = theLastName;
        return nameArray;
    }
}
