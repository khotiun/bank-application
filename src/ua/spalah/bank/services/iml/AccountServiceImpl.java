package ua.spalah.bank.services.iml;

import ua.spalah.bank.exception.NotEnoughFundsException;
import ua.spalah.bank.exception.OverdraftLimitExceededException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.CheckingAccount;
import ua.spalah.bank.services.AccountService;

/**
 * Created by MyPc on 05.01.2017.
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void deposit(Account account, double amount) {
        if (amount > 0)
            account.setBalance(account.getBalance() + amount);
        else
            throw new IllegalArgumentException("Amount can't be negative!");
    }

    @Override
    public void withdraw(Account account, double amount) throws NotEnoughFundsException {
        if (amount <= 0) throw new IllegalArgumentException("Amount can't be negative");
        switch (account.getType()) {
            case SAVING: {
                double balance = account.getBalance();
                if (balance >= amount) {
                    account.setBalance(balance - amount);
                } else {
                    throw new NotEnoughFundsException(balance);
                }
                break;
            }
            case CHECKING: {
                double available = account.getBalance() + ((CheckingAccount) account).getOverdraft();
                if (available >= amount) {
                    account.setBalance(available - amount);
                } else {
                    throw new OverdraftLimitExceededException(available);
                }
                break;
            }
            default:
                throw new IllegalArgumentException("Unknown account type");
        }


    }

    public void transfer(Account fromAccount, Account toAccount, double amount) throws NotEnoughFundsException {
        withdraw(fromAccount, amount);
        deposit(toAccount, amount);
    }
}
