package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.exception.NotEnoughFundsException;
import ua.spalah.bank.services.iml.AccountServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 18.01.2017.
 */
public class WithdrawCommand implements Command {//снимает деньги с активного счета текущего клиента

    private AccountServiceImpl accountService;

    public WithdrawCommand(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @Override
    public void execute() {
        System.out.println("Enter the amount you want to withdraw :");//Введите сумму которую хотите снять
        Scanner scanner = new Scanner(System.in);
        int withdraw = Integer.parseInt(scanner.nextLine());
        try {
            accountService.withdraw(BankCommander.currentClient.getActiveAccount(),withdraw);
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void printCommandInfo() {
        System.out.println("for get Withdraw command");
    }

    @Override
    public boolean selectCurentClient() {
        return true;
    }
}
