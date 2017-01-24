package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;

/**
 * Created by MyPc on 18.01.2017.
 */
public class GetAccountsCommand implements Command{//выводит список счетов текущего клиента помечая активный



    @Override
    public void execute() {

        System.out.println(BankCommander.currentClient.getAccounts());
        System.out.println("Active account " + BankCommander.currentClient.getActiveAccount());

    }

    @Override
    public void printCommandInfo() {
        System.out.println("for take Get Accounts command");
    }

    @Override
    public boolean selectCurentClient() {
        return true;
    }
}
