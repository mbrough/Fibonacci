/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.MyPeopleList;
import model.Person;
import view.ListPanel;

/**
 * Represents a listener that adjusts the list.
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
public class ListSortListener implements ActionListener {

    /** represents a single space. */
    private static final String SPACE = " ";
    
    /** represents a dash character. */
    private static final String DASH = "-";
    
    /** represents the open parenthesis symbol. */
    private static final String OPEN_PARENTHESIS = "(";
    
    /** represents the close parenthesis symbol. */
    private static final String CLOSE_PARENTHESIS = ") ";
    
    /** represents the string for remove person. */
    private static final String REMOVE_PERSON = "Remove Person";
    
    /** represents the string for add person. */
    private static final String ADD_PERSON = "Add Person";

    /** represents the string to create a new line of text. */
    private static final String NEW_LINE = "\n";
    
    /**
     * The file chooser.
     */
    private JFileChooser myFilePicker;
    
    /** represents a list of people. */
    private MyPeopleList myList;
    
    /** the panel the list of people resides in. */
    private final ListPanel myListPanel;
    
    /**
     * Main constructor for the listener.
     * @param theListPanel the panel the list resides in.
     */
    public ListSortListener(final ListPanel theListPanel) {
        myListPanel = theListPanel;
        myList = theListPanel.getList();
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Object source = theEvent.getSource();
        if (source.getClass().toString().contains("JButton")) {
            final JButton button = (JButton) source;
            final String buttonText = button.getText();
            if (buttonText.contains("Sort")) {
                sort(button);
            } else if (ADD_PERSON.equalsIgnoreCase(buttonText)) {
                add();
            } else if (REMOVE_PERSON.equalsIgnoreCase(buttonText)) {
                remove();
            } else if (buttonText.contains("Load")) {
                load();
            } else if (buttonText.contains("Random")) {
                displayRandom();
            }
            
        }
        save();
        
    }

    /** Displays a random person on the list. */
    private void displayRandom() {
        final MyPeopleList list = myListPanel.getList();
        final Random r = new Random();
        final int maximum = list.getLength();
        final int randomIndex = r.nextInt(maximum);
        final Person randomPerson = (Person) list.getElementAt(randomIndex);
        final String randomPersonName = randomPerson.getFullName();
        final String randomPersonAddress = randomPerson.getAddress();
        final String randomPersonEmail = randomPerson.getEmail();
        final String phoneString = Integer.toString(randomPerson.getPhone()); 
        final String prefix = phoneString.substring(0, 3);
        final String suffix = phoneString.substring(3, phoneString.length());
        final String fullPhoneString = OPEN_PARENTHESIS + randomPerson.getAreaCode() 
                        + CLOSE_PARENTHESIS + prefix + DASH + suffix; 
        final String stringToDisplay = "A Random Person from the List:" + NEW_LINE
                            + "Name: " + randomPersonName + NEW_LINE
                            + "Address: " + randomPersonAddress + NEW_LINE
                            + "Phone Number: " + fullPhoneString + NEW_LINE
                            + "E-Mail Address: " + randomPersonEmail;
                           
        
        JOptionPane.showMessageDialog(null, stringToDisplay, 
                                      "A Random Person from the List", 
                                      JOptionPane.PLAIN_MESSAGE);
        
    }

    /** saves the most recently updated version of the list to the file it was created from. */
    private void save() {
        final String filePath = myListPanel.getFilePath();
        try {
            final BufferedWriter writer =
                            new BufferedWriter(new FileWriter(filePath));            
            final MyPeopleList list = myListPanel.getList();
            final JTextArea textAreaToWrite = new JTextArea();
            textAreaToWrite.setText("\tName\n\t"
                            + "Street Address\n\t"
                            + "Phone Number\n"
                            + "\tE-Mail Address\n\n\n");
            for (int i = 0; i < list.getLength() - 1; i++) {
                if (list.getElementAt(i) instanceof Person) {
                    final Person person = (Person) list.getElementAt(i);
                    String phoneString = Integer.toString(person.getPhone());
                    final int prefixStart = 0;
                    final int prefixEnd = 3;
                    final int suffixEnd = 7;
                    final String prefix = phoneString.substring(prefixStart, prefixEnd);
                    final String suffix = phoneString.substring(prefixEnd, suffixEnd);
                    phoneString = prefix + DASH + suffix;
                    final String tab = "\t";
                    textAreaToWrite.append(tab + person.getFullName() + NEW_LINE
                                           + tab + person.getAddress() + NEW_LINE
                                           + tab + OPEN_PARENTHESIS 
                                           + person.getAreaCode() 
                                           + CLOSE_PARENTHESIS
                                           + phoneString + NEW_LINE
                                           + tab + person.getEmail() 
                                           + NEW_LINE + NEW_LINE + NEW_LINE);
                }
                
            }
            
            textAreaToWrite.write(writer);
            
            writer.close();
            
            
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
        
    }

    /** 
     * Prompts the user to enter information for a new person.
     */
    private void add() {
        myList = myListPanel.getList();
        try {
            String firstName =
                            (String) JOptionPane.showInputDialog(null,
                            "Enter the first name of the person to be added: ",
                            ADD_PERSON, JOptionPane.PLAIN_MESSAGE, null, null, "");
            firstName = capitalizeFirstLetter(firstName);
            String lastName =
                            (String) JOptionPane.showInputDialog(null,
                            "Enter the last name of the person to be added: ",
                            ADD_PERSON, JOptionPane.PLAIN_MESSAGE, null, null, "");
            lastName = capitalizeFirstLetter(lastName);
            final String address =
                            (String) JOptionPane.showInputDialog(null,
                            "Enter the address of the person to be added: ",
                            ADD_PERSON, JOptionPane.PLAIN_MESSAGE, null, null, "");
            final int areaCode = areaCodeDialog();
            final int phoneNumber = phoneNumberDialog();
            final String email = emailDialog();
            final Person newPerson = new Person(firstName, lastName, areaCode, phoneNumber,
                                          email, address);
            myList.add(newPerson);
            myListPanel.refresh(myList);
            
            
            
        } catch (final NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Add person canceled");
        }
        
        
    }
    
    /**
     * displays a dialog box that collects an email address from the user.
     * @return the email address the user entered
     */
    private String emailDialog() {
        String toReturn = SPACE;
        final String email = (String) JOptionPane.showInputDialog(null,
                        "Enter the  e-mail address of the person to be added: ",
                        ADD_PERSON, JOptionPane.PLAIN_MESSAGE, null, null, "");
        if (!email.contains("@") || !email.contains(".") || email.contains(SPACE)) {
            JOptionPane.showMessageDialog(null, "Invalid E-Mail Address");
        } else {
            toReturn = email;
        }
        
        if (SPACE.equals(toReturn)) {
            emailDialog();
        }
        return toReturn;
    }

    /**
     * displays a dialog box that collects an area code from the user.
     * @return the area code the user entered
     */
    private int areaCodeDialog() {
        int toReturn = 0;
        final int areaCodeLength = 3;
        final String invalidAreaCode = "Invalid Area Code";
        final String areaCode = (String) JOptionPane.showInputDialog(null,
                                   "Enter the area code of the person to be added: ",
                                   ADD_PERSON, JOptionPane.PLAIN_MESSAGE, null, null, "");
        if (areaCode.length() == areaCodeLength) {
            try {

                toReturn = Integer.parseInt(areaCode);
            } catch (final NumberFormatException error) {
                JOptionPane.showMessageDialog(null, invalidAreaCode);
            }
        } else {
            JOptionPane.showMessageDialog(null, invalidAreaCode);
        }

        if (toReturn == 0) {
            areaCodeDialog();
        }
        return toReturn;
    }

    /**
     * displays a dialog box that collects a phone number from the user.
     * @return the phone number the user entered
     */
    private int phoneNumberDialog() {
        final int suffixLength = 4;
        final int prefixLength = 3;
        int toReturn = 0;
        final String invalidPhoneString = "Invalid Phone Number"; 
        final String phoneNumber = (String) JOptionPane.showInputDialog(null,
                                   "Enter the phone number of the person to be added: "
                                   + "\n(Format: XXX-XXXX)",
                                   ADD_PERSON, JOptionPane.PLAIN_MESSAGE, null, null, "");
        if (phoneNumber.contains(DASH)) {
            final String prefix = phoneNumber.substring(0, phoneNumber.indexOf(DASH));
            final String suffix = phoneNumber.substring(phoneNumber.indexOf(DASH) + 1, 
                                                  phoneNumber.length());
            
            if (prefix.length() < prefixLength || suffix.length() < suffixLength) {
                JOptionPane.showMessageDialog(null, invalidPhoneString);
            } else {
                final String fullNumber = prefix + suffix;
                try {
                    toReturn = Integer.parseInt(fullNumber);
                } catch (final NumberFormatException error) {
                    
                    JOptionPane.showMessageDialog(null, invalidPhoneString);
                    toReturn = 0;
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Invalid phone number format");
        }
        if (toReturn == 0) {
            phoneNumberDialog();
        }
        
        return toReturn;
        
    }

    /**
     * Capitalizes the first letter in a string, and sets rest of letters to lower case 
     * or if the string is only one letter, capitalizes it.
     * @param theString the string to be capitalized
     * @return the capitalized string
     */
    private String capitalizeFirstLetter(final String theString) {
        String newString = "";
        if (theString.length() >= 2) {
            newString = theString.substring(0, 1).toUpperCase() 
                            + theString.substring(1, theString.length()).toLowerCase();
        } else {
            newString = theString.toUpperCase(Locale.US);
        }
        return newString;
    }
    /**
     * Sets up the remove option pane.
     */
    private void remove() {
        
        myList = myListPanel.getList();
        String firstName = "";
        String lastName = "";
        final String response = (String) JOptionPane.showInputDialog(null,
                                "Enter the name of the person to be removed: "
                                + "\n(Format: Forename Surname, i.e. \"John Smith\")",
                                REMOVE_PERSON, JOptionPane.PLAIN_MESSAGE, null, null, "");
        if (response.contains(SPACE)) {
            final int length = response.length();
            final int lastCharIndex = length - 1;
            firstName = response.substring(0, response.indexOf(SPACE));
            firstName = capitalizeFirstLetter(firstName);
            lastName = response.substring(response.indexOf(SPACE) + 1, lastCharIndex + 1);
            lastName = capitalizeFirstLetter(lastName);
            final String fullName = firstName + SPACE + lastName;
            if (myList.containsPersonWithName(fullName)) {
                myList.remove(myList.getPersonWithName(fullName));
            } else {
                JOptionPane.showMessageDialog(null, "That person is not in the list.");
            }
            myListPanel.refresh(myList);
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Invalid name");
        }
    }

    /** loads a list into the window. */
    private void load() {
        if (myFilePicker == null) {
            myFilePicker = new JFileChooser();
        }
        final int response = myFilePicker.showOpenDialog(null);
        
        if (response == JFileChooser.APPROVE_OPTION) {
            if (myListPanel.listCheck(myFilePicker.getSelectedFile())) {
                myListPanel.newList(myFilePicker.getSelectedFile());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid File: No list found", 
                                              "Error", JOptionPane.ERROR_MESSAGE, null);
                load();   
            }
        } 
    }

    /** 
     * sorts the data.
     * @param theButton the button that tells how to sort the data.
     */
    private void sort(final JButton theButton) {
        myList = myListPanel.getList();
        final String buttonText = theButton.getText().toLowerCase();
        if (buttonText.contains("name")) {
            if (myList != null) {
                myList.sortByName();
                myListPanel.refresh(myList);
            }
        } else if (buttonText.contains("e-mail")) {
            if (myList != null) {
                myList.sortByEmail();
                myListPanel.refresh(myList);
            }
        } else if (buttonText.contains("phone")) {
            if (myList != null) {
                myList.sortByPhone();
                myListPanel.refresh(myList);
            }
        }
        
        
    }

}
