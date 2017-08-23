package application;

public class ATCRunner implements Runnable {
	private final IRealWorldSimulator simulator;
	private final ATCMechanism mechanism;
	private final Main controller;
	private boolean stop;

	public ATCRunner(ATCMechanism mechanism, IRealWorldSimulator simulator, Main controller) {
		this.simulator = simulator;
		this.controller = controller;
		this.mechanism = mechanism;
		this.stop = false;
	}
	
	public void run() {
		while (!this.stop) {
			this.simulator.update();
			this.mechanism.update();
			this.controller.refresh();
			
			try {
				Thread.sleep(20);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void stop() {
		this.stop = true;
	}
}
