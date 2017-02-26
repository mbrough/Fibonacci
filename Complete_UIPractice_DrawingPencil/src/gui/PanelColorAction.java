package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * TODO text.
 * @author nelsom6
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class PanelColorAction extends AbstractAction {

    /** represents the text for the name of the panel. */
    private static final String MY_PANEL = "myPanel";
    
    /** represents the text for the name of the color. */
    private static final String MY_COLOR = "color";
    
    
    /**
     * Constructor.
     * @param thePanel the JPanel to be colored by the action.
     * @param theIcon the icon for the color.
     * @param theColor the name of the color.
     */
    PanelColorAction(final JPanel thePanel, final ImageIcon theIcon, final Color theColor) {
        super();
        putValue(MY_PANEL, thePanel);
        putValue(Action.SMALL_ICON, theIcon);
        putValue(MY_COLOR, theColor);
    }
    
    
    
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final PaintPanel panel = (PaintPanel) getValue(MY_PANEL);
        final Color color = (Color) getValue(MY_COLOR);
        panel.setBackground(color);
        putValue(Action.SELECTED_KEY, true);
        
    }

    
    
}
