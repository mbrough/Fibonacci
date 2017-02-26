// Molly Brougham
// Project 2
// CSS 305 A

package view;

import controller.AnimationAction;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Consists of components that allows a user to interact with the Paint++ program.
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class AnimationButtons extends JPanel {

    /** represents the number 0. */
    private static final int ZERO = 0;

    /** represents the number 1. */
    private static final int ONE = 1;

    /** represents the number 2. */
    private static final int TWO = 2;

    /** represents the number 3. */
    private static final int THREE = 3;
    
    /** represents the number 4. */
    private static final int FOUR = 4;
    
    /** represents the play button. */
    private JButton myPlayButton;
    
    /** represents the pause button. */
    private JButton myPauseButton;
    
    /** represents the stop button. */
    private JButton myStopButton;
    
    /** represents the step forward button. */
    private JButton myStepForwardButton;

    /** The array for animation actions. */
    private Action[] myActions;

    /** The art panel the animation buttons affect. */
    private ArtPanel myPanel;

    /** 
     * Main constructor for the animation buttons panel.
     * @param thePanel the Art panel the buttons affect.
     */
    public AnimationButtons(final ArtPanel thePanel) {
        super();
        myPanel = thePanel;
        setUpActions();
        setUpButtons();
        addButtons();
        
        
    }

    /** adds the buttons to the panel. */
    private void addButtons() {

        add(myPlayButton);
        add(myPauseButton);
        add(myStepForwardButton);
        add(myStopButton);
        
    }

    /** sets up the buttons for the panel. */
    private void setUpButtons() {

        myPlayButton = new JButton(myActions[ZERO]);
        myPauseButton = new JButton(myActions[ONE]);
        myStopButton = new JButton(myActions[TWO]);
        myStepForwardButton = new JButton(myActions[THREE]);
        
    }
    
    
    /** 
     * Sets up the actions for tool selection.
     */
    private void setUpActions() {
        myActions = new Action[FOUR];
        myActions[ZERO] = new AnimationAction(myPanel, 
                                                new ImageIcon("images/play.png"));
        myActions[ONE] = new AnimationAction(myPanel,
                                                new ImageIcon("images/pause.png"));
        myActions[TWO] = new AnimationAction(myPanel,
                                                new ImageIcon("images/stop.png"));
        myActions[THREE] = new AnimationAction(myPanel,
                                                new ImageIcon("images/step-forward.png"));

    }
}
