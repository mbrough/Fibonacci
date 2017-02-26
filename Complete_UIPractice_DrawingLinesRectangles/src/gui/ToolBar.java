/*
 * TCSS 305
 */

package gui;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * The JToolBar for this GUI example.
 * 
 * @author Cay Horstman modified
 * @version Autumn 2013
 */
@SuppressWarnings("serial")
public class ToolBar extends JToolBar {

    /**
     * represents the integer 0.
     */
    private static final int ZERO = 0;

    /**
     * represents the integer 1.
     */
    private static final int ONE = 1;

    /**
     * represents the integer 2.
     */
    private static final int TWO = 2;

    /**
     * represents the integer 3.
     */
    private static final int THREE = 3;
    

    /**
     * represents the name of the color green.
     */
    private static final String GREEN = "Green";

    /**
     * represents the name of the color yellow.
     */
    private static final String YELLOW = "Yellow";

    /**
     * represents the name of the color blue.
     */
    private static final String BLUE = "Blue";

    /**
     * represents the name of the color red.
     */
    private static final String RED = "Red";

    /** A button group for the mutually exclusive tool bar buttons. */
    private final ButtonGroup myGroup;
    
    /**
     * red toolbar button.
     */
    private final JToggleButton myRedButton;
    
    /**
     * blue toolbar button.
     */
    private final JToggleButton myBlueButton;
    
    /**
     * yellow toolbar button.
     */
    private final JToggleButton myYellowButton;
    
    /**
     * green toolbar button.
     */
    private final JToggleButton myGreenButton;

    
    
    /**
     * Construct the ToolBar.
     * @param theActions text.
     * @custom.post toolbar with all its components created
     */
    public ToolBar(final Action[] theActions) {
        super("Colors");
        
        myGroup = new ButtonGroup();
       // create buttons     
        myBlueButton = new JToggleButton(theActions[ZERO]);
        myRedButton = new JToggleButton(theActions[ONE]);
        myYellowButton = new JToggleButton(theActions[TWO]);
        myGreenButton = new JToggleButton(theActions[THREE]);

        
        addButtons();
    }
    
    /**
     * Adds buttons to a group and assigns names and tooltips to the toolbar items.
     * @custom.post buttons added to the toobar, each one with a name and a tooltip
     */
    private void addButtons() {
        
        // set names, tooltips, add buttons to a group
        myRedButton.setToolTipText(RED);
        myBlueButton.setToolTipText(BLUE);
        myYellowButton.setToolTipText(YELLOW);
        myGreenButton.setToolTipText(GREEN);
        
        myRedButton.setName(RED);
        myBlueButton.setName(BLUE);
        myYellowButton.setName(YELLOW);
        myGreenButton.setName(GREEN);
                
        myGroup.add(myRedButton);
        myGroup.add(myBlueButton);
        myGroup.add(myYellowButton);
        myGroup.add(myGreenButton);
        
        add(myRedButton);
        add(myBlueButton);
        add(myYellowButton);
        add(myGreenButton);
        
    }
    
    

}
