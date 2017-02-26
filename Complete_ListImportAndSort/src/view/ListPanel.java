/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package view;

import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.DataReader;
import model.MyPeopleList;

/**
 * A class to display the list.
 * @author Molly Brougham
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ListPanel extends JPanel {
    
    /** the width of the border for the text area. */
    private static final int BORDER = 10;
    
    /** Represents the text for the total label. */
    private static final String LIST_TOTAL = "List Total: ";
    
    /** the text within the list panel. */
    private JTextArea myText;
    
    /** represents a data reader. */
    private DataReader myDataReader;

    /** represents a list of data. */
    private MyPeopleList myList;
    
    /** The panel that holds the label that displays the total. */
    private JPanel myTotalPanel;
    
    /** the label that displays the total. */
    private JLabel myTotalLabel;

    /** the total number of people in the list. */
    private int myTotal;

    /** The scrollable text panel. */
    private JScrollPane myScroll;

    /** The file the listpanel is displaying. */
    private File myFile;
    
    /** Default constructor. */
    public ListPanel() {
        super();
        initalizeFields();
        myText.setEditable(false);
        
        myScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setUpTotalPanel();
        setLayoutAndBorder();
        addElements();
    }
    
    /** initializes the fields for the list panel. */
    private void initalizeFields() {
        myDataReader = new DataReader();
        myText = new JTextArea();
        myTotalLabel = new JLabel();
        myScroll = new JScrollPane(myText);
        myFile = new File("alist.txt");
        displayList(myFile);
        
        myTotal = myList.getLength();
        
    }

    /** Sets up the layout and border of the list panel. */
    private void setLayoutAndBorder() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(BORDER, BORDER, BORDER, BORDER));
        
    }

    /** Adds the scrollable text panel and the totals label panel to the window. */
    private void addElements() {
        myTotal = myList.getLength(); 
        add(myScroll);
        add(myTotalPanel); 
    }

    /** 
     * Sets up the total panel for the window.
     */
    private void setUpTotalPanel() {
        myTotalPanel = new JPanel();
        myTotalLabel.setText(LIST_TOTAL + myTotal);
        myTotalPanel.setLayout(new BoxLayout(myTotalPanel, BoxLayout.X_AXIS));
        myTotalPanel.add(myTotalLabel);
        myTotalPanel.add(Box.createHorizontalGlue());
        
    }
    
    /** 
     * displays the list from a specified file.
     * @param theFile the file with the list to be displayed.
     */
    public void displayList(final File theFile) {
        clear();
        myFile = theFile;
        myDataReader.readFile(theFile);
        myDataReader.makeList();
        myText.setText(myDataReader.getList().toString());
        myList = myDataReader.getList();
        
    }

    /**
     * Checks whether the file is a list of people.
     * @param theFile the file to be checked.
     * @return true if the file is a list of people, false if it is invalid.
     */
    public boolean listCheck(final File theFile) {
        return myDataReader.checkFile(theFile);
    }

    /** clears the text area. */
    public void clear() {
        if (myText == null) {
            myText = new JTextArea();
        }
        myText.setText("");
        
    }

    /**
     * refreshes the data in the list panel with a given list.
     * @param theList the list to display.
     */
    public void refresh(final MyPeopleList theList) {
        myList = theList;
        myText.setText(theList.toString());
        myTotal = myList.getLength();
        myTotalLabel.setText(LIST_TOTAL + myTotal);
    }
    
    /** 
     * returns the list displayed.
     * @return the list of people displayed.
     */
    public MyPeopleList getList() {
        return myList;
    }

    /**
     * creates a new list from the given file.
     * @param theFile the file to make a list out of.
     */
    public void newList(final File theFile) {
        myFile = theFile;
        myList.clear();
        myDataReader = new DataReader();
        myDataReader.readFile(theFile);
        myDataReader.makeList();
        myList = myDataReader.getList();
        myText.setText(myList.toString());
        myDataReader.getList();
        refresh(myList);
        
    }

    /** 
     * Returns the path to the current file displayed.
     * @return the path of the file currently displayed
     */
    public String getFilePath() {
        return myFile.getPath();
        
    }
    
    /**
     * returns the JTextArea the list is displayed in.
     * @return the JTextArea the list is displayed in.
     */
    public JTextArea getTextArea() {
        return myText;
    }
}