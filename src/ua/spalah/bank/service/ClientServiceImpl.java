package ua.spalah.bank.service;

import ua.spalah.bank.Bank;
import ua.spalah.bank.Client;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPc on 05.01.2017.
 */
public class ClientServiceImpl  implements ClientService{
    @Override
    public Client findClientByName(Bank bank, String name) {
        ArrayList<Client> allClient = bank.getClients();
        for (Client client :bank.getClients()) {
            if (client.getName().equals(name))
                return client;

        }
        return null;
    }

    @Override
    public List<Client> findAllClients(Bank bank) {
        return bank.getClients();
    }

    @Override
    public Client saveClient(Bank bank, Client client) {
        bank.addClient(client);
        return client;
    }

    @Override
    public void deleteClient(Bank bank, Client client) {
        bank.deleteClient(client);
    }
}
