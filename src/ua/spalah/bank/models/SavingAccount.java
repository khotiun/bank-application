package ua.spalah.bank.models;

/**
 * Created by MyPc on 29.12.2016.
 */
public class SavingAccount implements Account {//накопительный счет

    private double balance;

    public SavingAccount(double balance) {
        if (balance < 0)
            return;
        this.balance = balance;
    }

    @Override
    public AccountType getType() {
        return AccountType.SAVING;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "balance=" + balance +
                '}';
    }
}
