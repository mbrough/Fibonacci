// Molly Brougham
// Project 2
// CSS 305 A

package controller;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import view.ArtFrame;
import view.ArtPanel;

/**
 * Sets up actions for the tool selection buttons.
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ToolSelectionAction extends AbstractAction {
    
    /** represents the text for the name of the pencil tool. */
    protected static final String PENCIL = "pencil";
    
    /** represents the text for the name of the square tool. */
    protected static final String SQUARE = "square";
    
    /** represents the text for the name of the ellipse tool. */
    protected static final String ELLIPSE = "ellipse";
    
    /** represents the text for the name of the line tool. */
    protected static final String LINE = "line";
    
    /** represents the text for the name of the panel. */
    private static final String MY_PANEL = "myPanel";

    /** The panel being edited. */
    private final ArtPanel myPanel;

    /** The icon file path of the selected tool. */
    private String myIconFilePath;

    /** represents an art frame. */
    private final ArtFrame myFrame;
    
    /**
     * Constructor.
     * 
     * @param thePanel the JPanel to be edited by the action.
     * @param theIcon the icon for the drawing tool.
     */
    public ToolSelectionAction(final ArtPanel thePanel, final ImageIcon theIcon) {
        super();
        putValue(MY_PANEL, thePanel);
        putValue(Action.SMALL_ICON, theIcon);
        myPanel = thePanel;
        myFrame = myPanel.getFrame();

    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        putValue(Action.SELECTED_KEY, true);
        changeCursor();
        changeShape();
    }
    
    /** Changes the shape to draw. */
    private void changeShape() {
        if (myIconFilePath.contains(PENCIL)) {
            myPanel.setToolType(PENCIL);
            myFrame.getArtChoices().enableCheckBox(false);
        } else if (myIconFilePath.contains(SQUARE)) {
            myPanel.setToolType(SQUARE);
            myFrame.getArtChoices().enableCheckBox(true);
        } else if (myIconFilePath.contains(ELLIPSE)) {
            myPanel.setToolType(ELLIPSE);
            myFrame.getArtChoices().enableCheckBox(true);
        } else if (myIconFilePath.contains(LINE)) {
            myPanel.setToolType(LINE);
            myFrame.getArtChoices().enableCheckBox(false);
        }
        
    }

    /** Changes the cursor to a set cursor depending on the tool selected. */
    private void changeCursor() {
        final Toolkit toolkit = Toolkit.getDefaultToolkit();
        myIconFilePath = getValue(Action.SMALL_ICON).toString();

        final Image image = toolkit.getImage(myIconFilePath);
        final Point hotSpot = new Point(2, 30);
        Cursor newCursor;

        if (myIconFilePath.contains(PENCIL)) {
            newCursor = toolkit.createCustomCursor(image, hotSpot, "Pencil");
        } else {
            newCursor = Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR);
        }
        myPanel.setCursor(newCursor);
    }

}
