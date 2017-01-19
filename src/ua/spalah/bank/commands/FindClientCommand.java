package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.exception.ClientNotFoundException;
import ua.spalah.bank.services.iml.ClientServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 18.01.2017.
 */
public class FindClientCommand implements Command {

    private ClientServiceImpl clientService;

    public FindClientCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the name of the client :"); //Введите имя клиента
        String name =  reader.nextLine();
        try {
           BankCommander.currentClient = clientService.findClientByName(BankCommander.currentBank,name);
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"1\" for get Find Client command");//Найти клиента
    }
}
