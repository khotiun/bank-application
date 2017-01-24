package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.services.iml.AccountServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 18.01.2017.
 */
public class DepositCommand implements Command {//кладет введенную пользователем сумму денег на активный счет текущего клиента

    private AccountServiceImpl accountService;

    public DepositCommand(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter the amount you want to deposit :");//Введите сумму которую хотите положить на счет
        Scanner scanner = new Scanner(System.in);
        int  amount = scanner.nextInt();
        try {
            accountService.deposit(BankCommander.currentClient.getActiveAccount(), amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printCommandInfo() {
        System.out.println("for get Deposit command");
    }

    @Override
    public boolean selectCurentClient() {
        return false;
    }
}
