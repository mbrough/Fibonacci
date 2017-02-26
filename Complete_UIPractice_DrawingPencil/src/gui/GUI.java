/*
 * TCSS 305
 */

package gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


/**
 * The Graphical User Interface for this example program.
 * 
 * @author Monika Sobolewska
 * @version Winter 2014
 */
public class GUI {

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
     * represents the integer 4.
     */
    private static final int FOUR = 4;
    
    /** 
     * represents a frame.
     */
    private final JFrame myGuiFrame;

    /**
     * represents a top-level menu.
     */
    private final MenuBar myMenuBar;
    
    /** 
     * represents a toolbar.
     */
    private final ToolBar myToolBar;
    
    /**
     * represents a panel.
     */
    private final PaintPanel myPanel;
    
    /**
     * represents a popup menu.
     */
    private final PopupMenu myPopup;

    /**
     * represents an array of Actions.
     */
    private Action[] myActions;

    /**
     * Construct the GUI.
     * @custom.post GUI frame with all components
     */
    public GUI() {
        myGuiFrame = new JFrame("ToolBar and MenuBar Example");
        myMenuBar = new MenuBar();
        myPanel = new PaintPanel();
     
        setUpActions();
        
        myToolBar = new ToolBar(myActions);
        myPopup = new PopupMenu(myActions);

        setupMenus();
    }
    /**
     * Sets up the frame and adds menus.
     * @custom.post frame with menus visible
     */
    private void setupMenus() {
        myGuiFrame.setJMenuBar(myMenuBar);
        // the_frame.add(menu_bar, BorderLayout.NORTH); // DONT DO THIS!
        
        myGuiFrame.add(myToolBar, BorderLayout.SOUTH);
        myGuiFrame.add(myPanel, BorderLayout.CENTER);
        myPanel.setComponentPopupMenu(myPopup);
        
        myGuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGuiFrame.pack();
        myGuiFrame.setLocationRelativeTo(null);
        myGuiFrame.setVisible(true);
    }
    
    /**
     * sets up the action array.
     */
    private void setUpActions() {

        final Action[] actions = new Action[FOUR];
        actions[ZERO] = new PanelColorAction(myPanel, new ImageIcon("blue-ball.gif"), 
                                            Color.BLUE);
        actions[ONE] = new PanelColorAction(myPanel, new ImageIcon("red-ball.gif"), 
                                              Color.RED);
        actions[TWO] = new PanelColorAction(myPanel, new ImageIcon("yellow-ball.gif"), 
                                            Color.YELLOW);
        actions[THREE] = new PanelColorAction(myPanel, new ImageIcon("greenball.gif"), 
                                                Color.GREEN);   
        
        myActions = actions;
    }
}
