package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class BankAccountTest {

    private SilverBankAccount account;

    @BeforeEach
    void init(){
        this.account = new SilverBankAccount(new CoreBankAccount());
    }

    @Test
    void testInitiallyEmpty() {
        assertEquals(0, this.account.getBalance());
    }

    @Test
    void testCanDeposit() {
        this.account.deposit(1000);
        assertEquals(1000, this.account.getBalance());
    }

    @Test
    void testCanWithdraw() {
        this.account.deposit(1000);
        this.account.withdraw(200);
        assertEquals(799, this.account.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanAvailable(){
        this.account.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(1200));
    }

}
