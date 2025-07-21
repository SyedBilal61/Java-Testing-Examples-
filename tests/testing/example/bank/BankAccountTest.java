package testing.example.bank;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankAccountTest {

    @Test
    public void testIdIsAutomaticallyAssignedAsPositiveNumber() {
        // setup
        BankAccount bankAccount = new BankAccount();

        // verify
        assertTrue("Id should be positive", bankAccount.getId() > 0);
    }
    
    @Test
    public void testIdsAreIncremental() {
        BankAccount firstAccount = new BankAccount();
        BankAccount secondAccount = new BankAccount();
        assertTrue("Ids should be incremental", firstAccount.getId() < secondAccount.getId());
    }
    @Test
    public void testIdsAreIncremental() {
        BankAccount firstAccount = new BankAccount();
        BankAccount secondAccount = new BankAccount();
        assertEquals(1, firstAccount.getId());
        assertEquals(2, secondAccount.getId());
    }
    @Test
    public void testDepositWhenAmountIsCorrectShouldIncreaseBalance() {
        // Setup
        BankAccount bankAccount = new BankAccount();

        // Exercise
        bankAccount.deposit(10);

        // Verify
        assertEquals(10.0, bankAccount.getBalance(), 0.001);
    }

    @Test
    public void testDepositWhenAmountIsNegativeShouldThrow() {
        // Setup
        BankAccount bankAccount = new BankAccount();

        try {
            // Exercise
            bankAccount.deposit(-1);

            // If no exception is thrown, this line runs → test fails
            fail("Expected an IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Verify
            assertEquals("Negative amount: -1.0", e.getMessage());
            assertEquals(0, bankAccount.getBalance(), 0.001);
        }
    }

 // This will fail
    @Test
    public void testDepositWhenAmountIsNegativeShouldThrowWithExpectedException() {
        BankAccount bankAccount = new BankAccount();

        System.getProperty(""); // ❌ throws IllegalArgumentException (too early!)

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Negative amount: -1.0");

        bankAccount.deposit(-1); // ✅ this is what you wanted to test
    }

    @Test
    public void testWithdrawWhenAmountIsNegativeShouldThrow() {
        BankAccount bankAccount = new BankAccount();

        IllegalArgumentException e = assertThrows(
            IllegalArgumentException.class,
            () -> bankAccount.withdraw(-1)
        );

        assertEquals("Negative amount: -1.0", e.getMessage());
        assertEquals(0, bankAccount.getBalance(), 0);
    }

    @Test
    public void testWithdrawWhenBalanceIsInsufficientShouldThrow() {
        BankAccount bankAccount = new BankAccount();

        IllegalArgumentException e = assertThrows(
            IllegalArgumentException.class,
            () -> bankAccount.withdraw(10)
        );

        assertEquals("Cannot withdraw 10.0 from 0.0", e.getMessage());
        assertEquals(0, bankAccount.getBalance(), 0);
    }
    @Test
    public void testTrueIsTrue() {
        assertTrue(true);
    }

 // Not a very clean test! DON'T DO THAT!
    @Test
    public void testWithdrawWhenBalanceIsSufficientShouldDecreaseBalance() {
        // Arrange
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(10);

        // Act
        bankAccount.withdraw(3); // The method we want to test

        // Assert
        assertEquals(7, bankAccount.getBalance(), 0);
    }

    
    
    
}
