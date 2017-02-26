/*
 * TCSS 305
 */
import java.awt.EventQueue;

/**
 * Runner of the Notepad program.
 * 
 * @author Monika
 * @version Autumn 2013
 */
public final class EditorMain {
    
    /**
     * Private constructor to inhibit instantiation.
     */
    private EditorMain() {
        throw new IllegalStateException();
    }

  /**
   * Start point for the program.
   * 
   * @param theArgs command line arguments - ignored
   */
    public static void main(final String... theArgs) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI(); // create the graphical user interface
            }
        });
    }

}