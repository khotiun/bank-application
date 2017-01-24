package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.models.Gender;
import ua.spalah.bank.services.iml.ClientServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 18.01.2017.
 */
public class AddClientCommand implements Command {//добавляет нового клиента, получая полную информацию о нем у пользователя, делает этого клиента текущим

    private ClientServiceImpl clientService;

    public AddClientCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        Client client;
        System.out.println("Enter the name of the client:");//Введите имя клиента :
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Enter gender: MALE or FEMALE");//Введите пол клиента
        String gender = scanner.nextLine().toUpperCase();
        if(gender.equals("MALE"))
        {
            BankCommander.currentClient = clientService.saveClient(BankCommander.currentBank, new Client(name, Gender.MALE));
        }
        else if (gender.equals("FEMALE"))
        {
            BankCommander.currentClient = clientService.saveClient(BankCommander.currentBank, new Client(name, Gender.FEMALE));
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("for get add Client command");
    }

    @Override
    public boolean selectCurentClient() {
        return false;
    }
}
