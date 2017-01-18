package ua.spalah.bank.services;

import ua.spalah.bank.exception.ClientNotFoundException;
import ua.spalah.bank.models.Account;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;

import java.util.List;

/**
 * Created by MyPc on 05.01.2017.
 */
public interface ClientService {
    Client findClientByName(Bank bank, String name) throws ClientNotFoundException;
    List<Client> findAllClients(Bank bank);
    Client saveClient(Bank bank, Client client);
    void deleteClient(Bank bank, Client client);
    void addAccount(Account account, Client client);
    void setActiveAccount(Account account, Client client);
    double getTotalBalance(Client client);

}
