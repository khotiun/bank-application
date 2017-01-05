import java.util.ArrayList;

/**
 * Created by MyPc on 28.12.2016.
 */
public class Bank {
    private ArrayList<Client> clients = new ArrayList<>();

    public void addClient(Client client) {
        clients.add(client);
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
