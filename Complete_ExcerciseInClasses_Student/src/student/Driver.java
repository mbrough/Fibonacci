package student;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Utility class to run the program.
 * @author Monika
 * @version Jan. 20, 2014
 * @custom.inv none
 */
public final class Driver {

    /**
     * Default constructor.
     */
    private Driver() {   
    }
    
    /**
     * Method to run the program.
     * @param theArgs command line arguments
     */
    @SuppressWarnings("deprecation")
    public static void main(final String[] theArgs)  {
        final List<AbstractStudent> testList = new ArrayList<AbstractStudent>();
        

        final Date bDay1 = new Date(1994, 7 - 1, 2);
        final Date bDay2 = new Date();
        final Date bDay3 = new GregorianCalendar(1994, 7 - 1, 26).getTime();

        testList.add(new UndergradStudent(createName("Monika", "Sobolewska"), 
                    "P00011122", 0, 0, UndergradStatus.FRESHMAN, Gender.FEMALE, bDay1));
        testList.add(new UndergradStudent(createName("Nadeem", "Ansari"), 
                   "P00011123", 120, 3.45, UndergradStatus.SENIOR, Gender.MALE, bDay2));
        testList.add(new UndergradStudent(createName("Alex", "Witoslawski"), 
                     "P00011124", 0, 0, UndergradStatus.FRESHMAN, Gender.MALE, bDay3));
        testList.add(new MastersStudent(createName("Hanna", "Roszczenko"), "P123123123", 0, 0,
                    MastersStatus.APPLICANT, Gender.FEMALE, bDay1, bDay2));
        
        for (final Object s: testList) {
            System.out.println(s);
        }
        
        final Date copy = testList.get(0).getBirth();
        copy.setYear(3015);
        System.out.println(testList.get(0));

        
    }
    
    /**
     * Creates a string array with first and last name.
     * @param theFirstName the first name of the student
     * @param theLastName the last name of the student
     * @return the full name string array
     */
    private static String[] createName(final String theFirstName, final String theLastName) {
        final String[] nameArray = new String[2];
        nameArray[0] = theFirstName;
        nameArray[1] = theLastName;
        return nameArray;
    }

}
