// Molly Brougham
// Project 2
// CSS 305 A

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Contains all the gui components for drawing tools.
 * @author Molly Brougham
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ArtChoices extends JPanel {

    /** The check box that says whether the shape should be filled or not. */
    protected JCheckBox myFillCheckBox;
    
    /** The panel for drawing tools. */
    private final ToolsPanel myTools;

    /** The panel that is affected by tools. */
    private final ArtPanel myArtPanel;

    /** Represents a JButton. */
    private JButton myColorButton;

    /** Represents a JButton. */
    private JButton myBackgroundColorButton;
    
    /** The panel for stroke size. */
    private final StrokeSizePanel myStrokes;

    /** The animation buttons. */
    private AnimationButtons myAnimationButtons;


    /** 
     * Main constructor for the selection components.
     * @param theActions the actions for the toolbar.
     * @param theArtPanel the panel the selections affect.
     */
    public ArtChoices(final Action[] theActions, final ArtPanel theArtPanel) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        myTools = new ToolsPanel(theActions);
        myStrokes = new StrokeSizePanel();
        myArtPanel = theArtPanel;
        myAnimationButtons = new AnimationButtons(theArtPanel);
        setUpButtons();
        addButtons();
        
        
    }
    
    /** 
     * Sets up the components of the window.
     */
    private void setUpButtons() {
        myColorButton = new JButton("Change Tool Color");
        myBackgroundColorButton = new JButton("Change Background Color");
        myFillCheckBox = new JCheckBox("Fill Shape");
        myFillCheckBox.setEnabled(false);
        
        
        final ColorListener colorListener = new ColorListener();
        myColorButton.addActionListener(colorListener);
        myBackgroundColorButton.addActionListener(colorListener);
    }

    /** Adds the buttons to the panel. */
    private void addButtons() {
        final JPanel colorPanel = new JPanel();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Color changing");
        colorPanel.setBorder(title);

        colorPanel.add(myColorButton);
        colorPanel.add(new JLabel(" "));
        colorPanel.add(myBackgroundColorButton);
        
        add(colorPanel);

        final JPanel toolsPanel = new JPanel();
        title = BorderFactory.createTitledBorder("Tools");
        toolsPanel.setBorder(title);
        toolsPanel.add(myTools);
        
        add(colorPanel);
        add(toolsPanel);
        
        final JPanel fillPanel = new JPanel();
        title = BorderFactory.createTitledBorder("Fill");
        fillPanel.setBorder(title);
        add(myStrokes);
        fillPanel.add(myFillCheckBox);
        add(fillPanel);
        
        final JPanel animationPanel = new JPanel();
        title = BorderFactory.createTitledBorder("Animation");
        animationPanel.setBorder(title);
        animationPanel.add(myAnimationButtons);
        add(animationPanel);
        
        final JPanel frameRatePanel = new JPanel();
        title = BorderFactory.createTitledBorder("Frame Rate");
        frameRatePanel.setBorder(title);
        
        final JSlider framesPerSecond = new JSlider(JSlider.HORIZONTAL,
                                              0, 30, 15);
        
        final FrameRateListener frameRateListener = new FrameRateListener();
        framesPerSecond.addChangeListener(frameRateListener);
        final int majorTicks = 10;        
        framesPerSecond.setMajorTickSpacing(majorTicks);
        framesPerSecond.setPaintTicks(true);
        framesPerSecond.setPaintLabels(true);
        

        frameRatePanel.add(framesPerSecond);
        add(frameRatePanel);
    }
    
    /**
     * Sets the fill check box to be enabled or disabled.
     * @param theFlag whether or not the check box should be enabled.
     */
    public void enableCheckBox(final boolean theFlag) {
        myFillCheckBox.setEnabled(theFlag);
    }

    /**
     * Returns whether the shape should be filled based on selection of checkbox. 
     * @return whether the shape should be filled or not.
     */
    public boolean shouldShapeBeFilled() {
        boolean flag = false;
        if (myFillCheckBox.isEnabled()) {
            flag = myFillCheckBox.isSelected();
        }
        return flag;
    }
    
    /** 
     * returns the selected thickness.
     * @return the selected thickness.
     */
    public int getThickness() {
        return myStrokes.getThickness();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /** An inner class to handle button clicks on the color chooser buttons. */
    protected class ColorListener implements ActionListener {

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            final Color color = JColorChooser.showDialog(ArtChoices.this, 
                                                   "Choose a color", Color.BLACK);
            final Object source = theEvent.getSource();
            JButton button = new JButton();
            if (source instanceof JButton) {
                button = (JButton) source;
                if (button.getText().contains("ool")) {
                    myArtPanel.setToolColor(color);
                } else {
                    myArtPanel.setBackground(color);
                }
            }
        }
        
    }
    
    /** A private class to listen to changes in the FPS slider. */
    private class FrameRateListener implements ChangeListener {

        @Override
        public void stateChanged(final ChangeEvent theEvent) {
            final JSlider slider = (JSlider) theEvent.getSource();
            final int fps = (int) slider.getValue();
            myArtPanel.setFPS(fps);
        }
        
    }

}
