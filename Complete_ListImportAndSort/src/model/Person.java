/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package model;

import java.util.Locale;

/**
 * Represents a person.
 * 
 * @author Molly Brougham
 * @version 1.0
 * 
 * A person can only be created if 
 * they have at least a first and last name, and an email.
 */
public class Person implements Comparable<Person> {
    /** represents the at symbol (@). */
    private static final String AT = "@";
    
    /** represents a dash symbol. */
    private static final String DASH = "-";
    
    /** represents a dot symbol. */
    private static final String DOT = ".";
    
    /** An int to represent an empty phone. */
    private static final int NO_PHONE = -1;
    
    /** An int to represent an empty area code. */
    private static final int NO_AREA_CODE = -1;
    
    /** A string to represent no valid email address. */
    private static final String INVALID_EMAIL = "No valid e-mail address listed.";
    
    /** A string to fill an empty street address. */
    private static final String NO_ADDRESS = "No Street Address given.";
    
    /** the number of digits in a phone number. */
    private static final int PHONE_LENGTH = 7;
    
    /** the number of digits in an area code. */
    private static final int AREA_CODE_LENGTH = 3;
    
    /** The persons first name. */
    private String myFirstName;

    /** The persons last name. */
    private String myLastName;
    
    /** The persons area code. */
    private int myAreaCode;

    /** The persons phone number. */
    private int myPhone;

    /** The persons e-mail address. */
    private String myEmail;

    /** The persons street address. */
    private String myAddress;
    
    /** The persons full name. */
    private String myFullName;


    /** Private non-parameterized constructor to prevent use. */
    @SuppressWarnings("unused")
    private Person() {

    }
    

    /**
     * Constructor to create a Person without an address.
     * @param theFirstName the persons first name
     * @param theLastName the persons last name
     * @param theAreaCode the persons area code
     * @param thePhone the persons phone number
     * @param theEmail the persons email address
     * @custom.post overloaded constructor for no address.
     */
    public Person(final String theFirstName, final String theLastName, 
                  final int theAreaCode, final int thePhone, final String theEmail) {
        this(theFirstName, theLastName, theAreaCode, thePhone, theEmail, NO_ADDRESS);
    }

    /**
     * Constructor to create a Person without a phone or an address.
     * @param theFirstName the persons first name
     * @param theLastName the persons last name
     * @param theEmail the persons email address
     * @custom.post overloaded constructor for no phone or address.
     */
    public Person(final String theFirstName, final String theLastName,
                  final String theEmail) {
        this(theFirstName, theLastName, NO_AREA_CODE, NO_PHONE, theEmail, NO_ADDRESS);
    }
    
    /**
     * Main constructor to create a Person.
     * @param theFirstName the persons first name
     * @param theLastName the persons last name
     * @param theAreaCode the persons area code
     * @param thePhone the persons phone number (without area code)
     * @param theEmail the persons email address
     * @param theAddress the persons street address
     */
    public Person(final String theFirstName, final String theLastName, 
                  final int theAreaCode, final int thePhone,
                  final String theEmail, final String theAddress) {
        checkPhoneValidity(theAreaCode, thePhone);
        if (!theEmail.contains(AT) || !theEmail.contains(DOT)) {
            throw new IllegalArgumentException("Invalid E-Mail Address");
        }
        setNames(theFirstName, theLastName);
        myAreaCode = theAreaCode;
        myPhone = thePhone;
        myEmail = theEmail;
        myAddress = theAddress;
    }


    /**
     * Checks whether the area code and phone number given are valid phone numbers.
     * @param theAreaCode the area code to be checked.
     * @param thePhone the phone number to be checked.
     */
    private void checkPhoneValidity(final int theAreaCode, final int thePhone) {
        if ((Integer.toString(thePhone).length() < PHONE_LENGTH - 1
                        || Integer.toString(theAreaCode).length() < AREA_CODE_LENGTH - 1) 
                        && thePhone != -1
                        || (Integer.toString(thePhone).charAt(0) == '0')) {
            throw new IllegalArgumentException("Invalid phone number.");
        }
        
        if (Integer.toString(theAreaCode).charAt(0) == '0') {
            throw new IllegalArgumentException("Invalid area code.");
        }
        
    }


    /**
     * Sets the first and last name of the person, making sure they are
     * capitalized correctly.
     * @param theFirstName the persons first name.
     * @param theLastName the persons last name.
     */
    private void setNames(final String theFirstName, final String theLastName) {
        
        final Locale locale = Locale.getDefault();
        if (theFirstName.length() > 1) {
            myFirstName =
                            theFirstName.substring(0, 1).toUpperCase(locale)
                                            + theFirstName.substring(1).toLowerCase(locale);
        } else {
            myFirstName = theFirstName.toUpperCase(locale);
        }

        if (theLastName.length() > 1) {
            myLastName =
                            theLastName.substring(0, 1).toUpperCase(locale)
                                            + theLastName.substring(1).toLowerCase(locale);
        } else {
            myLastName = theLastName.toUpperCase(locale);
        }
        
        myFullName = myFirstName + " " + myLastName;

    }

