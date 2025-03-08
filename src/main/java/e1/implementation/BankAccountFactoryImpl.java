package e1.implementation;

import e1.BankAccount;
import e1.BankAccountFactory;
import e1.FeeCalculator;
import e1.OverdraftPolicy;

public final class BankAccountFactoryImpl implements BankAccountFactory {

    private static final int OVERDRAFT_LIMIT = 500;
    private static final int BRONZE_FEE_THRESHOLD = 100;
    private static final int BRONZE_FEE = 1;
    private static final int SILVER_FEE = 1;
    private static final int NO_FEE = 0;

    private enum AccountType {

        BRONZE(
            amount -> amount < BRONZE_FEE_THRESHOLD ? NO_FEE : BRONZE_FEE,
            (balance, amount) -> balance >= amount
        ),

        SILVER(
            amount -> SILVER_FEE,
            (balance, amount) -> balance >= amount
        ),

        GOLD(
            amount -> NO_FEE,
            (balance, amount) -> balance - amount >= -OVERDRAFT_LIMIT
        );

        private final FeeCalculator feeCalculator;
        private final OverdraftPolicy overdraftPolicy;

        AccountType(final FeeCalculator feeCalculator,
                    final OverdraftPolicy overdraftPolicy) {
            this.feeCalculator = feeCalculator;
            this.overdraftPolicy = overdraftPolicy;
        }

        public BankAccount createAccount() {
            return new BankAccountImpl(
                new CoreBankAccount(),
                feeCalculator,
                overdraftPolicy
            );
        }
    }

    @Override
    public BankAccount createBronzeAccount() {
        return AccountType.BRONZE.createAccount();
    }

    @Override
    public BankAccount createSilverAccount() {
        return AccountType.SILVER.createAccount();
    }

    @Override
    public BankAccount createGoldAccount() {
        return AccountType.GOLD.createAccount();
    }

    @Override
    public BankAccount createAccount(final FeeCalculator feeCalculator,
                                     final OverdraftPolicy overdraftPolicy) {
        return new BankAccountImpl(new CoreBankAccount(), feeCalculator, overdraftPolicy);
    }

}
