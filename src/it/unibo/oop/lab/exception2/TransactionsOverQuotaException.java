package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends IllegalStateException {

	private static final long serialVersionUID = 98829183322625521L;
	
	private final int nTransactions;
	private final int maxTransactions;
	
	public TransactionsOverQuotaException(int nTransactions, int maxTransactions) {
		super();
		this.nTransactions = nTransactions;
		this.maxTransactions = maxTransactions;
	}

	public String toString() {
		return "TransactionsOverQuotaException nTransactions=" + nTransactions + " > maxTransactions=" + maxTransactions;
	}
	
	public String getMessage() {
		return this.toString();
	}
	
}
