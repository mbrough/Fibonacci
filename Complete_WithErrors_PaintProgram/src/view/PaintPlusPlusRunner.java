// Molly Brougham
// Project 2
// CSS 305 A

package view;

/**
 *  The class that runs the Paint++ program.
 * 
 * @author Molly Brougham
 * @version 1.0
 */
public final class PaintPlusPlusRunner {
    
    /**
     * private constructor to prevent instantiation.
     */
    private PaintPlusPlusRunner() {
        //do nothing
    }
    
    /** 
     * entry point for the paint++ program.
     * @param theArgs argument string array
     */
    public static void main(final String[] theArgs) {
        new ArtFrame();
    }
}
