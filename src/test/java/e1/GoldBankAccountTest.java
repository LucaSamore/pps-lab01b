package e1;

import e1.implementation.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class GoldBankAccountTest {

    private BankAccount goldAccount;

    @BeforeEach
    void init() {
        final BankAccountFactory bankAccountFactory = new BankAccountFactoryImpl();
        this.goldAccount = bankAccountFactory.createGoldAccount();
    }

    @Test
    void testWithdraw() {
        this.goldAccount.deposit(1000);
        this.goldAccount.withdraw(100);
        assertEquals(900, this.goldAccount.getBalance());
    }

    @Test
    void testOverdraft() {
        this.goldAccount.withdraw(500);
        assertEquals(-500, this.goldAccount.getBalance());
    }

    @Test
    void testWithdrawMoreThanOverdraft() {
        assertThrows(IllegalStateException.class, () -> this.goldAccount.withdraw(1000));
    }
}
