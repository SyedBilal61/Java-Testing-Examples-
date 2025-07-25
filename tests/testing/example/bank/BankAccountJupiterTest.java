package testing.example.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tests for BankAccount")
public class BankAccountJupiterTest {

    @Test
    void testIdsAreIncremental() {
        BankAccount firstAccount = new BankAccount();
        BankAccount secondAccount = new BankAccount();

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

    @Nested
    @DisplayName("Tests for Bank operations")
    class BankNestedExampleTest {

        private Bank bank;

        @BeforeEach
        void setup() {
            bank = new Bank();
        }

        @Nested
        @DisplayName("Happy cases")
        class HappyCases {

            @Test
            @DisplayName("Open a new bank account")
            void testOpenNewAccountShouldReturnAPositiveIdAndStoreTheAccount() {
                int id = bank.openNewBankAccount(100);
                assertTrue(id > 0);
            }

            @Test
            @DisplayName("Increment balance with 'deposit'")
            void testDepositWhenAccountIsFoundShouldIncrementBalance() {
                int id = bank.openNewBankAccount(50);
                bank.deposit(id, 30);
                // Assuming BankAccount has a getBalance method accessible via bank
