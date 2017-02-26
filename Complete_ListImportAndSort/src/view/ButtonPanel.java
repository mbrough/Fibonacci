/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package view;

import controller.ListSortListener;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


/**
 * Holds components of the GUI.
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ButtonPanel extends JPanel {
    /** an empty String. */
    private static final String EMPTY_STRING = " ";
    
    /** The size of the border. */
    private static final int BORDER_SIZE = 10;
    
    /** The number of buttons within the panel. */
    private static final int NUMBER_OF_BUTTONS = 7;
        
    /** The load button. */
    private JButton myLoadButton;
    
    /** The alphabetical sort button. */
    private JButton myNameSortButton;
    
    /** The e-mail address sort button. */
    private JButton myAddressSortButton;
    
    /** The phone number sort button. */
    private JButton myPhoneSortButton;
    
    /** The add person button. */
    private JButton myAddButton;
    
    /** The remove person button. */
    private JButton myRemoveButton;
    
    /** The random selection button. */
    private JButton myRandomButton;
    
    /** the event listener for the buttons. */
    private final ListSortListener myListener;


    /**
     * Main constructor for the button panel.
     * @param theListPanel the panel that the list of people resides in.
     */
    public ButtonPanel(final ListPanel theListPanel) {
        super();
        myListener = new ListSortListener(theListPanel);
        
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setUpButtons();
    
        final int maxWidth = 200;
        
        final int maxHeight = 
                        myAddressSortButton.getPreferredSize().height 
                        * (NUMBER_OF_BUTTONS + 2);
        
        setMaximumSize(new Dimension(maxWidth, maxHeight));
    }



    /** Instantiates the buttons. */
    private void setUpButtons() {
        myLoadButton = new JButton();
        myNameSortButton = new JButton();
        myAddressSortButton = new JButton();
        myPhoneSortButton = new JButton();
        myAddButton = new JButton();
        myRemoveButton = new JButton();
        myRandomButton = new JButton();
        setButtonText();
        setButtonSize();
        setActionListener();
        addButtons();
        
        this.setBorder(new EmptyBorder(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, 0));
    }
    
    /** Sets the size of the buttons. */
    private void setButtonSize() {
        myLoadButton.setPreferredSize(myAddressSortButton.getPreferredSize());
        myLoadButton.setMaximumSize(myAddressSortButton.getMaximumSize());
        myLoadButton.setMinimumSize(myAddressSortButton.getMinimumSize());
                
        myPhoneSortButton.setPreferredSize(myAddressSortButton.getPreferredSize());
        myPhoneSortButton.setMaximumSize(myAddressSortButton.getMaximumSize());
        myPhoneSortButton.setMinimumSize(myAddressSortButton.getMinimumSize());
        
        myNameSortButton.setPreferredSize(myAddressSortButton.getPreferredSize());
        myNameSortButton.setMaximumSize(myAddressSortButton.getMaximumSize());
        myNameSortButton.setMinimumSize(myAddressSortButton.getMinimumSize());
       
        myAddButton.setPreferredSize(myAddressSortButton.getPreferredSize());
        myAddButton.setMaximumSize(myAddressSortButton.getMaximumSize());
        myAddButton.setMinimumSize(myAddressSortButton.getMinimumSize());
        
        myRemoveButton.setPreferredSize(myAddressSortButton.getPreferredSize());
        myRemoveButton.setMaximumSize(myAddressSortButton.getMaximumSize());
        myRemoveButton.setMinimumSize(myAddressSortButton.getMinimumSize());
        
        myRandomButton.setPreferredSize(myAddressSortButton.getPreferredSize());
        myRandomButton.setMaximumSize(myAddressSortButton.getMaximumSize());
        myRandomButton.setMinimumSize(myAddressSortButton.getMinimumSize());
    }

    /** Sets the text for the JButtons. */
    private void setButtonText() {
        myLoadButton.setText("Load data...");
        myNameSortButton.setText("Sort by Last Name");
        myAddressSortButton.setText("Sort by E-Mail Address");
        myPhoneSortButton.setText("Sort by Phone Number");
        myAddButton.setText("Add Person");
        myRemoveButton.setText("Remove Person");
        myRandomButton.setText("List Random Person");
    }
    
    /** Adds the buttons to the panel. */
    private void addButtons() {
        add(myLoadButton);
        add(Box.createVerticalGlue());
        add(new JLabel(EMPTY_STRING));
        add(Box.createVerticalGlue());
        add(myNameSortButton);
        add(Box.createVerticalGlue());
        add(myAddressSortButton);
        add(Box.createVerticalGlue());
        add(myPhoneSortButton);
        add(Box.createVerticalGlue());
        add(new JLabel(EMPTY_STRING));
        add(Box.createVerticalGlue());
        add(myAddButton);
        add(Box.createVerticalGlue());
        add(myRemoveButton);
        add(Box.createVerticalGlue());
        add(new JLabel(EMPTY_STRING));
        add(myRandomButton);
        add(Box.createVerticalGlue());
    }
    
    /**
     * Returns the width of the buttons.
     * @return the button width.
     */
    public int getButtonWidth() {
        return myAddressSortButton.getPreferredSize().width;
    }
    
    /**
     * returns the height of the button.
     * @return the button height.
     */
    public int getButtonHeight() {
        return myAddressSortButton.getPreferredSize().height;
    }
    
    /** sets the action listeners for the buttons. */
    private void setActionListener() {
        myLoadButton.addActionListener(myListener);
        myNameSortButton.addActionListener(myListener);
        myAddressSortButton.addActionListener(myListener);
        myPhoneSortButton.addActionListener(myListener);
        myAddButton.addActionListener(myListener);
        myRemoveButton.addActionListener(myListener);
        myRandomButton.addActionListener(myListener);
    }
    

}
