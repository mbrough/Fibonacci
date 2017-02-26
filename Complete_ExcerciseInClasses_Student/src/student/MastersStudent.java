package student;

import java.util.Date;
import java.util.Objects;

/**
 * Represents a Masters student.
 * @author Monika
 * @version Jan. 12. 2014
 * @custom.inv none
 */
public class MastersStudent extends AbstractStudent implements Cloneable {
    
    /**
     * represents deadline to graduate.
     */
    private static final int TIME_LIMIT = 4;
    
    /**
     * a String to express an error with student status.
     */
    private static final String STUDENT_STATUS_ERROR = 
                    "Masters student cannot have undergraduate status";
    
    /**
     * status of a masters student, either applicant or candidate.
     */
    private MastersStatus myGradStatus;

    /**
     * the date the student started in the program.
     */
    private final Date myStartDate;
    
    /** 
     * number of years in the program.
     */
    private int myYears;
    

    /**
     * Parameterized constructor - constructors a MastersStudent object.
     * @param theFullName a string array consisting of the students full name.
     * @param theID is a string of 9 characters representing student ID
     * @param theCreditHours is an integer number >=0 representing number of credit hours 
     *          taken by a student
     * @param theGPA is a double number representing GPA, a GPA must be >= 0 and <= 4.0
     * @param theStatus is a string representing student status, != null
     * @param theGender is a character representing student gender, != null
     * @param theBirth is a date representing student birth date; a student cannot be younger 
     *          than 10 years old 
     * @param theDate is date the student started in the program
     * @custom.post MastersStudent object constructed; if invalid parameters passed, 
     *          student is in an invalid state.
     */
    public MastersStudent(final String[] theFullName, final String theID, 
                          final int theCreditHours, final double theGPA, 
                          final MastersStatus theStatus, final Gender theGender, 
                          final Date theBirth, final Date theDate) {
        super(theFullName, theID, theCreditHours, theGPA, null, 
              theGender, theBirth);
        myGradStatus = theStatus;
        myYears = 0;
        myStartDate = theDate;
    }
    
    
    
    /**
     * Returns time limit to finish the degree.
     * @return timeLimit
     */
    public static int getTimeLimit() {
        return TIME_LIMIT;
    }

    /**
     * Inherited method that attempts to returns undergraduate student status 
     * for a graduate student.
     * @return an exception since a graduate student cannot hold graduate status
     * @throws IllegalStateException since a method should not be invoked on a graduate student
     */
    @Override
    public UndergradStatus getStatus() {
        throw new IllegalStateException(STUDENT_STATUS_ERROR);
    }
    
    /**
     * Returns graduate student status.
     * @return graduate student status
     */
    public MastersStatus getGradStatus() {
        return myGradStatus;
    }

    /**
     * Returns the starting date for a student.
     * @return the starting date for a student
     */
    public Date getMyStartDate() {
        return new Date(myStartDate.getTime());
    }

    /**
     * Returns number of years in the program.
     * @return the myYears
     */
    public int getMyYears() {
        return myYears;
    }

    /**
     * Assigns graduate student status.
     * @param theGradStatus is a student status to be assigned
     * @custom.post graduate student status assigned
     */
    public void setGradStatus(final MastersStatus theGradStatus) {
        this.myGradStatus = theGradStatus;
    }
    
    /**
     * Inherited method that attempts to assign an undergrad status to a grad student.
     * @param theStatus containing student status
     * @throws IllegalStateException since grad students cannot be assigned undergrad status
     */
    public void setStatus(final UndergradStatus theStatus) {
        throw new IllegalStateException(STUDENT_STATUS_ERROR);
    }

    /**
     * Assignes the number of years in the program.
     * @param theYears to be assigned
     * @custom.post years assigned
     */
    public void setMyYears(final int theYears) {
        this.myYears = theYears;
    }
    
    

    /**
     * Represents master's student object as a string.
     * @see java.lang.Object#toString()
     * @return string representing a master student object
     */
    @Override
    public String toString() {
        return super.toString() + "MastersStudent [myGradStatus=" + myGradStatus 
               + ", myStartDate=" + myStartDate + ", myYears=" + myYears + "]";
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), TIME_LIMIT, STUDENT_STATUS_ERROR, 
                            myGradStatus, myStartDate, myYears);
    }
    
    /**
     * Determines whether two master students are the same.
     * @param theOtherStudent the student being compared
     * @return boolean value whether the students are the same
     */
    public boolean equals(final Object theOtherStudent) {
        if (theOtherStudent != null) {
            return this.hashCode() == theOtherStudent.hashCode();
        }
        throw new IllegalArgumentException();
    }
    
    /**
     * Creates a clone of the student.
     * @return MastersStudent a clone of the Masters Student
     * @throws CloneNotSupportedException .
     */
    public MastersStudent clone() throws CloneNotSupportedException {
        return (MastersStudent) super.clone();
        
    }
    
    

}
