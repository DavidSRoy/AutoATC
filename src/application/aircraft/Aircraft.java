package application.aircraft;

import application.ATCSimulator;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Aircraft {
	public int maxSpeed;
	public int speed;
	public int heading;
	public int altitude;
	public static String callsign;
	public Canvas canvas;
	
	
	public Aircraft(String callsign) {
		Aircraft.callsign = callsign;
		/*int x = 10;
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.RED);
		gc.fillRect(x, 0, 5, 5);*/
		
	}
	
	
	
	//Speeds are in knots
	
	public void setMaxSpeed(int mxSpeed) {
		maxSpeed = mxSpeed;
	}
	
	public void setSpeed(int newSpeed) {
		if (newSpeed > maxSpeed) {
			speed = maxSpeed;
		} else {
		speed = newSpeed;
		}
		
	}
	
	public void turn(int degrees) {
		
		heading += degrees;
		
		if (heading < 0) {
			heading = 360 - (heading * -1);
		}
	}
	
	public void newHeading (int newHeading) {
		heading = newHeading;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getHeading() {
		return heading;
	}
	
}
