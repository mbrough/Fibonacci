package main;


import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;


/**
 * The center panel  with selections for the ice cream.
 * @author Molly Brougham
 * @version 2.0
 *
 */
@SuppressWarnings("serial")
public class CenterPanel extends JPanel {   
    
    /**
     * The number of rows.
     */
    private static final int ROWS = 5;
    
    /**
     * The number of columns.
     */
    private static final int COLUMNS = 1;
    
    /**
     * The number of columns within the center panel.
     */
    private static final int PANEL_COLUMNS = 4;
    
    /**
     * The number of rows within the center panel.
     */
    private static final int PANEL_ROWS = 1;
    
    /**
     * A border with some padding for the columns.
     */
    private static final EmptyBorder BORDER = new EmptyBorder(0, 20, 0, 20);
    
    /**
     * An empty JLabel.
     */
    private static final JLabel EMPTY_LABEL = new JLabel(" ");
    
    /**
     * The background color for the center panel.
     */
    private static final Color LIGHT_BLUE = new Color(153, 204, 255);

    /**
     * A label for the size column title. 
     */
    private static final JLabel SIZE_LABEL = new JLabel("Ice Cream Size:");
   
    /**
     * A label for the cone column title.
     */
    private static final JLabel CONE_LABEL = new JLabel("Cone Type:");
    
    /**
     * A label for the flavor column title.
     */
    private static final JLabel FLAVOR_LABEL = new JLabel("The flavors of your choice");

    /**
     * A label for the mix ins column title.
     */
    private static final JLabel MIX_INS_LABEL = new JLabel("Mix-Ins");

    /**
     * Column for size menu.
     */
    private JPanel mySizeColumn;   
    
    /**
     * Column for cone menu.
     */
    private JPanel myConeColumn;  
    
    /**
     * Column for flavor menu.
     */
    private JPanel myFlavorColumn;    
    
    /**
     * Column for mix ins menu.
     */
    private JPanel myMixInsColumn;
    
    /**
     * CenterPanel constructor that creates the center panel of the window.
     */
    public CenterPanel() {
        super();
        
        setBackground(LIGHT_BLUE);
        setLayout(new GridLayout(PANEL_ROWS, PANEL_COLUMNS));

        
        setUpColumns();
        
        add(mySizeColumn);
        add(myConeColumn);
        add(myFlavorColumn);
        add(myMixInsColumn);
    }
   
    
    /**
     * Creates the size drop down menu.
     * @return dropDown the drop down menu for sizes.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private JComboBox dropDown() {
        final String[] sizes = {"Mine (16 oz)", "Ours (32 oz)", "Everybody's (48oz)"};
        return new JComboBox(sizes);
    }
    
    /**
     * Sets up elements of the size menu.
     */
    private void sizeColumn() {
        mySizeColumn = new JPanel();
        mySizeColumn.setLayout(new GridLayout(ROWS, COLUMNS));
        
        //adds title and drop down menu
        mySizeColumn.add(SIZE_LABEL);
        mySizeColumn.add(dropDown());
        mySizeColumn.add(EMPTY_LABEL);
        mySizeColumn.add(EMPTY_LABEL);
        mySizeColumn.add(EMPTY_LABEL);


        //sets panel to be transparent
        mySizeColumn.setOpaque(false);
        
    }
    
    /**
     * Sets up elements of the cone type menu.
     */
    private void coneTypeColumn() {
        myConeColumn = new JPanel();
        myConeColumn.setLayout(new BoxLayout(myConeColumn, BoxLayout.PAGE_AXIS));
        
        myConeColumn.add(CONE_LABEL);
        
        //creates buttons
        final JButton sugarCone = new JButton("Sugar Cone");
        final JButton waffleCone = new JButton("Waffle Cone");
        final JButton paperCup = new JButton("Paper Cup");
        
        //sets background color for buttons
        paperCup.setForeground(Color.GRAY);
        waffleCone.setForeground(Color.PINK);
        sugarCone.setForeground(Color.RED);
        
        //set sizes
        paperCup.setPreferredSize(waffleCone.getPreferredSize());
        paperCup.setMinimumSize(waffleCone.getMinimumSize());
        paperCup.setMaximumSize(waffleCone.getMaximumSize());
        sugarCone.setPreferredSize(waffleCone.getPreferredSize());
        sugarCone.setMinimumSize(waffleCone.getMinimumSize());
        sugarCone.setMaximumSize(waffleCone.getMaximumSize());
        
        myConeColumn.add(sugarCone);
        myConeColumn.add(waffleCone);
        myConeColumn.add(paperCup);
        myConeColumn.add(EMPTY_LABEL);
        myConeColumn.add(EMPTY_LABEL);
        myConeColumn.setOpaque(false);
        
        myConeColumn.setBorder(BORDER);
        
    }
    
