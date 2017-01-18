package ua.spalah.bank.services;

import ua.spalah.bank.exception.NotEnoughFundsException;
import ua.spalah.bank.models.Account;

/**
 * Created by MyPc on 05.01.2017.
 */
public interface AccountService {
    void deposit(Account account, double amount);
    void withdraw(Account account, double amount) throws NotEnoughFundsException;
    void transfer(Account fromAccount, Account toAccount, double amount) throws NotEnoughFundsException;
}
