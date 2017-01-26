package ua.spalah.bank.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPc on 28.12.2016.
 */
public class Bank {
    private List<Client> clients = new ArrayList<>();

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Client> getClients() {
        return clients;
    }
}
