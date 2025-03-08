package e1.implementation;

public final class CoreBankAccount {

    private int balance = 0;

    public int getBalance() {
        return this.balance;
    }

    public void deposit(final int amount) {
        this.balance = this.balance + amount;
    }

    public void withdraw(final int amount) {
        this.balance = this.balance - amount;
    }

}
