/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A class to read and interpret lists of data.
 * @author Molly Brougham
 * @version 1.0
 *
 */
public class DataReader {
    /** A string with the text for E-Mail Address. */
    private static final String EMAIL_STRING = "E-Mail Address";
    
    /** A string with the text for phone number. */
    private static final String PHONE_STRING = "Phone Number";
    
    /** A string with the text for street address. */
    private static final String STREET_STRING = "Street Address";

    /** A string with the text for name. */
    private static final String NAME_STRING = "Name";
    
    /** A string that represents a tab indent. */
    private static final String TAB = "\t";
    
    /** A string that represents a single space. */
    private static final String SPACE = " ";

    /** the index of the name within a block of data. */
    private static final int NAME_INDEX = 0;

    /** the index of the address within a block of data. */
    private static final int ADDRESS_INDEX = 1;

    /** the index of the phone number within a block of data. */
    private static final int PHONE_INDEX = 2;

    /** the index of the email within a block of data. */
    private static final int EMAIL_INDEX = 3;

        
    /** A string that represents the text in the list. */
    private final StringBuffer myListText = new StringBuffer();
    
    /** the list of people being edited. */
    private final MyPeopleList myListOfPeople = new MyPeopleList();
    
    /** an arraylist of the lines of text in the file. */
    private final ArrayList<String> myLines = new ArrayList<String>();

    /** the full name of a person. */
    private String myFullName;

    /** the first name of a person. */
    private String myFirstName;

    /** the last name of a person. */
    private String myLastName;

    /** the street address of a person. */
    private String myAddress;

    /** the full phone number of a person as a string. */
    private String myFullNumber;

    /** the area code of a person. */
    private int myAreaCode;

    /** the phone number (without area code) of a person. */
    private int myPhone;

    /** the emailAddress of a person. */
    private String myEmail;
    
    /**
     * Loads a new list into the text area.
     * @param theListDocument the list document to be opened.
     */
    public void readFile(final File theListDocument) {
        try {
            myLines.clear();
            String line;
            final BufferedReader reader = new BufferedReader(new FileReader(theListDocument));
                        
            while ((line = reader.readLine()) != null) {
                myListText.append(line + "\n");
                myLines.add(line);
            }

            reader.close();   
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }
    
    /**
     * Turns the data in the file into a list of people. 
     */
    public void makeList() {
        int i = 0;
        final int reset = 6;
        if (!myLines.isEmpty()) {
            int j = 0;
            for (i = 0; i < myLines.size(); i++) {
                if (myLines.get(i).contains(TAB)) {
                    final String tempLine = myLines.get(i);
                    myLines.set(i, tempLine.substring(tempLine.indexOf(TAB) + 1, 
                                                      tempLine.length()));
                }
                setData(i, j);
                j++;
                
                if (j == reset) {
                    j = 0;
                    if (myFirstName != null && myPhone != 0) {
                        final Person person = new Person(myFirstName, myLastName,
                                                         myAreaCode, myPhone,
                                                         myEmail, myAddress);
                        myListOfPeople.add(person);  
                    }
                    
                }
                if (i >= myLines.size() - 1) {
                    if (myFirstName != null && myPhone != 0) {
                        final Person person = new Person(myFirstName, myLastName,
                                                         myAreaCode, myPhone,
                                                         myEmail, myAddress);
                        myListOfPeople.add(person);  
                    }
                }
            }
        }
    }


    /**
     * Sets up the data for a single person from the list.
     * @param theFirstIndex the first index of data in the list.
     * @param theSecondIndex the second index of data in the list. 
     */
    private void setData(final int theFirstIndex, final int theSecondIndex) {
        if (theSecondIndex == NAME_INDEX 
                        && !myLines.get(theFirstIndex).equalsIgnoreCase(NAME_STRING)) {
            myFullName = myLines.get(theFirstIndex);
            
            myFirstName = myFullName.substring(0, myFullName.indexOf(SPACE));
            
            myLastName = myFullName.substring(myFullName.indexOf(SPACE) + 1, 
                                          myFullName.length());
            
        } else if (theSecondIndex == ADDRESS_INDEX
                        && !myLines.get(theFirstIndex).equalsIgnoreCase(STREET_STRING)) {
            myAddress = myLines.get(theFirstIndex);
        } else if (theSecondIndex == PHONE_INDEX
                        && !myLines.get(theFirstIndex).equalsIgnoreCase(PHONE_STRING)) {
            myFullNumber = myLines.get(theFirstIndex);
            String areaString = "";
            if (myFullNumber.contains("(")) {
                areaString = 
                                myFullNumber.substring(myFullNumber.indexOf('(') + 1, 
                                                         myFullNumber.indexOf(')'));
            }
            myAreaCode = Integer.parseInt(areaString);
            final int prefixStart = 6;
            final int prefixEnd = 9;
            final int suffixStart = 10;
            final String phoneString = 
                                myFullNumber.substring(prefixStart, prefixEnd) 
                                + myFullNumber.substring(suffixStart, myFullNumber.length());
            myPhone = Integer.parseInt(phoneString);
            
                                                 
            
        } else if (theSecondIndex == EMAIL_INDEX
                        && !myLines.get(theFirstIndex).equalsIgnoreCase(EMAIL_STRING)) {
            myEmail = myLines.get(theFirstIndex);
        }
        
    }

    /**
     * Returns the list text.
     * @return the list text
     */
    public MyPeopleList getList() {
        return myListOfPeople;
    }

    /**
     * Checks whether the given file is a list of people.
     * @param theFile the file to check.
     * @return boolean value of whether the file is a valid list.
     */
    public boolean checkFile(final File theFile) {
        readFile(theFile);
        final String textString = myListText.toString();
        boolean toReturn = false;
        if (textString.contains(NAME_STRING) && textString.contains(STREET_STRING)
                        && textString.contains(PHONE_STRING) 
                        && textString.contains(EMAIL_STRING)) {
            toReturn = true;
        }
        return toReturn;
    }
}