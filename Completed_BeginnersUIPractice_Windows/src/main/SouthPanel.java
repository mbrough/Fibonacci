package main;

import java.awt.Color;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The south panel for the store front window.
 * @author Molly Brougham
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SouthPanel extends JPanel {

    /**
     * The background color for the south panel.
     */
    private static final Color LIGHT_BLUE = new Color(153, 204, 255);
    
    /**
     * An example of a price for the order.
     */
    private static final double EXAMPLE_PRICE = 8.98;
    
    /**
     * The price for the order.
     */
    private final double myPrice;
    
    /**
     * A button to order the selection.
     */
    private final JButton myOrderButton = new JButton("Order");
    
    /**
     * SouthPanel constructor that creates the south panel of the window.
     */
    public SouthPanel() {
        super();
        myPrice = EXAMPLE_PRICE;
        setBackground(LIGHT_BLUE);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        add(Box.createHorizontalGlue());
        add(centerSouth());
        add(Box.createHorizontalGlue());
                
    }
    
    /**
     * Sets up the main elements within the south panel.
     * @return centerSouth the panel that includes price and order button.
     */
    private JPanel centerSouth() {
        final JPanel priceAndOrder = new JPanel();
        priceAndOrder.setLayout(new BoxLayout(priceAndOrder, BoxLayout.Y_AXIS));
        priceAndOrder.setBackground(LIGHT_BLUE);
        priceAndOrder.add(new JLabel("Price:"));
        priceAndOrder.add(new JLabel("$" + myPrice));
        priceAndOrder.add(new JLabel("------------"));
        priceAndOrder.add(myOrderButton);

        return priceAndOrder;
    }
}
