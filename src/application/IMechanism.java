package application;

public interface IMechanism {
	/**
	 * The controller defines the logic that controls a mechanism given inputs (component) and driver-requested actions, and 
	 * translates those into the abstract functions that should be applied to the outputs (component).
	 * 
	 * @author Will
	 *
	 */
	
	    /**
	     * calculate the various outputs to use based on the inputs and apply them to the outputs for the relevant component
	     */
	    public void update();

	    /**
	     * stop the relevant component
	     */
	    public void stop();
}
