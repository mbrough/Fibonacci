/**
 * 
 */
package gui;

import javax.swing.Action;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 * Represents a pop-up menu.
 * @author Monika
 * @version Winter 2014
 */
@SuppressWarnings("serial")
public class PopupMenu extends JPopupMenu {

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
     * menu item yellow.
     */
    private final JMenuItem myYellow;
    
    /**
     * menu item blue.
     */
    private final JMenuItem myBlue;
    
    /**
     * menu item red.
     */
    private final JMenuItem myRed;
    
    /**
     * menu item green.
     */
    private final JMenuItem myGreen;
    
    /**
     * constructs a popup menu.
     * @param theActions 
     * @custom.post popup menu with all components created
     */
    public PopupMenu(final Action[] theActions) {
        super();
        // create menu items
        myBlue = new JMenuItem(theActions[ZERO]);
        myRed = new JMenuItem(theActions[ONE]);
        myYellow = new JMenuItem(theActions[TWO]);
        myGreen = new JMenuItem(theActions[THREE]);
           
     
        // add menu items to popup
        
        addNames();
        
        add(myBlue);
        add(myYellow);
        add(myRed);
        add(myGreen);
        
    }
    /**
     * adds names and tooltips to popup menu items.
     * @custom.post names and tooltips added to a popup menu
     */
    private void addNames() {
        // to fill
        myYellow.setName("Yellow");
        myRed.setName("Red");
        myBlue.setName("Blue");
        myGreen.setName("Green");
    }
    
}
