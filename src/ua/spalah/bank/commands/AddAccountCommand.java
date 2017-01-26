package ua.spalah.bank.commands;

import ua.spalah.bank.BankCommander;
import ua.spalah.bank.models.CheckingAccount;
import ua.spalah.bank.models.SavingAccount;
import ua.spalah.bank.services.iml.ClientServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 18.01.2017.
 */
public class AddAccountCommand implements Command {//добавляет счет текущему клиенту, спрашивая всю информацию о счете у пользователя (если у клиента нет счетов, делаем этот активным, если уже есть, то прелагаем сделать его активным опционально)

    private ClientServiceImpl clientService;

    public AddAccountCommand(ClientServiceImpl clientService) {
        this.clientService = clientService;
    }

    @Override
    public void execute() {
        System.out.println("Add account to new client. SAVING or CHECKING?");//Добавить вид счета: сберегательный или кредитный
        Scanner scanner = new Scanner(System.in);
        String typeAccount = scanner.nextLine().toUpperCase();
        if (typeAccount.equals("SAVING")) {
            System.out.println("Enter the amount that will be on the account :");//Введите сумму которая будет на счету
            double amount = Double.parseDouble(scanner.nextLine());
            SavingAccount savingAccount = new SavingAccount(amount);
            clientService.addAccount(savingAccount, BankCommander.currentClient);
            if (BankCommander.currentClient.getAccounts().size() == 1) {
                BankCommander.currentClient.setActiveAccount(savingAccount);
            } else {
                System.out.println("Make this account active. YES or NO?");//Сделать этот счет активным. да или нет?
                String answer = scanner.nextLine();
                if (answer.equals("YES")) {
                    BankCommander.currentClient.setActiveAccount(savingAccount);
                }
            }
        } else if (typeAccount.equals("CHECKING")) {
            System.out.println("Enter the amount that will be on the account :");//Введите сумму которая будет на счету
            double balance = Double.parseDouble(scanner.nextLine());
            System.out.println("Enter the overdraft that will be on the account :");//Введите перелимит которая будет на счету
            double overdraft = Double.parseDouble(scanner.nextLine());
            CheckingAccount checkingAccount = new CheckingAccount(balance, overdraft);
            if (BankCommander.currentClient.getAccounts().size() == 1) {
                BankCommander.currentClient.setActiveAccount(checkingAccount);
            } else {
                System.out.println("Make this account active. YES or NO?");//Сделать этот счет активным. да или нет?
                String answer = scanner.nextLine();
                if (answer.equals("YES")) {
                    BankCommander.currentClient.setActiveAccount(checkingAccount);
                }
            }
        }

    }

    @Override
    public void printCommandInfo() {
        System.out.println("for get Add Account command");
    }

    @Override
    public boolean selectCurentClient() {
        return true;
    }
}
