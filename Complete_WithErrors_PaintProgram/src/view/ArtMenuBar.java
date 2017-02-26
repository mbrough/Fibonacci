// Molly Brougham
// Project 2
// CSS 305 A

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 * The menu bar for the program.
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class ArtMenuBar extends JMenuBar {

    /** represents the save JMenuItem. */
    private JMenuItem mySaveItem;
    
    /** represents a MenuListener. */
    private final MenuListener myListener;
    
    /** represents the clear JMenuItem. */
    private JMenuItem myClearItem;

    /** represents the art frame the menu bar resides in. */
    private final ArtFrame myFrame;

    /** A radio button to select a bounce animaton style. */
    private JRadioButton myBounceAroundAnimationItem;

    /** A radio button to select a fall animaton style. */
    private JRadioButton myBounceVerticallyAnimationItem;

    /** A radio button to select a rise animaton style. */
    private JRadioButton myBounceHorizontallyItem;

    /** 
     * Main constructor for the menu bar.
     * @param theFrame the frame the menu bar resides in.
     */
    public ArtMenuBar(final ArtFrame theFrame) {
        super();
        myListener = new MenuListener();
        myFrame = theFrame;

        setUpFileMenu();
        setUpEditMenu();
        setUpAnimationMenu();


    }
    
    /** Sets up the animation menu. */
    private void setUpAnimationMenu() {
        final JMenu animationMenu = new JMenu("Animation");
        final JLabel animationLabel = new JLabel("  Select Animation Style:  ");
        animationMenu.add(animationLabel);
        animationMenu.addSeparator();
        myBounceAroundAnimationItem = new JRadioButton("Bounce Around");
        myBounceVerticallyAnimationItem = new JRadioButton("Bounce Vertically");
        myBounceHorizontallyItem = new JRadioButton("Bounce Horizontally");
        
        final ButtonGroup group = new ButtonGroup();
        
        group.add(myBounceAroundAnimationItem);
        group.add(myBounceVerticallyAnimationItem);
        group.add(myBounceHorizontallyItem);
        animationMenu.add(myBounceAroundAnimationItem);
        animationMenu.add(myBounceVerticallyAnimationItem);
        animationMenu.add(myBounceHorizontallyItem);
        
        
        add(animationMenu);
        
    }

    /** sets up the edit menu. */
    private void setUpEditMenu() {
        final JMenu editMenu = new JMenu("Edit");
        myClearItem = new JMenuItem("Clear");
        myClearItem.addActionListener(myListener);
        editMenu.add(myClearItem);
        add(editMenu);
    }

    /** Sets up the file menu. */
    private void setUpFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        mySaveItem = new JMenuItem("Save");
        mySaveItem.addActionListener(myListener);
        fileMenu.add(mySaveItem);
        add(fileMenu);
    }
    
    /**  
     * Returns a string that describes the type of animation selected.
     * @return the type of animation selected.
     */
    public String getAnimationStyle() {
        String animation = "";
        if (myBounceAroundAnimationItem.isSelected()) {
            animation = "around";
        } else if (myBounceVerticallyAnimationItem.isSelected()) {
            animation = "vertically";
        } else if (myBounceHorizontallyItem.isSelected()) {
            animation = "horizontally";
        } else {
            animation = "no animation selected";
        }
        
        return animation;
    }

    /** An inner class to listen to menu clicks. */
    private class MenuListener implements ActionListener {

        /** represents a JFileChooser. */
        private JFileChooser myChooser;

        @Override
        public void actionPerformed(final ActionEvent theEvent) {
            final Object source = theEvent.getSource();
            myChooser = new JFileChooser();
            if (source.equals(mySaveItem)) {
                saveDialog();
                
                
            } else if (source.equals(myClearItem)) {
                final int response = JOptionPane.showConfirmDialog(myFrame,
                                     "Are you sure you want to clear the image?",
                                     "Confirm Clear", JOptionPane.YES_NO_OPTION);
                if (response == 0) {
                    myFrame.getPanel().clear();  
                }
                
            }
        }

        /** 
         * shows the save dialog and saves the image if needed. 
         */
        private void saveDialog() {

            final int response = myChooser.showSaveDialog(myFrame);
            
            if (response == JFileChooser.APPROVE_OPTION) {
                final File file = myChooser.getSelectedFile();
                final String gif = ".gif";
                final String jpg = ".jpg";
                final String png = ".png";
                String filePath = file.getPath();
                String extension = "";
                final String period = ".";
                if (!file.getPath().contains(gif) && !file.getPath().contains(jpg) 
                                && !file.getPath().contains(png)) {
                    if (filePath.contains(period)) {
                        filePath = file.getPath().substring(0, file.getPath().indexOf(period));
                    }
                    final Object[] extensions = {gif, jpg, png};
                    extension = (String) JOptionPane.showInputDialog(myFrame,
                                        "Please select a valid file extension:",
                                        "Extension Selection", JOptionPane.PLAIN_MESSAGE,
                                        null, extensions, gif);
                    filePath = filePath + extension;
                }
                save(filePath);
            }
            
        }

        /**
         * Saves the image.
         * @param theFilePath the file path to save the image to.
         */
        private void save(final String theFilePath) {
            final BufferedImage image = myFrame.getPanel().getMyImage();

            try {
                ImageIO.write(image, "png", new File(theFilePath));

            } catch (final IOException e) {
                e.printStackTrace();
            }
            
        }
    }
}
