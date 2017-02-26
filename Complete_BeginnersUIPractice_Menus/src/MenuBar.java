
import com.sun.glass.events.KeyEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;



/**
 * A menu bar for the text editor.
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

    /**
     * The file menu.
     */
    private JMenu myFileMenu = new JMenu("File");
    
    /**
     * The format menu.
     */
    private JMenu myFormatMenu = new JMenu("Format");
    
    /**
     * The font menu.
     */
    private JMenu myFontMenu = new JMenu("Font");
    
    /**
     * The help menu item.
     */
    private JMenuItem myHelpItem = new JMenu("Help");
    
    /**
     * The new document menu item.
     */
    private JMenuItem myNewItem = new JMenuItem("New");
    
    /**
     * The open document menu item.
     */
    private JMenuItem myOpenItem = new JMenuItem("Open");
    
    /**
     * The save document menu item.
     */
    private JMenuItem mySaveItem = new JMenuItem("Save");
    
    /**
     * The print document menu item.
     */
    private JMenuItem myPrintItem = new JMenuItem("Print");
    
    /**
     * The exit menu item.
     */
    private JMenuItem myExitItem = new JMenuItem("Exit");
    
    /**
     * The font type menu item.
     */
    private JMenuItem myTypeItem = new JMenuItem("Type");
    
    /**
     * The font style menu item.
     */
    private JMenuItem myStyleItem = new JMenuItem("Style");
    
    /**
     * The font size menu item.
     */
    private JMenuItem mySizeItem = new JMenuItem("Size");
    
    /**
     * The word wrap check box menu item.
     */
    private JCheckBoxMenuItem myWordWrapCheckBox = new JCheckBoxMenuItem("Word Wrap");
    
    /**
     * Constructor for the menu bar.
     * @param theDocument The text document for the window.
     */
    public MenuBar(final MyDocument theDocument) {
        add(fileMenu());
        add(formatMenu());
        
        myHelpItem.setMnemonic(KeyEvent.VK_H);
        add(myHelpItem);
        
        
    }



    /**
     * Creates and returns the file menu.
     * @return The file menu.
     */
    private JMenu fileMenu() {
        myOpenItem.setAccelerator(KeyStroke.getKeyStroke(
                        "ctrl O"));
        mySaveItem.setAccelerator(KeyStroke.getKeyStroke(
                        "ctrl S"));
        myPrintItem.setAccelerator(KeyStroke.getKeyStroke(
                        "ctrl P"));
        myExitItem.setAccelerator(KeyStroke.getKeyStroke(
                        "ctrl X"));
        myFileMenu.setMnemonic(KeyEvent.VK_F);
        myFileMenu.add(myNewItem);
        myFileMenu.add(myOpenItem);
        myFileMenu.add(mySaveItem);
        myFileMenu.add(myPrintItem);
        myFileMenu.addSeparator();
        myFileMenu.add(myExitItem);
        return myFileMenu;
    }
    
    /**
     * Creates and returns the format menu.
     * @return The format menu.
     */
    private JMenu formatMenu() {
        myWordWrapCheckBox.setSelected(true);
        myFormatMenu.add(myWordWrapCheckBox);
        myFormatMenu.add(fontMenu());
        return myFormatMenu;
    }
    
    /**
     * Creates and returns the font menu.
     * @return The font menu.
     */
    private JMenu fontMenu() {
        myFontMenu.add(myTypeItem);
        myFontMenu.add(myStyleItem);
        myFontMenu.add(mySizeItem);
        return myFontMenu;
        
    }

}
