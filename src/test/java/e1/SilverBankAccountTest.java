package e1;

import e1.implementation.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class SilverBankAccountTest {

    private BankAccount silverAccount;

    @BeforeEach
    void init() {
        final BankAccountFactory bankAccountFactory = new BankAccountFactoryImpl();
        this.silverAccount = bankAccountFactory.createSilverAccount();
    }

    @Test
    void testInitiallyEmpty() {
        assertEquals(0, this.silverAccount.getBalance());
    }

    @Test
    void testCanDeposit() {
        this.silverAccount.deposit(1000);
        assertEquals(1000, this.silverAccount.getBalance());
    }

    @Test
    void testCanWithdraw() {
        this.silverAccount.deposit(1000);
        this.silverAccount.withdraw(200);
        assertEquals(799, this.silverAccount.getBalance());
    }

    @Test
    void testCannotWithdrawMoreThanAvailable(){
        this.silverAccount.deposit(1000);
        assertThrows(IllegalStateException.class, () -> this.silverAccount.withdraw(1200));
    }

}
