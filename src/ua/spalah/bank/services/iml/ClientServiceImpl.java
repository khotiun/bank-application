package ua.spalah.bank.services.iml;

import ua.spalah.bank.exception.ClientNotFoundException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.ClientService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPc on 05.01.2017.
 */
public class ClientServiceImpl implements ClientService {

    @Override
    public Client findClientByName(Bank bank, String name) throws ClientNotFoundException {
        List<Client> allClient = bank.getClients();
        for (Client client : bank.getClients()) {
            if (client.getName().equals(name))
                return client;

        }
       throw  new ClientNotFoundException(name);
    }

    @Override
    public List<Client> findAllClients(Bank bank) {
        return bank.getClients();
    }

    @Override
    public Client saveClient(Bank bank, Client client) {
        bank.getClients().add(client);
        return client;
    }

    @Override
    public void deleteClient(Bank bank, Client client) {
        List<Client> clients = bank.getClients();
        if (clients.contains(client))
            clients.remove(client);
    }

    @Override
    public void addAccount(Account account, Client client) {
        client.getAccounts().add(account);
    }

    @Override
    public void setActiveAccount(Account account, Client client) {
        ArrayList<Account> accounts = client.getAccounts();
        if (accounts.contains(account))
        client.setActiveAccount(account);
    }

    @Override
    public double getTotalBalance(Client client) {
        int allBalance = 0;
        for ( Account account: client.getAccounts()) {
            allBalance += account.getBalance();
        }
        return allBalance;
    }
}