    /**
     * Sets up elements of the flavor menu.
     */
    private void flavorColumn() {
        final ButtonGroup flavors = new ButtonGroup();
        
        //creates radio buttons
        final JRadioButton frenchVanilla = new JRadioButton("French Vanilla");
        final JRadioButton chocolate = new JRadioButton("Chocolate");
        final JRadioButton strawberry = new JRadioButton("Strawberry");
        final JRadioButton mango = new JRadioButton("Mango");
        
        //adds radio buttons to button group
        flavors.add(frenchVanilla);
        flavors.add(chocolate);
        flavors.add(strawberry);
        flavors.add(mango);
        
        //set background color of buttons
        mango.setBackground(Color.YELLOW);
        strawberry.setBackground(Color.RED);
        chocolate.setBackground(Color.GRAY);

        //sets sizes
        frenchVanilla.setPreferredSize(getPreferredSize());
        strawberry.setPreferredSize(frenchVanilla.getPreferredSize());
        strawberry.setMinimumSize(frenchVanilla.getMinimumSize());
        strawberry.setMaximumSize(frenchVanilla.getMaximumSize());
        chocolate.setPreferredSize(frenchVanilla.getPreferredSize());
        chocolate.setMinimumSize(frenchVanilla.getMinimumSize());
        chocolate.setMaximumSize(frenchVanilla.getMaximumSize());
        mango.setPreferredSize(frenchVanilla.getPreferredSize());
        mango.setMinimumSize(frenchVanilla.getMinimumSize());
        mango.setMaximumSize(frenchVanilla.getMaximumSize());

        
        myFlavorColumn = new JPanel();
        myFlavorColumn.setLayout(new BoxLayout(myFlavorColumn, BoxLayout.PAGE_AXIS));
        
        //add label and buttons to the panel
        myFlavorColumn.add(FLAVOR_LABEL);
        myFlavorColumn.add(frenchVanilla);
        myFlavorColumn.add(chocolate);
        myFlavorColumn.add(strawberry);
        myFlavorColumn.add(mango);
        myFlavorColumn.setOpaque(true);
        myFlavorColumn.setBackground(LIGHT_BLUE);
        
        myFlavorColumn.setBorder(BORDER);
    }
    
    /**
     * Set up elements of the mix ins menu.
     */
    private void mixInsColumn() {
        myMixInsColumn = new JPanel();
        myMixInsColumn.setLayout(new BoxLayout(myMixInsColumn, BoxLayout.PAGE_AXIS));
        myMixInsColumn.add(MIX_INS_LABEL);
        
        //creates check boxes
        final JCheckBox berryLemon = new JCheckBox("Berry Lemon");
        final JCheckBox bananaCherry = new JCheckBox("Banana Cherry");
        final JCheckBox grapeOrange = new JCheckBox("Grape Orange");
        final JCheckBox appleCoconut = new JCheckBox("Apple Coconut");
        
        //adds the check boxes to the panel
        myMixInsColumn.add(berryLemon);
        myMixInsColumn.add(bananaCherry);
        myMixInsColumn.add(grapeOrange);
        myMixInsColumn.add(appleCoconut);
        
        //sets check box backgrounds to be transparent
        berryLemon.setOpaque(false);
        bananaCherry.setOpaque(false);
        grapeOrange.setOpaque(false);
        appleCoconut.setOpaque(false);
        
        myMixInsColumn.setOpaque(false);
        
        //sets check box text colors
        berryLemon.setForeground(Color.YELLOW);
        bananaCherry.setForeground(Color.PINK);
        grapeOrange.setForeground(Color.ORANGE);
        appleCoconut.setForeground(Color.WHITE);
        
        myMixInsColumn.setBorder(BORDER);
    }
    
    /**
     * Sets up each of the columns for the center panel.
     */
    private void setUpColumns() {
        sizeColumn();
        coneTypeColumn();
        flavorColumn();
        mixInsColumn();
    }
    
}