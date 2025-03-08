package e1;

public interface BankAccountFactory {
    BankAccount createBronzeAccount();

    BankAccount createSilverAccount();

    BankAccount createGoldAccount();

    BankAccount createAccount(FeeCalculator feeCalculator, OverdraftPolicy overdraftPolicy);
}
