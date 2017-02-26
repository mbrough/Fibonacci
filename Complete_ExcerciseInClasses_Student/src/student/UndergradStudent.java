package student;

import java.util.Date;

/**
 * Represents an Undergrad student.
 * @author Molly Brougham
 * @version Apr 8 2015
 * @custom.inv none
 */
public class UndergradStudent extends AbstractStudent implements Cloneable {

    /**
     * Parameterized constructor - constructs an UndergradStudent object.
     * @param theFullName a string array consisting of the student's full name
     * @param theID is a string of 9 characters representing student ID
     * @param theCreditHours is an integer number >=0 representing number of credit hours 
     *          taken by a student
     * @param theGPA is a double number representing GPA, a GPA must be >= 0 and <= 4.0
     * @param theStatus is a string representing student status, != null
     * @param theGender is a character representing student gender, != null
     * @param theBirth is a date representing student birth date; a student cannot be younger 
     *          than 10 years old 
     * @custom.post MastersStudent object constructed; if invalid parameters passed, 
     *          student is in an invalid state.
     */
    public UndergradStudent(final String[] theFullName, 
                            final String theID, final int theCreditHours, 
                            final double theGPA, final UndergradStatus theStatus,
                            final Gender theGender, final Date theBirth) {
        super(theFullName, theID, theCreditHours, 
              theGPA, theStatus, theGender, theBirth);
    }
    
    /**
     * Creates a clone of the student.
     * @return UndergradStudent a clone of the Masters Student
     * @throws CloneNotSupportedException .
     */
    public UndergradStudent clone() throws CloneNotSupportedException {
        return (UndergradStudent) super.clone();
        
    }
    
    

}
