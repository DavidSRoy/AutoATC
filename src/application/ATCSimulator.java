package application;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ATCSimulator implements IRealWorldSimulator {
	int width = 10;
    int height = 10;
	public B74 bigJet = new B74();

	@Override
	public void update() {
		
		width++;
		height++;
		bigJet.setSpeed(300);
	}

	@Override
	public void draw(Canvas canvas) {
		double canvasHeight = canvas.getHeight();
        double canvasWidth = canvas.getWidth();
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0.0, 0.0, canvasWidth, canvasHeight);
        
        
        
		gc.setFill(Color.RED);
		gc.fillRect(0, 0, width, height);
		
		
	}

}
