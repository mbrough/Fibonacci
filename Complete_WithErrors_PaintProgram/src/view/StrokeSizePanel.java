// Molly Brougham
// Project 2
// CSS 305 A

package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 * Holds the components for the stroke size selection panel.
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class StrokeSizePanel extends JPanel {
    
    /** represents the number 2. */
    private static final int TWO = 2;

    /** represents the number 3. */
    private static final int THREE = 3;

    /** represents the number 4. */
    private static final int FOUR = 4;

    /** represents the number 2. */
    private static final int FIVE = 5;
    
    /** Represents the first stroke radio button. */
    private JRadioButton myStrokeOneButton;
    
    /** Represents the second stroke radio button. */
    private JRadioButton myStrokeTwoButton;
    
    /** Represents the third stroke radio button. */
    private JRadioButton myStrokeThreeButton;
    
    /** Represents the fourth stroke radio button. */
    private JRadioButton myStrokeFourButton;
    
    /** Represents the fifth stroke radio button. */
    private JRadioButton myStrokeFiveButton;
    
    /**
     * Main constructor for the panel.
     */
    public StrokeSizePanel() {
        super();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Stroke Size");
        setLayout(new GridLayout(TWO, FIVE));
        setBorder(title);
        setUpButtons();
        addButtons();
        addIcons();
    }

    /** adds the icons for the stroke sizes to the panel. */
    private void addIcons() {
        final JLabel one = new JLabel(new ImageIcon("images/strokeOne.png"));
        add(one);
        final JLabel two = new JLabel(new ImageIcon("images/strokeTwo.png"));
        add(two);
        final JLabel three = new JLabel(new ImageIcon("images/strokeThree.png"));
        add(three);
        final JLabel four = new JLabel(new ImageIcon("images/strokeFour.png"));
        add(four);
        final JLabel five = new JLabel(new ImageIcon("images/strokeFive.png"));
        add(five);
    }

    /**
     * Adds the buttons to the panel.
     */
    private void addButtons() {
        add(myStrokeOneButton);
        add(myStrokeTwoButton);
        add(myStrokeThreeButton);
        add(myStrokeFourButton);
        add(myStrokeFiveButton);
        
    }

    /**
     * Sets up the buttons for the panel.
     */
    private void setUpButtons() {
        myStrokeOneButton = new JRadioButton();
        myStrokeOneButton.setSelected(true);
        myStrokeTwoButton = new JRadioButton();
        myStrokeThreeButton = new JRadioButton();
        myStrokeFourButton = new JRadioButton();
        myStrokeFiveButton = new JRadioButton();
        
        final ButtonGroup group = new ButtonGroup();
        group.add(myStrokeOneButton);
        group.add(myStrokeTwoButton);
        group.add(myStrokeThreeButton);
        group.add(myStrokeFourButton);
        group.add(myStrokeFiveButton);
    }

    /** 
     * returns which thickness of stroke is selected.
     * @return which thickness of stroke is selected
     */
    public int getThickness() {
        int size = 0;
        if (myStrokeOneButton.isSelected()) {
            size = 1;
        } else if (myStrokeTwoButton.isSelected()) {
            size = TWO;
        } else if (myStrokeThreeButton.isSelected()) {
            size = THREE;
        } else if (myStrokeFourButton.isSelected()) {
            size = FOUR;
        } else if (myStrokeFiveButton.isSelected()) {
            size = FIVE;
        }
        return size;
    }

}
