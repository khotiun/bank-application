package ua.spalah.bank.services.iml;

import ua.spalah.bank.models.*;
import ua.spalah.bank.services.BankReportService;

import java.util.Comparator;
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
            for (Account account : client.getAccounts()) {
                sum += account.getBalance();
            }
        }
        return sum;
    }

    @Override
    public double getBankCreditSum(Bank bank) {
        double sumCredit = 0;
        for (Client client : bank.getClients()) {
            for (Account account : client.getAccounts()) {
                if (account.getType().equals(AccountType.CHECKING)) {
                    CheckingAccount checkingAccount = (CheckingAccount) account;
                    sumCredit += checkingAccount.getOverdraft();
                }
            }
        }
        return sumCredit;
    }

    @Override
    public List<Client> getClientsSortedByName(Bank bank) {
        List<Client> clients = bank.getClients();
        clients.sort(new Comparator<Client>() {
            @Override
            public int compare(Client client1, Client client2) {
                return client1.getName().compareTo(client2.getName());
            }
        });
        return clients;
    }
}