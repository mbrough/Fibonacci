// Molly Brougham
// Project 2
// CSS 305 A

package controller;

import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import model.ArtModel;
import view.ArtPanel;

/**
 * An class to handle mouse events.
 * @version 1.0
 * @author Molly Brougham
 */
public class Mouser extends MouseAdapter {

    /** The time between clicks the desktop uses to determine a double click. */
    private static final int DOUBLE_CLICK_TIME = (Integer) Toolkit.getDefaultToolkit().
                    getDesktopProperty("awt.multiClickInterval");
    
    /** A general path drawn by the mouse movements. */
    private Shape myCurrentShape;

    /** The art panel displayed. */
    private final ArtPanel myPanel;

    /** The start point for any mouse event. */
    private final Point myP1;

    /** The end point for any mouse event. */
    private final Point myP2;

    /** the list of shapes displayed. */
    private final ArtModel myList;

    /** Location in the list of the current shape drawn. */
    private int myShapeLocation;

    /** The general path of a stroke being drawn. */
    private GeneralPath myCurrentStroke;

    /** represents a rectangle object. */
    private Rectangle2D.Double myCurrentSquare;

    /** represents an ellipse object. */
    private Ellipse2D.Double myCurrentEllipse;

    /** represents a line object. */
    private Line2D.Double myCurrentLine;
    
    /** boolean for whether the click is a double click. */
    private boolean myDoubleClick;
    
    /**
     * Main constructor.
     * @param thePanel the Panel being watched for mouse events.
     * @param theList the list of shapes in the panel
     */
    public Mouser(final ArtPanel thePanel, final ArtModel theList) {
        super(); 
        myPanel = thePanel;
        myList = theList;
        myP1 = new Point();
        myP2 = new Point();
        myShapeLocation = -1;
        myDoubleClick = false;
    }

