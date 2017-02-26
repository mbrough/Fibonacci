// Molly Brougham
// Project 2
// CSS 305 A

package view;

import controller.Mouser;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.ArtModel;

/**
 *  Constitutes the graphical representation of the Paint++ program.
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ArtPanel extends JPanel {
    
    /** represents the number 15. */
    private static final int FIFTEEN = 15;
    
    /** The list of shapes in the panel. */
    private final ArtModel myShapeList;
    
    /** The type of tool selected. */
    private String myToolType = "no tool selected";
    
    /** The color selected. */
    private Color myColor;

    /** represents an art frame. */
    private final ArtFrame myFrame;

    /** The graphics used to draw the shapes. */
    private Graphics2D myPen;

    /** The fps of the animation functions. */
    private int myFPS = FIFTEEN;



    /**
     * Main constructor for the ArtPanel.
     * @param theFrame the frame the panel resides in.
     */
    public ArtPanel(final ArtFrame theFrame) {
        super();
        myShapeList = new ArtModel(this);
        setBackground(Color.WHITE);
        final Mouser m = new Mouser(this, myShapeList);
        addMouseListener(m);
        addMouseMotionListener(m);
        final Border line = BorderFactory.createLineBorder(Color.black);
        setBorder(line);
        myFrame = theFrame;

    }
    
    /** 
     * Returns the frame the panel resides in.
     * @return the frame the panel resides in.
     */
    public ArtFrame getFrame() {
        return myFrame;
    }
    
    /** {@inheritDoc} */
    @Override
    public void paintComponent(final Graphics thePen) {
        super.paintComponent(thePen);
        myPen = (Graphics2D) thePen;
        
        for (int i = 0; i < myShapeList.size(); i++) {
            myPen.setColor(myColor);
            myShapeList.setPen(myPen);
            myShapeList.draw(i);
        }
        
    }
    
    /** 
     * sets the color to draw with.
     * @param theColor the color to set.
     */
    public void setToolColor(final Color theColor) {
        myColor = theColor;
    }
    
    /** 
     * returns the current selected color.
     * @return the currently selected color.
     */
    public Color getToolColor() {
        return myColor;
    }
    
    /**
     * Sets the tool type depending on what tool is passed.
     * @param theTool the tool to set the t
     */
    public void setToolType(final String theTool) {
        myToolType = theTool;
    }
    
    /**
     * Returns the type of tool currently selected.
     * @return the type of tool currently selected.
     */
    public String getToolType() {
        return myToolType;
    }

    /** clears the panel of all images. */
    public void clear() {
        myShapeList.empty();
        setBackground(Color.WHITE);
        repaint();
        
    }

    /**
     * returns the image.
     * @return the image.
     */
    public BufferedImage getMyImage() {
        final BufferedImage image = new BufferedImage(this.getWidth(), 
                this.getHeight(), BufferedImage.TYPE_INT_RGB);
        myPen = image.createGraphics();
        paintAll(myPen);
        return image;
    }

    /**
     * returns the list of shapes displayed in the panel.
     * @return the list of shapes displayed in the panel.
     */
    public ArtModel getShapeList() {
        return myShapeList;
    }

    /** 
     * sets the fps of the animation functions. 
     * @param theFPS the fps to set the animation to
     */
    public void setFPS(final int theFPS) {
        myFPS = theFPS;
    }
    
    /**
     * returns the FPS of the animation functions.
     * @return the FPS of the animation functions
     */
    public int getFPS() {
        return myFPS;
    }
    

}
