package application;


import application.aircraft.*;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class ATCSimulator implements IRealWorldSimulator {
	int width = 10;
    int height = 10;
    public static String[] callsigns = {"AAL","ASA","DAL", "KAL", "SWA", "UAL", "WJA"};
    public static int airspaceFreq = 0;
	public B74 bigJet = new B74("XXX001");
	
	
	
	public static String flight = callsigns[(int) Math.floor(Math.random() * callsigns.length)] + (int)Math.floor(Math.random() *1000);
	
    
	
	
	public void addAircraft() {
		
		if (airspaceFreq < 10) {
			int i = (int) Math.floor(Math.random() * 1);
			if (i == 0) {
				new B74(flight);
				airspaceFreq++;
				
				
			} else {
				new Aircraft(flight);
				airspaceFreq++;
			}
		}
	}

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
        int z = 0;
        if (airspaceFreq < 10) {
			
        	new B74(flight);
			airspaceFreq++;
			int x = (int) Math.floor(Math.random() * 50);
			gc.fillRect(x, 0, 5, 5);
				
		}
        
		
		
		
		
	}

	
}


