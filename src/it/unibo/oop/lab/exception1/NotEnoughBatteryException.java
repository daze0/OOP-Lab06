package it.unibo.oop.lab.exception1;

public class NotEnoughBatteryException extends IllegalStateException {
	
	private static final long serialVersionUID = 5322262957171122503L;
	private double batteryLevel;
	
	public NotEnoughBatteryException(double batteryLevel) {
		this.batteryLevel = batteryLevel;
	}

	public String toString() {
		return "NotEnoughBatteryException: the battery level is too low(" + batteryLevel + "%)";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
