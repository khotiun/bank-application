package ua.spalah.bank.service;

import ua.spalah.bank.Bank;
import ua.spalah.bank.Client;
import ua.spalah.bank.accounts.Account;
import ua.spalah.bank.accounts.CheckingAccount;

import java.util.Collections;
import java.util.List;

/**
 * Created by MyPc on 05.01.2017.
 */
public class BankReportServiceImpl implements BankReportService {
    @Override
    public int getNumberOfClients(Bank bank) {
        return bank.getClients().size();
    }

    @Override
    public int getNumberOfAccounts(Bank bank) {
        int sumAccounts = 0;
        for (Client client : bank.getClients()) {
           sumAccounts += client.getAccounts().size();
        }
        return sumAccounts;
    }

    @Override
    public double getTotalAccountSum(Bank bank) {
        double sum = 0;
        for (Client client : bank.getClients()) {
            sum += client.getTotalBalance();
        }
        return sum;
    }

    @Override
    public double getBankCreditSum(Bank bank) {
        double sumCredit = 0;
        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                if (account.getClass().getName().toString().equals("CheckingAccount"))
                {
                    CheckingAccount checkingAccount =(CheckingAccount) account;
                    sumCredit += checkingAccount.getOverdraft();
                }

            }
        }
        return sumCredit;

    }

    @Override
    public List<Client> getClientsSortedByName(Bank bank) {
        Collections.sort(bank.getClients());
        return bank.getClients();
    }
}
