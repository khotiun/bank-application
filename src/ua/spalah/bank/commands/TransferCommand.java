package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.exception.ClientNotFoundException;
import ua.spalah.bank.exception.NotEnoughFundsException;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.services.iml.AccountServiceImpl;
import ua.spalah.bank.services.iml.ClientServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 18.01.2017.
 */
public class TransferCommand implements Command {//переводит деньги с активно счета текущего клиента на активный счет клиента, имя которого укажет пользователь

    private AccountServiceImpl accountService;
    private ClientServiceImpl clientService;

    public TransferCommand(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter the name of the client on whose account you want to transfer money :");//Введите имя клиента на счет которого вы хотите перевести деньги
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Client toClient;
        try {
            toClient = clientService.findClientByName(BankCommander.currentBank, name);
            System.out.println("Enter the amount you want to transfer :");//Введите сумму которую хотите перевести
            double sum = Integer.parseInt(scanner.nextLine());
            try {
                accountService.transfer(BankCommander.currentClient.getActiveAccount(), toClient.getActiveAccount(),sum);
            } catch (NotEnoughFundsException e) {
                System.out.println(e.getMessage());
            }
        } catch (ClientNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("Enter \"6\" for get Transfer command");
    }
}
