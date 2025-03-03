package e1;

public final class SilverBankAccount implements BankAccount {

    private final CoreBankAccount base;

    public SilverBankAccount(final CoreBankAccount base) {
        this.base = base;
    }

    @Override
    public void deposit(final int amount) {
        this.base.deposit(amount);
    }

    @Override
    public void withdraw(final int amount) {
        if (this.getBalance() < amount){
            throw new IllegalStateException();
        }
        this.base.withdraw(amount + 1);
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

}
