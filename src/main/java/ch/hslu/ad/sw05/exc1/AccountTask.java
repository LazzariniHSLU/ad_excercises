package ch.hslu.ad.sw05.exc1;

public class AccountTask implements Runnable{
    private final BankAccount sourceAccount;
    private final BankAccount targetAccount;
    private final int amount;

    public AccountTask(final BankAccount sourceAccount, final BankAccount targetAccount, final int amount) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        this.sourceAccount.transfer(this.targetAccount, this.amount);
    }
}
