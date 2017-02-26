// Molly Brougham
// Project 2
// CSS 305 A

package view;

import controller.ToolSelectionAction;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Creates, displays, and combines all GUI components.
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ArtFrame extends JFrame {

    /** The default width of the window. */
    private static final int DEFAULT_WIDTH = (int) (0.8 
                    * Toolkit.getDefaultToolkit().getScreenSize().getWidth());

    /** The default height of the window. */
    private static final int DEFAULT_HEIGHT = (int) (0.8 
                    * Toolkit.getDefaultToolkit().getScreenSize().getHeight());

    /** The default dimension of the window. */
    private static final Dimension DEFAULT_SIZE = 
                    new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    /** Represents the number 0. */
    private static final int ZERO = 0;

    /** Represents the number 1. */
    private static final int ONE = 1;

    /** Represents the number 2. */
    private static final int TWO = 2;

    /** Represents the number 3. */
    private static final int THREE = 3;

    /** Represents the number 4. */
    private static final int FOUR = 4;

    /** The main panel used in the program. */
    private final ArtPanel myArtPanel;

    /** The actions for tool selection. */
    private Action[] myActions;

    /** Represents art choices. */
    private ArtChoices myArtChoices;

    /** represents a menu bar for the frame. */
    private ArtMenuBar myArtMenuBar;

    /** Main constructor. */
    public ArtFrame() {
        super("Paint++");
        myArtPanel = new ArtPanel(this);
        
        setUpActions();
        setUpFrame();
        addElements();

        pack();

    }

    /** 
     * Adds the elements of the frame.
     */
    private void addElements() {
        myArtMenuBar = new ArtMenuBar(this);
        add(myArtMenuBar, BorderLayout.NORTH);
        final JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(FOUR + 1, FOUR + 1, FOUR + 1, FOUR + 1));
        panel.setLayout(new BorderLayout());
        panel.add(myArtPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
        final JPanel toolsPanel = new JPanel();
        toolsPanel.setLayout(new FlowLayout());
        myArtChoices = new ArtChoices(myActions, myArtPanel);
        toolsPanel.add(myArtChoices, BorderLayout.WEST);
        add(toolsPanel, BorderLayout.SOUTH);
        
    }

    /**
     * Sets up the frame settings.
     */
    private void setUpFrame() {
        setLayout(new BorderLayout());
        setPreferredSize(DEFAULT_SIZE);
        setSize(DEFAULT_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    /** 
     * returns the selected animation style.
     * @return the selected animation style.
     */
    public String getAnimationStyle() {
        return myArtMenuBar.getAnimationStyle();
    }
    

    /** 
     * Sets up the actions for tool selection.
     */
    private void setUpActions() {
        final Action[] actions = new Action[FOUR];
        actions[ZERO] = new ToolSelectionAction(myArtPanel, 
                                                new ImageIcon("images/pencil.png"));
        actions[ONE] = new ToolSelectionAction(myArtPanel,
                                                new ImageIcon("images/square.png"));
        actions[TWO] = new ToolSelectionAction(myArtPanel,
                                                new ImageIcon("images/ellipse.png"));
        actions[THREE] = new ToolSelectionAction(myArtPanel,
                                                new ImageIcon("images/line.png"));
        myActions = actions;

    }
    
    /**
     * Returns the art choices panel.
     * @return the art choices panel
     */
    public ArtChoices getArtChoices() {
        return myArtChoices;
    }

    /** returns the art panel in the frame. 
     * @return the art panel in the frame.
     */
    public ArtPanel getPanel() {
        return myArtPanel;        
    }
    
}