    @Override
    public void mousePressed(final MouseEvent theEvent) {
        myP1.setLocation(theEvent.getX(), theEvent.getY());
        myP2.setLocation(theEvent.getX(), theEvent.getY());
        
        if (myDoubleClick) {
            myDoubleClick = false;
            if (theEvent.isMetaDown()) {
                deleteShape(theEvent);
            }
        } else {
            myDoubleClick = true;
            final Timer timer = new Timer("doubleclickTimer", false);
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    myDoubleClick = false;
                }
            }, DOUBLE_CLICK_TIME);
        }
        
        if (theEvent.isMetaDown()) {
            myPanel.repaint();
        } else {
            leftClick();
        }
        

        myPanel.repaint();
    }
    
    @Override
    public void mouseDragged(final MouseEvent theEvent) {
        myPanel.repaint();
        myP2.setLocation(theEvent.getX(), theEvent.getY());

        if (theEvent.isMetaDown()) {
            if (myList.getShape(myP2.getX(), myP2.getY()) != null) {
                final Shape shape = myList.getShape(myP2.getX(), myP2.getY());
                moveShape(shape);
            }
        } else {
            
            if (myPanel.getToolType().equals(ToolSelectionAction.PENCIL)) {
                draggedStroke();
            } else if (ToolSelectionAction.SQUARE.equals(myPanel.getToolType())) {
                draggedSquare();
            } else if (ToolSelectionAction.ELLIPSE.equals(myPanel.getToolType())) {
                draggedEllipse();
            } else if (ToolSelectionAction.LINE.equals(myPanel.getToolType())) {
                draggedLine();
            }
        }

    }

    /** 
     * tells the program what to do with a left mouse click event.
     */
    private void leftClick() {

        if (myPanel.getToolType().equals(ToolSelectionAction.PENCIL)) {
            pressedStroke();
        } else if (ToolSelectionAction.SQUARE.equals(myPanel.getToolType())) {
            pressedSquare();
        } else if (ToolSelectionAction.ELLIPSE.equals(myPanel.getToolType())) {
            pressedEllipse();
        } else if (ToolSelectionAction.LINE.equals(myPanel.getToolType())) {
            pressedLine();
        } else {
            JOptionPane.showMessageDialog(myPanel, "Please select a tool.", "No Tool Selected",
                                          JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    /** 
     * tells the program what to do with a left mouse click event.
     * @param theEvent the mouse event.
     */
    private void deleteShape(final MouseEvent theEvent) {
        if (myList.getShape(theEvent.getX(), theEvent.getY()) != null) {
            myList.removeShape(myList.getShape(theEvent.getX(), theEvent.getY()));
        }
    }

    /** The action to perform when the mouse is pressed and the line tool is selected. */
    private void pressedLine() {
        myCurrentLine = new Line2D.Double(myP1.getX(), myP1.getY(), myP2.getX(), myP2.getY());
        myCurrentShape = myCurrentLine;
        myList.add(myCurrentShape);
        myShapeLocation = myList.indexOf(myCurrentShape);
        myPanel.repaint();
    }

    /** The action to perform when the mouse is pressed and the ellipse tool is selected. */
    private void pressedEllipse() {
        myCurrentEllipse = new Ellipse2D.Double(myP1.getX(), myP2.getY(), 1, 1);
        myCurrentShape = myCurrentEllipse;
        myList.add(myCurrentShape);
        myShapeLocation = myList.indexOf(myCurrentShape);
        myPanel.repaint();

    }

    /** The action to perform when the mouse is pressed and the square tool is selected. */
    private void pressedSquare() {
        myCurrentSquare = new Rectangle2D.Double(myP1.getX(), myP2.getY(), 1, 1);
        myCurrentShape = myCurrentSquare;
        myList.add(myCurrentShape);
        myShapeLocation = myList.indexOf(myCurrentShape);
        myPanel.repaint();
        myDoubleClick = false;
    }

    /** The action to perform when the mouse is pressed and the stroke tool is selected. */
    private void pressedStroke() {
        myCurrentStroke = new GeneralPath(GeneralPath.WIND_NON_ZERO);
        myCurrentStroke.moveTo(myP1.getX(), myP1.getY());
        myCurrentStroke.lineTo(myP2.getX(), myP2.getY());
        
        myCurrentShape = myCurrentStroke;
        
        myList.add(myCurrentShape);
        myShapeLocation = myList.indexOf(myCurrentShape);
        myPanel.repaint();
        myDoubleClick = false;
    }

    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        if (theEvent.isMetaDown()) {
            myPanel.repaint();
        } else {
            if (myShapeLocation > -1 && !myList.isEmpty() 
                            && myList.get(myShapeLocation) != null) {
                myList.set(myShapeLocation, myCurrentShape, 
                           myList.getProperties(myShapeLocation));
            }
            myCurrentStroke = new GeneralPath(GeneralPath.WIND_NON_ZERO);
            myPanel.repaint();
        }
    }

    /**
     * Adjusts the size of the line to end at the point where the mouse is being dragged.
     */
    private void draggedLine() {

        myCurrentLine.setLine(myP1.getX(), myP1.getY(), myP2.getX(), myP2.getY());
        myList.add(myCurrentLine);
        myCurrentShape = myCurrentLine;
        
        if (myList.contains(myCurrentLine)) {
            myList.set(myShapeLocation, myCurrentShape, 
                       myList.getProperties(myShapeLocation));
        } else {
            myList.add(myCurrentLine);
        }
        myShapeLocation = myList.indexOf(myCurrentLine);
        myPanel.repaint();
    }
    
    /**
     * Moves the specified shape along the path of the mouse drag.
     * @param theShape the shape to be moved.
     */
    private void moveShape(final Shape theShape) {
        final double dx = myP2.getX() - myP1.getX();
        final double dy = myP2.getY() - myP1.getY();
        final String shapeType = theShape.getClass().toString();
        if (shapeType.contains("llipse")) {
            
            final Ellipse2D.Double ellipse = (Ellipse2D.Double) theShape;
            final double width = ellipse.getWidth();
            final double height = ellipse.getHeight();
            myCurrentEllipse = ellipse;
            
            final double newX = ellipse.getX() + dx;
            final double newY = ellipse.getY() + dy;
            

            myCurrentEllipse.setFrame(newX, newY, width, height);
            myCurrentShape = myCurrentEllipse;
            
        } else if (shapeType.contains("ctangle")) {
            final Rectangle2D.Double square = (Rectangle2D.Double) theShape;
            final double width = square.getWidth();
            final double height = square.getHeight();
            myCurrentSquare = square;
            
            final double newX = square.getX() + dx;
            final double newY = square.getY() + dy;
            

            myCurrentSquare.setFrame(newX, newY, width, height);
            myCurrentShape = myCurrentSquare;
        }
        
        if (myList.contains(theShape)) {
            myList.set(myShapeLocation, myCurrentShape, 
                       myList.getProperties(myShapeLocation));
        } else {
            myList.add(myCurrentShape);
        }
        
        myShapeLocation = myList.indexOf(myCurrentShape);
        myPanel.repaint();
        
        final double newP1X = myP1.getX() + dx;
        final double newP1Y = myP1.getY() + dy;
        myP1.setLocation(newP1X, newP1Y);
        
    }

    /**
     * Adjusts the size of the ellipse to end at the point where the mouse is being dragged.
     */
    private void draggedEllipse() {
        final double width = Math.abs(myP1.getX() - myP2.getX());
        final double height = Math.abs(myP1.getY() - myP2.getY());
        myCurrentEllipse.setFrame(myP1.getX(), myP1.getY(), width, height);
        myCurrentShape = myCurrentEllipse;
        
        if (myList.contains(myCurrentEllipse)) {
            myList.set(myShapeLocation, myCurrentShape, 
                       myList.getProperties(myShapeLocation));
        } else {
            myList.add(myCurrentEllipse);
        }
        
        myShapeLocation = myList.indexOf(myCurrentEllipse);
        
        myPanel.repaint();

        myDoubleClick = false;
    }

    
    /**
     * Adjusts the size of the square to end at the point where the mouse is being dragged.
     */
    private void draggedSquare() {
        final double width = Math.abs(myP1.getX() - myP2.getX());
        final double height = Math.abs(myP1.getY() - myP2.getY());
        myCurrentSquare.setRect(myP1.getX(), myP1.getY(), width, height);
        myCurrentShape = myCurrentSquare;
        if (myList.contains(myCurrentSquare)) {
            myList.set(myShapeLocation, myCurrentShape, 
                       myList.getProperties(myShapeLocation));
            
        } else {
            myList.add(myCurrentSquare);
        }
        myShapeLocation = myList.indexOf(myCurrentSquare);
        
        myPanel.repaint();
    }

    /**
     * Adjusts the stroke shape to follow the path of the mouse when mouse is clicked.
     */
    private void draggedStroke() {
        myCurrentStroke.lineTo(myP2.getX(), myP2.getY());
        myCurrentShape = myCurrentStroke;
        if (myList.contains(myCurrentStroke)) {
            myList.set(myShapeLocation, myCurrentShape, 
                       myList.getProperties(myShapeLocation));
        } else {
            myList.add(myCurrentStroke);
        }
        myShapeLocation = myList.indexOf(myCurrentStroke);
        myPanel.repaint();
    }
}
