package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * A frame with the components for the store front.
 * @author Molly Brougham
 * @version 1.0
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame {    

    /**
     * A center panel for the frame.
     */
    private final CenterPanel myCenterPanel;

    /**
     * A south panel for the frame.
     */
    private final SouthPanel mySouthPanel;
    
    /**
     * A top panel for the frame.
     */
    private final TopPanel myTopPanel;
    
    /**
     * MainFrame constructor that creates the GUI.
     */
    public MainFrame() {
        super();
        
        //sets up the panels
        myTopPanel = new TopPanel();
        myCenterPanel = new CenterPanel();
        mySouthPanel = new SouthPanel();
        
        buildGUI();
        
    }
    
    /**
     * Builds the GUI for the frame.
     */
    private void buildGUI() {

        //adds top panel to the frame
        add(myTopPanel, BorderLayout.NORTH);
        
        //adds center panel to frame
        add(myCenterPanel, BorderLayout.CENTER);
        
        //adds south panel to frame
        add(mySouthPanel, BorderLayout.SOUTH);
        
        pack();
    }
}
