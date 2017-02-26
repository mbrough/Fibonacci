// Molly Brougham
// Project 2
// CSS 305 A

package view;

import javax.swing.Action;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * The toolbar for the paint++ program.
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ToolsPanel extends JPanel {
    /** represents the text for the pencil tool tip. */
    private static final String PENCIL = "Pencil Tool";
    
    /** represents the text for the square tool tip. */
    private static final String SQUARE = "Square Tool";
    
    /** represents the text for the line tool tip. */
    private static final String LINE = "Line Tool";
    
    /** represents the text for the circle tool tip. */
    private static final String CIRCLE = "Circle Tool";
    
    /** represents the number 0. */
    private static final int ZERO = 0;
    
    /** represents the number 1. */
    private static final int ONE = 1;
    
    /** represents the number 2. */
    private static final int TWO = 2;
    
    /** represents the number 3. */
    private static final int THREE = 3;

    /** The pencil tool button. */
    private final JToggleButton myPencilButton;
    
    /** The square tool button. */
    private final JToggleButton mySquareButton;
    
    /** The circle tool button. */
    private final JToggleButton myCircleButton;
    
    /** The line tool button. */
    private final JToggleButton myLineButton;
    
    /** represents a button group. */
    private final ButtonGroup myGroup;


    /**
     * main constructor for the toolbar.
     * @param theActions the actions for the tools
     */
    public ToolsPanel(final Action[] theActions) {
        super();
        myGroup = new ButtonGroup();

        myPencilButton = new JToggleButton(theActions[ZERO]);
        mySquareButton = new JToggleButton(theActions[ONE]);
        myCircleButton = new JToggleButton(theActions[TWO]);
        myLineButton = new JToggleButton(theActions[THREE]);

        addButtons();

    }

    /**
     * Sets up and adds the buttons to the toolbar.
     */
    private void addButtons() {

        // set names, tooltips, add buttons to a group
        setToolTips();
        
        setNames();
        
        setSizes();
        
        myGroup.add(myPencilButton);
        myGroup.add(mySquareButton);
        myGroup.add(myCircleButton);
        myGroup.add(myLineButton);

        final Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(myPencilButton);
        horizontalBox.add(mySquareButton);
        horizontalBox.add(myCircleButton);
        horizontalBox.add(myLineButton);

        add(horizontalBox);

    }
    
    /** sets up the preferred, maximum, and minimum sizes for the buttons. */
    private void setSizes() {
        myPencilButton.setPreferredSize(mySquareButton.getPreferredSize());
        myPencilButton.setMaximumSize(mySquareButton.getMaximumSize());
        myPencilButton.setMinimumSize(mySquareButton.getMinimumSize());
        
        myCircleButton.setPreferredSize(mySquareButton.getPreferredSize());
        myCircleButton.setMaximumSize(mySquareButton.getMaximumSize());
        myCircleButton.setMinimumSize(mySquareButton.getMinimumSize());
        
        myLineButton.setPreferredSize(mySquareButton.getPreferredSize());
        myLineButton.setMaximumSize(mySquareButton.getMaximumSize());
        myLineButton.setMinimumSize(mySquareButton.getMinimumSize());
        
    }

    /** sets up button names for each button. */
    private void setNames() {
        myPencilButton.setName(PENCIL);
        mySquareButton.setName(SQUARE);
        myCircleButton.setName(CIRCLE);
        myLineButton.setName(LINE);
        
    }

    /** sets up tooltips for each button. */
    private void setToolTips() {
        myPencilButton.setToolTipText(PENCIL);
        mySquareButton.setToolTipText(SQUARE);
        myLineButton.setToolTipText(LINE);
        myCircleButton.setToolTipText(CIRCLE);
        
    }

}
