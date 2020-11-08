package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends IllegalStateException {

	private static final long serialVersionUID = 239390211829333L;
	
	private final double balance;
	
	public NotEnoughFoundsException(double balance) {
		super();
		this.balance = balance;
	}
	
	public String toString() {
		return "NotEnoughFoundsException insufficent founds (" + balance + " euros)";
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
