package e1.implementation;

import e1.BankAccount;
import e1.FeeCalculator;
import e1.OverdraftPolicy;

final class BankAccountImpl implements BankAccount {

    private final CoreBankAccount core;
    private final FeeCalculator feeCalculator;
    private final OverdraftPolicy overdraftPolicy;

    BankAccountImpl(final CoreBankAccount core,
                    final FeeCalculator feeCalculator,
                    final OverdraftPolicy overdraftPolicy) {
        this.core = core;
        this.feeCalculator = feeCalculator;
        this.overdraftPolicy = overdraftPolicy;
    }

    @Override
    public void deposit(final int amount) {
        this.core.deposit(amount);
    }

    @Override
    public void withdraw(final int amount) {
        final var fee = this.feeCalculator.calculateFee(amount);
        final var totalWithdraw = amount + fee;
        if (!this.overdraftPolicy.canWithdraw(this.getBalance(), totalWithdraw)) {
            throw new IllegalStateException("Withdrawal not allowed");
        }
        this.core.withdraw(totalWithdraw);
    }

    @Override
    public int getBalance() {
        return this.core.getBalance();
    }

}
