package accounts;

/**
 * Created by MyPc on 29.12.2016.
 */
public class SavingAccount extends Account{//накопительный счет

    public SavingAccount(double balance) {
        super(balance);
    }


    @Override
    public String toString() {
        return "accounts.SavingAccount{" +
                "balance=" + getBalance() +
                '}';
    }
}
