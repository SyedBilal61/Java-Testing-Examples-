 package testing.example.bank;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountJupiterTest {

    @Test
    void test() {
        fail("Not yet implemented");  // Optional: delete this if not needed
    }

    @Test
    void testIdsAreIncremental() {
        // Arrange
        BankAccount firstAccount = new BankAccount();
        BankAccount secondAccount = new BankAccount();

        // Act & Assert
        assertTrue(firstAccount.getId() < secondAccount.getId(),
            () -> "IDs were expected to be incremental, but " +
                  firstAccount.getId() + " is not less than " +
                  secondAccount.getId());
    }
    @Test
    void testDepositWhenAmountIsNegativeShouldThrow() {
        BankAccount bankAccount = new BankAccount();
        
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, 
            () -> bankAccount.deposit(-1));
        
        assertEquals("Negative amount: -1.0", e.getMessage());
        assertEquals(0, bankAccount.getBalance(), 0);
    }

}
