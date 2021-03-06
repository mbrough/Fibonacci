/*
 * TCSS 305
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;

/**
 * The Graphical User Interface for this example program.
 * 
 * @author Monika Sobolewska
 * @version Autumn 2013
 */
public class GUI {
    
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /** The width of the screen. */
    private static final int SCREEN_WIDTH = (int) (SCREEN_SIZE.width * 0.85);
    
    /** The height of the screen. */
    private static final int SCREEN_HEIGHT = (int) (SCREEN_SIZE.height * 0.85);
    
    /** The default size for this JPanel. */
    private static final Dimension DEFAULT_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

    /** 
     * represents a frame.
     */
    private final JFrame myGuiFrame;

    /**
     * represents a top-level menu.
     */
    private final MenuBar myMenuBar;
       
    /**
     * text component.
     */
    private MyDocument myDocument;
   
 
    /**
     * Construct the GUI.
     */
    public GUI() {
              
        myGuiFrame = new JFrame("MyPad");
                
        myDocument = new MyDocument(DEFAULT_SIZE);
        
        myMenuBar = new MenuBar(myDocument);
        
        myGuiFrame.setJMenuBar(myMenuBar);
        // the_frame.add(menu_bar, BorderLayout.NORTH); // DONT DO THIS!
        
        final Box boxLayout = Box.createVerticalBox();
        boxLayout.add(myDocument);
        
        myGuiFrame.add(myDocument, BorderLayout.WEST);
        
        myGuiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myGuiFrame.pack();
        myGuiFrame.setLocationRelativeTo(null);
        myGuiFrame.setVisible(true);
    }  
}