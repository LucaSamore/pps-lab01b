package e1.implementation;

import e1.BankAccount;

final class CoreBankAccount implements BankAccount {

    private int balance = 0;

    @Override
    public void deposit(final int amount) {
        this.balance = this.balance + amount;
    }

    @Override
    public void withdraw(final int amount) {
        this.balance = this.balance - amount;
    }

    @Override
    public int getBalance() {
        return this.balance;
    }

}
