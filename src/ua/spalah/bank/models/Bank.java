package ua.spalah.bank.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MyPc on 28.12.2016.
 */
public class Bank {
    private Map<String,Client> clients = new HashMap<>();

    public void setClients(Map<String,Client> clients) {
        this.clients = clients;
    }

    public Map<String,Client> getClients() {
        return clients;
    }
}
