/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package view;

/**
 * Main runner for the List Sorter program.
 * @author Molly Brougham
 * @version 1.0
 *
 */
public final class Main {
    
    /**
     * Private constructor to inhibit instantiation.
     */
    private Main() {
        throw new IllegalStateException();
    }
    
    /** 
     * Main start point for the program.
     * @param theArgs command line arguments - ignored
     */
    public static void main(final String[] theArgs) {
        new ListSorterGUI();

    }

}
