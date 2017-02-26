package controller;

import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.ArtModel;
import view.ArtPanel;
/**
 * Sets up actions for the animation buttons.
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class AnimationAction extends AbstractAction {
    /** represents the text for the name of the panel. */
    private static final String MY_PANEL = "myPanel";

    /** represents the text for the name of a square object. */
    private static final String SQUARE = "square";
    
    /** represents the text for the name of a square object. */
    private static final String CIRCLE = "circle";
    
    
    /** how much the shape should move by. */
    private static final int MOVEMENT = 4;
    
    /** The time between movement. */
    private int myTimerTime;
    
    /** The panel being edited. */
    private final ArtPanel myPanel;

    /** Denotes the style of animation to use. */
    private String myAnimationStyle;

    /** the list of shapes in the panel. */
    private ArtModel myList;

    /** Represents a timer. */
    private Timer myTimer;


    /** How much the shapes should move horizontally. */
    private int myHorizontalMove = MOVEMENT;

    /** How much the shapes should move vertically. */
    private int myVerticalMove = MOVEMENT;

    
    /**
     * Constructor.
     * 
     * @param thePanel the JPanel to be edited by the action.
     * @param theIcon the icon for the drawing tool.
     */
    public AnimationAction(final ArtPanel thePanel, final ImageIcon theIcon) {
        super();
        putValue(MY_PANEL, thePanel);
        putValue(Action.SMALL_ICON, theIcon);
        myPanel = thePanel;
        myList = myPanel.getShapeList();
        myTimerTime = myPanel.getFPS();
        if (myTimerTime == 0) { 
            myTimerTime = 1; 
        }
        myTimer = new Timer(myTimerTime, new TimerListener());

    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        putValue(Action.SELECTED_KEY, true);
        performAction();
    }

    /**
     * 
     */
    private void performAction() {
        String icon = getValue(Action.SMALL_ICON).toString();
        
        
        myAnimationStyle = myPanel.getFrame().getAnimationStyle();
        if (myAnimationStyle.contains("no")) {
            JOptionPane.showMessageDialog(myPanel.getFrame(),
                                          "Please select an animation style from"
                                          + " the animation menu.",
                                          "No Animation Style",
                                          JOptionPane.ERROR_MESSAGE);
            icon = "reset";
        } else if (myAnimationStyle.contains("round")) {
            myHorizontalMove = MOVEMENT;
            myVerticalMove = MOVEMENT;
        } else if (myAnimationStyle.contains("orizont")) {
            myHorizontalMove = MOVEMENT;
            myVerticalMove = 0;
        } else if (myAnimationStyle.contains("ertic")) {
            myHorizontalMove = 0;
            myVerticalMove = MOVEMENT;
        }
        
        if (icon.contains("play")) {
            myTimerTime = myPanel.getFPS();
            final int fiveHundred = 500;
            if (myTimerTime == 0) {
                myTimerTime = 1;
            }
            myTimer.setDelay(fiveHundred / myTimerTime);
            myTimer.start();
        } else if (icon.contains("stop")) {
            stop();
            myTimer.stop();
            myPanel.repaint();
        } else if (icon.contains("step")) {
            step();
        } else if (icon.contains("pause")) {
            pause();
        }
        
    }

    /**
     * Steps the program forward one motion. 
     */
    private void step() {

        for (int i = 0; i < myList.size(); i++) {
            if (SQUARE.equals(myList.getProperties(i).getShapeType())) {
                final Rectangle2D.Double square = (Rectangle2D.Double) myList.get(i); 
                square.setFrame(square.getX() + myHorizontalMove, 
                                square.getY() + myVerticalMove,
                                square.getWidth(), square.getHeight());
                myList.set(i, square, myList.getProperties(i));
                myPanel.repaint();
            } else if (myList.getProperties(i).getShapeType().equals(CIRCLE)) {
                final Ellipse2D.Double circle = (Ellipse2D.Double) myList.get(i); 
                circle.setFrame(circle.getX() + myHorizontalMove, 
                                circle.getY() + myVerticalMove,
                                circle.getWidth(), circle.getHeight());
                myList.set(i, circle, myList.getProperties(i));
                myPanel.repaint();
            }

            
        }
        
    }
    
    /**
     * Stops the animation.
     */
    private void stop() {
        myTimer.stop();
    }
    
    /**
     * Pauses the animation.
     */
    private void pause() {
        myPanel.repaint();
    }
    
    /**
     * An inner class to listen for timer actions.
     * @author Molly Brougham
     * @version 1.0
     */
    private class TimerListener implements ActionListener {
        /** the shape to move. */
        private Shape myMovingShape;

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            play();
        }
        
        /** play the animation of the shapes. */
        private void play() {
            
            for (int i = 0; i < myList.size(); i++) {
                
                myMovingShape = myList.get(i);
                updateDirection();
                if ("ellipse".equals(myList.getProperties(i).getShapeType())) {

                    
                    final Ellipse2D.Double circle = (Ellipse2D.Double) myMovingShape;
                    
                    circle.setFrame(circle.getX() + myHorizontalMove, 
                                    circle.getY() + myVerticalMove,
                                    circle.getWidth(), 
                                    circle.getHeight());
                    
                    myMovingShape = circle;
                    
                } else if (SQUARE.equals(myList.getProperties(i).getShapeType())) {
                    final Rectangle2D.Double square = (Rectangle2D.Double) myMovingShape; 
                    square.setFrame(square.getX() + myHorizontalMove, 
                                           square.getY() + myVerticalMove,
                                           square.getWidth(), 
                                           square.getHeight());
                    myMovingShape = square;
                }

                myPanel.repaint();
            }
            
            myPanel.repaint();
            
            
        }
        
        /**
         * updates the direction the shapes should 
         * move in if they intersect with the panel edge.
         */
        private void updateDirection() {
            final String type = myMovingShape.getClass().toString();
            int bottom = 0;
            int right = 0;
            double y = 0;
            if (type.contains("llipse")) {
                final Ellipse2D.Double shape = (Ellipse2D.Double) myMovingShape;
                bottom = (int) (shape.getY() + shape.getHeight());
                right = (int) (shape.getX() + shape.getWidth());
                y = shape.getY();

            } else if (type.contains("quare")) {
                final Rectangle2D.Double shape = (Rectangle2D.Double) myMovingShape;
                bottom = (int) (shape.getY() + shape.getHeight());
                right = (int) (shape.getX() + shape.getWidth());
                y = shape.getY();
            }
            
            if (bottom >= myPanel.getHeight() || y <= 0) {
                myVerticalMove *= -1;
            }
            
            if (right >= myPanel.getWidth() || y <= 0) {
                myHorizontalMove *= -1;
            }
            
            
        }

    }
}
