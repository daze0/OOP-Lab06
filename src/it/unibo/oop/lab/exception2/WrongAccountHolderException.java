package it.unibo.oop.lab.exception2;

public class WrongAccountHolderException extends IllegalArgumentException {
	
	private static final long serialVersionUID = 10029291818293L;
	
	private final int usrID;
	
	public WrongAccountHolderException(int userID) {
		super();
		this.usrID = userID;
	}
	
	public String toString() {
		return "WrongAccountHolderException userID shall not be " + usrID;
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
