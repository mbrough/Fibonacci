/*
 * TCSS 305
 */

package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * The JMenuBar for this GUI example.
 * 
 * @author Monika Sobolewska
 * @version Spring 2015
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

    /**
     * Construct the menu bar.
     * @custom.post all menu bar elements constructed
     */
    public MenuBar() {     
        super();
        final JMenu fileMenu = new JMenu("File");
        final JMenu editMenu = new JMenu("Edit");
        final JMenu helpMenu = new JMenu("Help");
        add(fileMenu);
        add(editMenu);
        add(helpMenu);
    }
  
}