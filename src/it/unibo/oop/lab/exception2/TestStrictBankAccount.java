package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

	private static final int TRANSACTIONS = 100;
    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	AccountHolder lucaBianchi = new AccountHolder("Luca", "Bianchi", 1);
    	AccountHolder marioRossi = new AccountHolder("Mario", "Rossi", 2);
    	
    	BankAccount accountLuca = new StrictBankAccount(1, 10000, 10);
    	BankAccount accountMario = new StrictBankAccount(2, 10000, 10);
    	
    	try {
    		accountLuca.deposit(1, 500);
    		
    		accountLuca.deposit(2, 500);
    		
    		fail("The program execution shouldn't go this far!");
    	} catch(WrongAccountHolderException wah) {
    		assertNotNull(wah);
    		System.out.println(wah.getMessage());
    	}
    	
    	try {
    		accountMario.withdraw(2, 9000);
    		
    		accountMario.withdraw(2, 5000);
    		
    		fail("The program execution shouldn't go this far!");
    	} catch(NotEnoughFoundsException nef) {
    		assertNotNull(nef);
    		System.out.println(nef.getMessage());
    	}
    	
    	try {
    		for(int i = 1; i <= TRANSACTIONS; i++) {
    			accountLuca.depositFromATM(1, i);
    			accountMario.withdrawFromATM(2, i);
    		}
    	} catch(TransactionsOverQuotaException toq) {
    		assertNotNull(toq);
    		System.out.println(toq.getMessage());
    	}
    	
    	
    }
}
