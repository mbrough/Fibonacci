/*
 * TCSS 305
 */

package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;


/**
 * The JPanel to paint components on.
 * 
 * @author Monika Sobolewska
 * @version Winter 2014
 */
@SuppressWarnings("serial")
public class PaintPanel extends JPanel {
  
    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /** The width of the screen. */
    private static final int SCREEN_WIDTH = SCREEN_SIZE.width / 2;
    
    /** The height of the screen. */
    private static final int SCREEN_HEIGHT = SCREEN_SIZE.height / 2;
    
    /** The default size for this JPanel. */
    private static final Dimension DEFAULT_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);

    /** the arraylist that holds the shapes drawn. */
    private final ArrayList<Shape> myShapesList;

    /** represents a point. */
    private final Point myP2;

    /** represents a point. */
    private final Point myP1;
    


   
  /**
   * Construct this JPanel.
   * @custom.post white panel of a quarter of a screen size constructed 
   */
    public PaintPanel() {
        super();
        myP1 = new Point();
        myP2 = new Point();
        myShapesList = new ArrayList<Shape>();
        final Mouser m = new Mouser();
        addMouseListener(m);
        addMouseMotionListener(m);
        setPreferredSize(DEFAULT_SIZE);
        setBackground(Color.WHITE);
    }

    /** {@inheritDoc} */
    @Override
    public void paintComponent(final Graphics thePen) {
        super.paintComponent(thePen);
        final Graphics2D pen = (Graphics2D) thePen;
        
        for (int i = 0; i < myShapesList.size(); i++) {
            pen.draw(myShapesList.get(i));
        }
        
    }
    
    /**
     * An inner class to handle mouse events.
     */
    private class Mouser extends MouseAdapter {
        
        /** a boolean to determine which shape to draw. */
        private boolean myFlag;
        
        /** the shape being drawn. */
        private Shape myShape;
        
        /** the graphics used to draw the shape. */
        private Graphics2D myPen;
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            myPen = (Graphics2D) getGraphics();
            myP1.setLocation(theEvent.getX(), theEvent.getY());
            myP2.setLocation(theEvent.getX(), theEvent.getY());
            if (myFlag) {
                myShape = new Line2D.Double(myP1, myP2);
            } else {
                myShape = new Rectangle2D.Double(myP1.getX(), myP2.getY(), 0, 0);
            }
            repaint();
        }
        
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            myShapesList.add(myShape);
            myPen.draw(myShape);
            myFlag = !myFlag;
            repaint();
        }
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            theEvent.getComponent().repaint();
            myP2.setLocation(theEvent.getX(), theEvent.getY());
            if (myFlag) {
                final Line2D.Double line = (Line2D.Double) myShape;
                line.setLine(myP1, myP2);
                myShape = line;
            } else {
                final Rectangle2D.Double rect = (Rectangle2D.Double) myShape;
                final double width = Math.abs(myP1.getX() - myP2.getX());
                final double height = Math.abs(myP1.getY() - myP2.getY());
                rect.setRect(myP1.getX(), myP1.getY(), width, height);
                myShape = rect;
            }
            myPen.draw(myShape);
            theEvent.getComponent().repaint();
        }
    }
}
