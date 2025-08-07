package testing.example.bank;

import static org.junit.Assert.*;
import org.junit.Test;

public class SimpleBankAccountTest {

    @Test
    public void testDepositWhenAmountIsCorrectShouldIncreaseBalance() {
        SimpleBankAccount bankAccount = new SimpleBankAccount(5);
        bankAccount.deposit(10);
        assertEquals(15, bankAccount.getBalance(), 0);
    }

 // Add this new test case:
    @Test
    public void testDepositWhenAmountIsZeroShouldThrow() {
        SimpleBankAccount bankAccount = new SimpleBankAccount();
        try {
            bankAccount.deposit(0);
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative amount: 0.0", e.getMessage());
            assertEquals(0, bankAccount.getBalance(), 0);
        }
    }

}
