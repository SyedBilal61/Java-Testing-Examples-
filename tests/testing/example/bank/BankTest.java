package testing.example.bank;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.NoSuchElementException;

public class BankTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Bank bank;

    @Before
    public void setup() {
        bank = new Bank(); // This runs before each test
    }

    @Test
    public void testOpenNewAccountShouldReturnAPositiveId() {
        int newAccountId = bank.openNewBankAccount(0);
        assertTrue("Unexpected non-positive id: " + newAccountId, newAccountId > 0);
    }

    @Test
    public void testDepositWhenAccountIsNotFoundShouldThrow() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("No account found with id: 1");
        bank.deposit(1, 10); // No account with id 1, should throw
    }

    @Test
    public void testDepositWhenAccountIsFoundShouldNotThrow() {
        int newAccountId = bank.openNewBankAccount(10);
        bank.deposit(newAccountId, 5); // Should work, no exception
    }

    @Test
    public void testWithdrawWhenAccountIsNotFoundShouldThrow() {
        thrown.expect(NoSuchElementException.class);
        thrown.expectMessage("No account found with id: 1");
        bank.withdraw(1, 10); // Should throw
    }

    @Test
    public void testWithdrawWhenAccountIsFoundShouldNotThrow() {
        int newAccountId = bank.openNewBankAccount(10);
        bank.withdraw(newAccountId, 5); // Should work, no exception
    }
    // Checking Code Coverage Nad practice every test at every stage with the help of the book 
}
