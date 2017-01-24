package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.exception.ClientNotFoundException;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.iml.ClientServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 19.01.2017.
 */
public class RemoveClientCommand implements Command {//удаляет клиента по имени

    ClientServiceImpl clientService;

    public RemoveClientCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        System.out.println("Enter the name of the client you want to delete :");//Введите имя клиента которого хотите удалить
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            Client client = clientService.findClientByName(BankCommander.currentBank, name);
            clientService.deleteClient(BankCommander.currentBank, client);
            if(name.equals(BankCommander.currentClient.getName()))
            {
                BankCommander.currentClient = null;
            }
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("for get Remove Client command");
    }

    @Override
    public boolean selectCurentClient() {
        return false;
    }
}
