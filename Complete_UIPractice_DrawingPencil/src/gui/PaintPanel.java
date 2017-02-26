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
import java.awt.geom.GeneralPath;
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
    private final ArrayList<Shape> myPathsList;

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
        myPathsList = new ArrayList<Shape>();
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
        
        for (int i = 0; i < myPathsList.size(); i++) {
            pen.draw(myPathsList.get(i));
        }
        
    }
    
    /**
     * An inner class to handle mouse events.
     */
    private class Mouser extends MouseAdapter {
       
        /** A general path drawn by the mouse movements. */
        private GeneralPath myPath;
        
        /** The pen used to draw the graphics. */
        private Graphics2D myPen;
        
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            myPen = (Graphics2D) getGraphics();
            myP1.setLocation(theEvent.getX(), theEvent.getY());
            myP2.setLocation(theEvent.getX(), theEvent.getY());
            myPath = new GeneralPath(GeneralPath.WIND_NON_ZERO);
            myPath.moveTo(myP1.getX(), myP1.getY());
        }
        
        @Override
        public void mouseReleased(final MouseEvent theEvent) {
            myPathsList.add(myPath);
        }
        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            myP2.setLocation(theEvent.getX(), theEvent.getY());
            myPath.lineTo(myP2.getX(), myP2.getY());
            myPen.draw(myPath);
        }
    }
}
