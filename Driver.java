

/**
 * This is the driver class used to run 
 * the calculator.
 */
public class Driver {

    /**
     * The main entry point into the application.
     *
     * @param args The command line arguments
     */
    public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
                Calculator.createAndShowGUI();
	    } // run
	});
    } // main

} // Driver