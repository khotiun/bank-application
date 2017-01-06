package ua.spalah.bank.accounts;

/**
 * Created by MyPc on 29.12.2016.
 */
public class CheckingAccount extends Account{//кредитный счет

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
    public void withdraw(double money) {
        double available = getBalance() + overdraft;//доступные денежные средства
        if (available < money) {
            System.out.println("Превышен лимит снятия средств!");
        } else {
            setBalance(getBalance() - money);
        }
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "balance=" + getBalance() +
                "overdraft=" + overdraft +
                '}';
    }

    public double getOverdraft() {
        return overdraft;
    }
}
