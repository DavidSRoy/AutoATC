package application.aircraft;

public class Aircraft {
	public int maxSpeed;
	public int speed;
	public int heading;
	public static String callsign;
	
	
	public Aircraft(String callsign) {
		Aircraft.callsign = callsign;
		
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
