package e1;

@FunctionalInterface
public interface OverdraftPolicy {
    boolean canWithdraw(int balance, int withdrawalAmount);
}
