package e1;

import e1.implementation.BankAccountFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class BronzeBankAccountTest {

    private BankAccount bronzeAccount;

    @BeforeEach
    void init() {
        final BankAccountFactory bankAccountFactory = new BankAccountFactoryImpl();
        this.bronzeAccount = bankAccountFactory.createBronzeAccount();
    }

    @Test
    void testWithdrawWithZeroFee() {
        this.bronzeAccount.deposit(100);
        this.bronzeAccount.withdraw(50);
        assertEquals(50, this.bronzeAccount.getBalance());
    }

    @Test
    void testWithdrawWithFee() {
        this.bronzeAccount.deposit(500);
        this.bronzeAccount.withdraw(200);
        assertEquals(299, this.bronzeAccount.getBalance());
    }

    @Test
    void testWithdrawWithOverdraft() {
        assertThrows(IllegalStateException.class, () -> this.bronzeAccount.withdraw(200));
    }

}
