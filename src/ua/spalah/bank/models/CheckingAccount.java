package ua.spalah.bank.models;

/**
 * Created by MyPc on 29.12.2016.
 */
public class CheckingAccount extends SavingAccount {//кредитный счет

    private double overdraft;//кредитный лимит

    public CheckingAccount(double balance, double overdraft) {
        super(balance);
        if (overdraft < 0) {
            System.out.println("Кредитный лимит не может быть отрицфтельной ссумой!");
        } else {
            this.overdraft = overdraft;
        }
    }

    @Override
    public AccountType getType() {
        return AccountType.CHECKING;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "overdraft=" + overdraft +
                "balance=" + getBalance() +
                '}';
    }
}
