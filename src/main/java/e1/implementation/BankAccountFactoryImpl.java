package e1.implementation;

import e1.BankAccount;
import e1.BankAccountFactory;

public final class BankAccountFactoryImpl implements BankAccountFactory {

    @Override
    public BankAccount createBronzeAccount() {
        return new BankAccountImpl(
          new CoreBankAccount(),
            amount -> amount < 100 ? 0 : 1,
            (balance, amount) -> balance >= amount
        );
    }

    @Override
    public BankAccount createSilverAccount() {
        return new BankAccountImpl(
          new CoreBankAccount(),
          amount -> 1,
          (balance, amount) -> balance >= amount
        );
    }

    @Override
    public BankAccount createGoldAccount() {
        return new BankAccountImpl(
          new CoreBankAccount(),
          amount -> 0,
          (balance, amount) -> balance - amount >= -500
        );
    }

}
