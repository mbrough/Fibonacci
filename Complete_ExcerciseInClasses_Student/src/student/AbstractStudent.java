/**
 * MS
 * TCCS 305 A Spring 2015
 * Student Assignment
 */

package student;

import java.util.Date;
import java.util.Objects;

/**
 * Represents university student.
 * @author Monika
 * @version Dec. 10, 2013
 * @custom.inv none
 */

public abstract class AbstractStudent implements Cloneable {

    /**
     * The highest GPA a student can achieve.
     */
    private static final double TOP_GPA = 4.0; 
    
    /**
     * First name of a student.
     */
    private String myFirstName;
    
    /**
     * Last name of a student.
     */
    private String myLastName;
    
    /**
     * Student 9-digit ID.
     */
    private String myID;
    
    /**
     * Number of credit hours completed by a student.
     */
    private int myCreditHours;
    
    /**
     * Current student GPA.
     */
    private double myGPA;
    
    /** Student status.
     * 
     */
    private UndergradStatus myStatus;
    
    /**
     * Student gender.
     */
    private Gender myGender;
    
    /** Student date of birth.
     * 
     */
    private Date myBirth;

    /**
     * Student's full name.
     */
    private String[] myFullName;
    
    /**
     * Private constructor to prohibit default instantiation.
     */
    @SuppressWarnings("unused")
    private AbstractStudent() {
        
    }
    
    /**
     * Parameterized constructor - constructors a Student object.
     * @param theFullName a string array consisting of a first name and a last name
     * @param theID is a string of 9 characters representing student ID
     * @param theCreditHours is an integer number >=0 representing number of credit hours 
     *          taken by a student
     * @param theGPA is a double number representing GPA, a GPA must be >= 0 and <= 4.0
     * @param theStatus is a string representing student status, != null
     * @param theGender is a character representing student gender, != null
     * @param theBirth is a date representing student birth date; a student cannot be younger 
     *          than 10 years old 
     * @custom.post Student object constructed; if invalid parameters passed, 
     *          student is in an invalid state.
     */
    public AbstractStudent(final String[] theFullName, final String theID, 
                   final int theCreditHours, final double theGPA,
                   final UndergradStatus theStatus, final Gender theGender, 
                   final Date theBirth) {
        
        myFullName = theFullName;        
        myFirstName = theFullName[0];
        myLastName = theFullName[1];
        myID = theID;
        myCreditHours = theCreditHours;
        myGPA = theGPA;
        myStatus = theStatus;
        myGender = theGender;
        myBirth = new Date(theBirth.getTime());
    }
    
    /**
     * Returns student's first name.
     * @return student's first name
     */
    public String getFirstName() {
        return myFirstName;
    }
    
    /**
     * Returns student's last name.
     * @return student's last name
     */
    public String getLastName() {
        return myLastName;
    }
    
    /**
     * Assigns the last name to a student.
     * @param theFirstName is a string representing student's first name, != null
     */
    public void setFirstName(final String theFirstName) {
        if (theFirstName != null) {
            this.myFirstName = theFirstName;
            myFullName[0] = theFirstName;
        } else {
            throw new IllegalArgumentException("First name cannot be null");
        }
    }
    
    /**
     * Assigns the last name to a student.
     * @param theLastName is a string representing student's last name, != null
     * @custom.post student's last name assigned 
     */
    public void setLastName(final String theLastName) {
        if (theLastName != null) {
            this.myLastName = theLastName;
            myFullName[1] = theLastName;
        } else {
            throw new IllegalArgumentException("Last name cannot be null");
        }
    }
    
    /**
     * Returns student's ID.
     * @return student's ID
     */
    public String getID() {
        return myID;
    }
    
    /**
     * Returns student's credit hours.
     * @return student's credit hours
     */
    public int getCreditHours() {
        return myCreditHours;
    }
    
    /**
     * Assigns number of credit hours to a student.
     * @param theCreditHours is the number of credit hours, >= 0
     * @custom.post student's credit hours assigned; if hours invalid, object in invalid state
     */
    public void setCreditHours(final int theCreditHours) {
        if (theCreditHours >= 0) {
            myCreditHours = theCreditHours;
        } else {
            throw new IllegalArgumentException("Credit hours must be greater than zero");
        }
    }
    
    /**
     * Returns student's GPA.
     * @return student's GPA
     */
    public double getGPA() {
        return myGPA;
    }
    
    /**
     * Assigns student's GPA.
     * @param theGPA is student's current GPA, >= 0, <= 4.0
     * @custom.post student's GPA assigned 
     */
    public void setGPA(final double theGPA) {
        if (theGPA >= 0 && theGPA <= TOP_GPA) {
            myGPA = theGPA;
        } else {
            throw new IllegalArgumentException("GPA must be between 0 and 4.0");
        }
    }
    
    /**
     * Returns student's status.
     * @return student's status
     */
    public UndergradStatus getStatus() {
        return myStatus;
    }
    
    /**
     * Assigns status to a student.
     * @param theStatus is a String that represents student's status, != null
     * @custom.post student's status assigned 
     */
    public void setStatus(final UndergradStatus theStatus) {
        if (theStatus != null) {
            myStatus = theStatus;
        } else {
            throw new IllegalArgumentException("The Undergraduate status cannot be null");
        }
    }
    
    /**
     * Returns student's gender.
     * @return student's gender
     */
    public Gender getGender() {
        return myGender;
    }
    
    /**
     * Returns student's date of birth.
     * @return student's date of birth
     */
    public Date getBirth() {
        return new Date(myBirth.getTime());
    }
    
    /**
     * Assigns birth date to a student.
     * @param theDate is the date.
     * @custom.post birth date assigned; if invalid date passed, object in invalid state
     */
    public void setBirth(final Date theDate) {
        myBirth = theDate;
    }
   
    /**
     * Overrides Object toString method; returns a String containing all object's information.
     * @return a String object containing all object's information
     */
 
    /* @Override
    public String toString() {
        return "Student [myFirstName=" + myFirstName + ", myLastName=" + myLastName
               + ", myID=" + myID + ", myCreditHours=" + myCreditHours + ", myGPA=" + myGPA
               + ", myStatus=" + myStatus + ", myGender=" + myGender + ", myBirth=" + myBirth
               + "]";
    }*/
    @Override
    public String toString() {
        final StringBuilder rep = new StringBuilder(100);
        final String bracket = "]";
        rep.append("Student [myFirstName=");
        rep.append(myFirstName);
        rep.append(", myLastName=");
        rep.append(myLastName);
        rep.append(", myID=");
        rep.append(myID);
        rep.append(", myCreditHours=");
        rep.append(myCreditHours);
        rep.append(", myGPA=");
        rep.append(myGPA);
        rep.append(", myStatus=");
        rep.append(myStatus);
        rep.append(", myGender=");
        rep.append(myGender);
        rep.append(", myBirth=");
        rep.append(myBirth);
        rep.append(bracket);
        return rep.toString();
    }
    
    
    @Override
    public int hashCode() {
        return Objects.hash(myFirstName, myLastName, myID, 
                            myCreditHours, myGPA, myStatus, myGender, myBirth);
    }
    /**
     * Determines whether two students are the same.
     * @param theOtherStudent the student to be compared
     * @return boolean value of whether the students are the same
     */
    @Override
    public boolean equals(final Object theOtherStudent) {
        if (theOtherStudent != null) {
            //if parameter is not null, return whether they are equal
            return this.hashCode() == theOtherStudent.hashCode();
        }
        //if parameter is null throw exception
        throw new IllegalArgumentException();
    }
    
}