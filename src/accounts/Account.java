package accounts;

/**
 * Created by MyPc on 29.12.2016.
 */
public abstract class Account {
   private double balance;

    public Account(double balance) {
        if (balance < 0) {
            System.out.println("Вносимая сумма меньше 0");
        } else {
            this.balance = balance;
        }
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double money) {
        balance = money;
    }

    public void deposit(double money) {//добавить деньги на счет
        if (money <= 0) {
            System.out.println("Вносимая сумма должна быть больше 0!");
        } else {
            balance += money;
        }
    }

    public void withdraw(double money) {//снять деньги со счета
        if (money > balance) {
            System.out.println("Не достаточно денег!");
        } else {
            balance -= money;
        }
    }

    public abstract String toString();

}
