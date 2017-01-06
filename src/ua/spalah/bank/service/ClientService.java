package ua.spalah.bank.service;

import ua.spalah.bank.Bank;
import ua.spalah.bank.Client;

import java.util.List;

/**
 * Created by MyPc on 05.01.2017.
 */
public interface ClientService {
    Client findClientByName(Bank bank, String name);
    List<Client> findAllClients(Bank bank);
    Client saveClient(Bank bank, Client client);
    void deleteClient(Bank bank, Client client);
}