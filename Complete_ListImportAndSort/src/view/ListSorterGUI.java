/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

/**
 * The main GUI components for the list sorter program.
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
public class ListSorterGUI {
    
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /** The default width of the window. */
    private static final int WINDOW_WIDTH = (int) (SCREEN_SIZE.width * 0.5);
    
    /** The default height of the window. */
    private static final int WINDOW_HEIGHT = (int) (SCREEN_SIZE.height * 0.5);
    
    /** the main jframe for the gui. */
    private final JFrame myGUIFrame;
    
    /** the JPanel on the right of the window, holds buttons. */
    private JPanel myRightPanel;
    
    /** represents a list panel. */
    private final ListPanel myListPanel;
    
    
//    /** represents the list of people to be displayed. */
//    private MyPeopleList myList;
    
    /**
     * Constructor for the list sorter gui.
     */
    public ListSorterGUI() {
        myGUIFrame = new JFrame("List Sorter");
                
        myListPanel = new ListPanel();

        final ButtonPanel buttonPanel = new ButtonPanel(myListPanel);
        
        setUpRightPanel(buttonPanel);
        
        addPanels(myRightPanel);
        
        myGUIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myGUIFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        myGUIFrame.setLayout(new BoxLayout(myGUIFrame.getContentPane(), 
                                           BoxLayout.LINE_AXIS));
        myGUIFrame.setVisible(true);
    }
    
    /**
     * Sets up the right panel to hold buttons.
     * @param theButtonPanel the panel of buttons for the right panel
     */
    private void setUpRightPanel(final ButtonPanel theButtonPanel) {
        final int border = 10; 
        myRightPanel = new JPanel();
        myRightPanel.setLayout(new BoxLayout(myRightPanel, BoxLayout.Y_AXIS));
        
        myRightPanel.add(theButtonPanel);
        myRightPanel.add(Box.createVerticalGlue());

        myRightPanel.add(Box.createVerticalGlue());
        myRightPanel.setBorder(new EmptyBorder(0, 0, 0, border));
    }

    /**
     * Adds the panels for the gui into the frame.
     * @param theRightPanel the button panel to be added to the frame.
     */
    public void addPanels(final JPanel theRightPanel) {
        myGUIFrame.add(myListPanel);
        myGUIFrame.add(theRightPanel);
    }
    
    /** 
     * returns the list panel in the window.
     * @return the list panel.
     */
    public ListPanel getListPanel() {
        return myListPanel;
    }
    
    
}
