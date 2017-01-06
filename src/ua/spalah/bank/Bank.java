package ua.spalah.bank;

import ua.spalah.bank.observer.ClientRegistrationListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPc on 28.12.2016.
 */
public class Bank {
    private ArrayList<Client> clients = new ArrayList<>();
    private List<ClientRegistrationListener> listeners = new ArrayList<>();

    public void addListener(ClientRegistrationListener listener) {
        listeners.add(listener);
    }

    public void addClient(Client client) {
        clients.add(client);
        for (ClientRegistrationListener clientRegistrationListener : listeners) {
            clientRegistrationListener.onClientAdded(client);
        }
    }

    public void deleteClient(Client client) {
        if(clients.contains(client)) {
            clients.remove(client);
        }
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public String getClientInfo(String nameClient) {
        for (Client cl : clients) {
            if (cl.getName().equals(nameClient)) {
                return cl.toString();
            }
        }
        return "Такой клиент не найден!";
    }
}
