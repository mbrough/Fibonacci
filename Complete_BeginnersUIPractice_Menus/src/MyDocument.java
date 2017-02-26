import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Molly Brougham
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class MyDocument extends JPanel {

    /**
     * An area for text.
     */
    private JTextArea myText;
    
    /**
     * A scrolling panel.
     */
    private JScrollPane myScroll;
    
    /**
     * 
     * @param theScreen text.
     */
    public MyDocument(final Dimension theScreen) {
        myText = new JTextArea();
        myScroll = new JScrollPane(myText);

        myText.setLineWrap(true);
        myText.setWrapStyleWord(true);
        
        myScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        myScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        myScroll.setPreferredSize(theScreen);
                
        add(myScroll);
    }

}
