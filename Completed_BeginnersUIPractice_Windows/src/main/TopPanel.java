
package main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The top panel of the store front window, displays title.
 * 
 * @author Molly Brougham
 * @version 1.0
 */
@SuppressWarnings("serial")
public class TopPanel extends JPanel {

    /**
     * Label font size.
     */
    private static final int TITLE_FONT_SIZE = 20;

    /**
     * The title of the window.
     */
    private static final JLabel TITLE_LABEL =
                    new JLabel("Welcome to Molly's Ice-Cream Parlor!");

    /**
     * Constructor for the top panel.
     */
    public TopPanel() {
        
        super();

        // adds label with specific text, font, and color
        TITLE_LABEL.setFont(new Font("Serif", Font.BOLD, TITLE_FONT_SIZE));
        TITLE_LABEL.setForeground(Color.BLUE);

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalGlue());
        add(TITLE_LABEL);
        add(Box.createHorizontalGlue());
    }

}
