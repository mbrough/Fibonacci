// Molly Brougham
// Project 2
// CSS 305 A

package model;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.util.ArrayList;

import view.ArtPanel;

/**
 * Keeps track of all individual shapes and their properties.
 * @author Molly Brougham
 * @version 1.0
 *
 */
public class ArtModel {

    /** The list of properties for the shapes. */
    private final ArrayList<ShapeProperties> myList;
    
    /** The graphics that draw the shapes. */
    private Graphics2D myPen;
    
    /** The panel the shapes are displayed in. */
    private final ArtPanel myArtPanel;
    
    /**
     * Main constructor for the list.
     * @param theArtPanel the panel the shapes in the list are displayed in.
     */
    public ArtModel(final ArtPanel theArtPanel) {
        myList = new ArrayList<ShapeProperties>();
        myArtPanel = theArtPanel;
    }

    /**
     * Returns the size of the list.
     * @return the size of the list.
     */
    public int size() {
        return myList.size();
    }

    /**
     * Returns the shape at the given index.
     * @param theIndex the index of the shape to return
     * @return the shape at the specified index
     */
    public Shape get(final int theIndex) {

        return myList.get(theIndex).getShape();
    }
    
    /** 
     * Adds a specified shape to the list.
     * @param theShape the shape to be added.
     */
    public void add(final Shape theShape) {
        final ShapeProperties shapeProperties = new ShapeProperties();
        
        final boolean flag = myArtPanel.getFrame().getArtChoices().shouldShapeBeFilled();
        final int strokeSize = myArtPanel.getFrame().getArtChoices().getThickness();
        final String shapeType = myArtPanel.getToolType();
        
        shapeProperties.setColor(myArtPanel.getToolColor());
        shapeProperties.setFill(flag);
        shapeProperties.setStrokeSize(strokeSize);
        shapeProperties.setShapeType(shapeType);
        shapeProperties.setShape(theShape);
        
        myList.add(shapeProperties);
    }
    
    /** 
     * Returns the index of a given shape.
     * @param theShapeProperties the shape to search for.
     * @return the location of the shape.
     */
    public int indexOf(final ShapeProperties theShapeProperties) {
        return myList.indexOf(theShapeProperties);
    }

    /**
     * Sets up the graphics to draw the shapes in the list.
     * @param thePen the graphics that will draw the shapes.
     */
    public void setPen(final Graphics2D thePen) {
        myPen = thePen;
    }
    
    /**
     * Determines whether the list contains a specified shape.
     * @param theShape the shape to search for.
     * @return a boolean value of whether the list contains the shape.
     */
    public boolean contains(final Shape theShape) {
        boolean flag = false;
        
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getShape().equals(theShape)) {
                flag = true;
            }
        }
        
        return flag;
    }
    
    /**
     * Returns the index of a specified shape if it exists in the list.
     * @param theShape the shape to search for.
     * @return the location of the shape in the list as an int.
     */
    public int indexOf(final Shape theShape) {
        int toReturn = 0;
        
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).getShape() == theShape) {
                toReturn = i;
            }
        }
        
        return toReturn;
    }

    /**
     * Draws the shape at the specified index into the panel.
     * @param theIndex the index of the shape to draw.
     */
    public void draw(final int theIndex) {
        myPen.setColor(myList.get(theIndex).getColor());
        final boolean flag = myList.get(theIndex).isFilled();
        final int thickness = myList.get(theIndex).getStrokeSize(); 
        
        myPen.setStroke(new BasicStroke(thickness));
        
        if (flag) {
            myPen.fill(get(theIndex));
        } else {
            myPen.draw(get(theIndex));
        }
    }
    
    /**
     * Determines whether the list is empty.
     * @return a boolean value for whether the list is empty.
     */
    public boolean isEmpty() {
        return myList.isEmpty();
    }

    /** 
     * Sets the shape at a given index to a specified shape.
     * @param theIndex the index to be altered.
     * @param theShape the shape to set.
     * @param theProperties the shape properties to set at the index.
     */
    public void set(final int theIndex, final Shape theShape, 
                    final ShapeProperties theProperties) {
        myList.set(theIndex, theProperties);
        
    }

    /** empties both lists of all elements. */
    public void empty() {
        myList.clear();
        
    }

    /** 
     * Returns most recently placed shape that resides at a certain point,
     * or if no shape exists there returns a null object. 
     * @param theX the X value for the location.
     * @param theY the Y value for the location.
     * @return the shape at the given location, or null if one does not exist.
     */
    public Shape getShape(final double theX, final double theY) {
        Shape shape = null;
        for (int i = myList.size() - 1; i >= 0; i--) {
            if (myList.get(i).getShape().contains(theX, theY)) {
                shape = myList.get(i).getShape();
                break;
            }
        }
        return shape;
        
    }

    /** 
     * removes a specified shape from the list if it exists.
     * @param theShape the shape to remove
     */
    public void removeShape(final Shape theShape) {
        final int location = indexOf(theShape);
        myList.remove(location);
        
    }

    /** 
     * returns the shape properties at a specified location.
     * @param theShapeLocation the location of properties to return
     * @return the properties at the specified location.
     */
    public ShapeProperties getProperties(final int theShapeLocation) {
        return myList.get(theShapeLocation);
    }
}

