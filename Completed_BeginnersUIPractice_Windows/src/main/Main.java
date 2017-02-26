package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

/**
 * Runs the demo.
 * @version 2015-04-15
 * @author Cay Horstmann
 * @author Monika Sobolewska
 */
public final class Main {
    /** 
     * private default constructor.
     */
    private Main() {
    }
    
    /**
     * main method driving the demo.
     * @param theArgs none
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() 
        {
            public void run() {
                final JFrame frame = new MainFrame();
                frame.setTitle("Create your Ice-Cream");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}

