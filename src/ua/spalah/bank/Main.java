package ua.spalah.bank;

import ua.spalah.bank.models.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MyPc on 28.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client client1 = new Client("Vlad", Gender.MALE);
        Client client2 = new Client("Anton", Gender.MALE);
        Client client3 = new Client("Oly", Gender.FEMALE);
        Client client4 = new Client("Vika", Gender.FEMALE);
        Client client5 = new Client("Oleg", Gender.MALE);
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        clients.add(client4);
        clients.add(client5);

        bank.setClients(clients);

        CheckingAccount checkingAccount = new CheckingAccount(5000, 2000);
        SavingAccount savingAccount1 = new SavingAccount(5000);
        SavingAccount savingAccount2 = new SavingAccount(8000);
        CheckingAccount checkingAccount1 = new CheckingAccount(4000, 1000);


//        PrintClientListener printClientListener = new PrintClientListener();
//        EmailNotificationListener emailNotificationListener = new EmailNotificationListener();
//        RegistrationLoggerListener registrationLoggerListener = new RegistrationLoggerListener();
//
//        bank.addListener(printClientListener);
//        bank.addListener(emailNotificationListener);
//        bank.addListener(registrationLoggerListener);
//
//        Client client1 = new Client("Vlad", Gender.MALE);
//        Client client2 = new Client("Anton",Gender.MALE);
//        Client client3 = new Client("Oly",Gender.FEMALE);
//        Client client4 = new Client("Vika",Gender.FEMALE);
//        Client client5 = new Client("Oleg",Gender.MALE);
//
//        bank.addClient(client1);
//        bank.addClient(client2);
//        bank.addClient(client3);
//        bank.addClient(client4);
//        bank.deleteClient(client1);
//
//        SavingAccount savingAccount = new SavingAccount(10000);
//        CheckingAccount checkingAccount = new CheckingAccount(5000,2000);
//        SavingAccount savingAccount1 = new SavingAccount(5000);
//        SavingAccount savingAccount2 = new SavingAccount(8000);
//        CheckingAccount checkingAccount1 = new CheckingAccount(4000,1000);
//
//        client1.addAccount(savingAccount);
//        client1.addAccount(checkingAccount);
//        client2.addAccount(savingAccount1);
//        client3.addAccount(savingAccount2);
//        client4.addAccount(checkingAccount1);
//
//        BankReportServiceImpl qwe = new BankReportServiceImpl();
//        qwe.getClientsSortedByName(bank);
//        for (Client allClient:
//             bank.getClients()) {
//            System.out.println(allClient);
//        }
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите имя клиента :  ");
//        String name = scanner.nextLine();
//        System.out.println(bank.getClientInfo(name));

    }

}