    /**
     * compares two people alphabetically based on their names.
     * @param theOtherPerson the other person to be compared
     * @return the value 0 if the names are identical, a value 
     * less than 0 if the current person is alphabetically lower 
     * than the argument and a value greater than 0 if the current 
     * person is alphabetically higher than the argument.
     * @custom.post compares last names first, followed by first names
     */
    @Override
    public int compareTo(final Person theOtherPerson) {
        int toReturn;
        
        if (myLastName.equals(theOtherPerson.getLastName())) {
            toReturn = myFirstName.compareTo(theOtherPerson.getFirstName());
        } else {
            toReturn = myLastName.compareTo(theOtherPerson.getLastName());
        }
        
        return toReturn;
        
    }
    
    /**
     * Compares two people based on their email address.
     * @param theOtherPerson the other person to compare emails with
     * @return the value 0 if the emails are identical, a value 
     * less than 0 if the current persons email is alphabetically lower 
     * than the argument and a value greater than 0 if the current 
     * persons email is alphabetically higher than the argument. 
     */
    public int compareEmail(final Person theOtherPerson) {
        String email;
        String otherEmail;
        
        if (myEmail.contains(AT)) {
            email = myEmail.substring(0, myEmail.indexOf(AT));
        } else {
            email = INVALID_EMAIL;
        }
        
        if (theOtherPerson.getEmail().contains(AT)) {
            final String otherPersonsEmail = theOtherPerson.getEmail();
            final int atLocation = otherPersonsEmail.indexOf(AT);
            otherEmail = otherPersonsEmail.substring(0, atLocation);
        } else {
            otherEmail = INVALID_EMAIL;
        }
        return email.compareToIgnoreCase(otherEmail);
    }
    
    /**
     * Compares two people based on their phone number.
     * @param theOtherPerson the other person to compare phone numbers with
     * @return the value 0 if the phone numbers are identical, a value 
     * less than 0 if the current persons phone number is lower 
     * than the argument and a value greater than 0 if the current 
     * persons phone number higher than the argument.
     */
    public int comparePhone(final Person theOtherPerson) {
        int toReturn;
        if (myAreaCode == theOtherPerson.getAreaCode()) {
            toReturn = myPhone - theOtherPerson.getPhone();
        } else {
            toReturn = myAreaCode - theOtherPerson.getAreaCode();
        }
        return toReturn;
//        return (myAreaCode + myPhone) 
//                        - (theOtherPerson.getAreaCode() + theOtherPerson.getPhone());       
    }

    /**
     * Creates a string of the persons information.
     * @return the string of the persons information.
     */
    @Override
    public String toString() {
        final String prefix = Integer.toString(myPhone).substring(0, 3);
        final String suffix = Integer.toString(myPhone).substring(3, 7);
        final String phone = Integer.toString(myAreaCode) + DASH + prefix + DASH + suffix;
        final String string =
                        myLastName + ", " + myFirstName + ": E-Mail: " + myEmail + ", Phone: "
                                        + phone + ", Address: " + myAddress;
        return string;
    }

    /**
     * determines whether two people are the same.
     * @param otherPerson the Person to compare.
     * @return boolean that says whether the two people are the same.
     */
    @Override
    public boolean equals(final Object theOtherPerson) {
        boolean equals = false;
        if (theOtherPerson instanceof Person) {
            final Person otherPerson = (Person) theOtherPerson;
            if (otherPerson != null && otherPerson.getFirstName().equals(myFirstName)
                && otherPerson.getLastName().equals(myLastName)
                && otherPerson.getEmail().equals(myEmail) && otherPerson.getPhone() == myPhone
                && otherPerson.getAddress().equals(myAddress)) {
                equals = true;
            }
        }

        return equals;

    }

    /**
     * returns a hash code value for the person.
     * @return a hash code value for this person.
     */
    @Override
    public int hashCode() {
        return (int) myPhone * myFirstName.hashCode() * myLastName.hashCode()
               * myEmail.hashCode() * myAddress.hashCode();

    }

    /**
     * Returns the persons first name.
     * @return the persons first name
     */
    public String getFirstName() {
        return myFirstName;
    }

    /**
     * Returns the persons last name.
     * @return the persons last name
     */
    public String getLastName() {
        return myLastName;
    }

    /**
     * Returns the persons phone number.
     * @return the persons phone number
     */
    public int getPhone() {
        return myPhone;
    }
    
    /**
     * Returns the persons area code.
     * @return the persons area code
     */
    public int getAreaCode() {
        return myAreaCode;
    }

    /**
     * Returns the persons email address.
     * @return the persons email address
     */
    public String getEmail() {
        return myEmail;
    }

    /**
     * Returns the persons street address.
     * @return the persons street address
     */
    public String getAddress() {
        return myAddress;
    }
    
    /**
     * Returns the persons full name.
     * @return the persons full name
     */
    public String getFullName() {
        return myFullName;
    }

}
