// Molly Brougham
// Project 2
// CSS 305 A

package model;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;


/**
 * Encapsulates a shape with all its properties.
 * @author Molly Brougham
 * @version 1.0
 */
public class ShapeProperties {

    /** The color of the shape. */
    private Color myColor = Color.BLACK;
    
    /** A boolean for whether or not the shape should be filled. */
    private boolean myFill;
    
    /** how thick the line of the shape should be. */
    private int myStrokeSize = 1;

    /** The type of shape. */
    private String myShapeType;

    /** The start point for the shape. */
    private Point myStartPoint;

    /** the width of the shape, if it is a square or ellipse. */
    private double myWidth;

    /** the height of the shape, if it is a square or ellipse. */
    private double myHeight;

    /** the current position of the shape. */
    private Point myCurrentPosition;

    /** the shape object. */
    private Shape myShape;

    /** Sets the color of the shape.
     * @param theColor the color to set the shape. 
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /** 
     * Returns the color of the shape.
     * @return the color of the shape.
     */
    public Color getColor() {
        return myColor;
    }

    /**
     * Determines whether the shape should be filled or not.
     * @return whether the shape should be filled or not.
     */
    public boolean isFilled() {
        return myFill;
    }

    /**
     * Sets the shape to be filled or not.
     * @param theFill boolean value whether or not to fill the shape.
     */
    public void setFill(final boolean theFill) {
        myFill = theFill;
    }
    
    /**
     * returns the size of the stroke.
     * @return the size of the stroke.
     */
    public int getStrokeSize() {
        return myStrokeSize;
    }
    
    /**
     * sets the stroke size to a specified thickness.
     * @param theStrokeSize the new stroke size.
     */
    public void setStrokeSize(final int theStrokeSize) {
        myStrokeSize = theStrokeSize;
    }

    /**
     * Sets the type of shape.
     * @param theShapeType the type of shape.
     */
    public void setShapeType(final String theShapeType) {
        myShapeType = theShapeType;
    }
    
    /** returns the type of shape.
     * @return the type of shape
     */
    public String getShapeType() {
        return myShapeType;
    }

    /**
     * Sets the start point for the shape.
     * @param theStartPoint the start point to be set
     */
    public void setStart(final Point theStartPoint) {
        myStartPoint = theStartPoint;
        myCurrentPosition = theStartPoint;
        
    }
    
    /** returns the start point of the shape.
     * @return the start point of the shape.
     */
    public Point getStart() {
        return myStartPoint;
    }

    /** 
     * sets the width for the shape, if the shape is a square or ellipse.
     * @param theWidth the width to set.
     */
    public void setWidth(final double theWidth) {
        myWidth = theWidth;
    }
    
    /**
     * returns the width of the shape, if it is a square or ellipse.
     * @return the width.
     */
    public double getWidth() {
        return myWidth;
    }
    
    /** 
     * sets the height for the shape, if the shape is a square or ellipse.
     * @param theHeight the width to set.
     */
    public void setHeight(final double theHeight) {
        myHeight = theHeight;
        
    }
    
    /**
     * returns the height of the shape, if it is a square or ellipse.
     * @return the height.
     */
    public double getHeight() {
        return myHeight;
    }

    /**
     * returns the current position of the shape.
     * @return the current position of the shape.
     */
    public Point getCurrentPosition() {
        return myCurrentPosition;
    }
    
    /**
     * Sets the current position of the shape to a specified location.
     * @param theCurrentPosition the location to set the current position to.
     */
    public void setCurrentPosition(final Point theCurrentPosition) {
        myCurrentPosition = theCurrentPosition;
    }

    /** 
     * returns the shape object.
     * @return the shape object.
     */
    public Shape getShape() {
        return myShape;
    }
    
    /**
     * Sets the shape to a specified shape.
     * @param theShape the shape to set.
     */
    public void setShape(final Shape theShape) {
        myShape = theShape;
    }
    
    /**
     * Determines whether the shape contains a specified point.
     * @param thePoint the point to check for
     * @return a boolean value of whether the shape contains the point
     */
    public boolean contains(final Point thePoint) {
        return myShape.contains(thePoint);
    }
    
}
