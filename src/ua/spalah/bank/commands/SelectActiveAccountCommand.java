package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.models.Account;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MyPc on 18.01.2017.
 */
public class SelectActiveAccountCommand implements Command {//позволяет выбрать активный счет для текущего клиента

    @Override
    public void execute() {


        ArrayList<Account> accounts = BankCommander.currentClient.getAccounts();
        System.out.println(BankCommander.currentClient.getAccounts());
        System.out.println("Active account - " + BankCommander.currentClient.getActiveAccount());
        System.out.println("Select an active account for the current client: ");//Выберите активный счет для текущего клиента
        Scanner scanner = new Scanner(System.in);
        try {
            int numberAccount = Integer.parseInt(scanner.nextLine());
            BankCommander.currentClient.setActiveAccount(accounts.get(numberAccount - 1));
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public void printCommandInfo() {
        System.out.println("for get Select Active Account command");
    }

    @Override
    public boolean selectCurentClient() {
        return true;
    }
}
