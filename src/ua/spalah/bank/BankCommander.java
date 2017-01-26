package ua.spalah.bank;

import ua.spalah.bank.commands.*;
import ua.spalah.bank.models.*;
import ua.spalah.bank.services.iml.AccountServiceImpl;
import ua.spalah.bank.services.iml.BankReportServiceImpl;
import ua.spalah.bank.services.iml.ClientServiceImpl;

import java.util.Scanner;

/**
 * Created by MyPc on 17.01.2017.
 */
public class BankCommander {
    // хранит в себе банк с кототорым мы работаем
    public static Bank currentBank;
    // хранит в себе клиента с которым мы работаем в данный момент
    public static Client currentClient;

    // Список команд которые мы можем выполнять
    private Command[] commands;

    public BankCommander() {
        init();
    }

    private void init() {
        // здесь проводим инициализацию банка начальными данными
        // а также создаем все необходимые объекты команд
        currentBank = new Bank();
        Client client1 = new Client("Vlad", Gender.MALE);
        Client client2 = new Client("Anton", Gender.MALE);
        Client client3 = new Client("Oly", Gender.FEMALE);
        Client client4 = new Client("Vika", Gender.FEMALE);
        Client client5 = new Client("Oleg", Gender.MALE);

        CheckingAccount checkingAccount = new CheckingAccount(5000, 2000);
        SavingAccount savingAccount1 = new SavingAccount(5000);
        SavingAccount savingAccount2 = new SavingAccount(8000);
        CheckingAccount checkingAccount1 = new CheckingAccount(4000, 1000);

        client1.setAccount(checkingAccount);
        client1.setAccount(savingAccount1);
        client2.setAccount(checkingAccount1);
        client3.setAccount(savingAccount2);
        client4.setAccount(savingAccount1);

        currentBank.getClients().add(client1);
        currentBank.getClients().add(client2);
        currentBank.getClients().add(client3);
        currentBank.getClients().add(client4);
        currentBank.getClients().add(client5);


        commands = new Command[11];

        ClientServiceImpl clientService = new ClientServiceImpl();
        AccountServiceImpl accountService = new AccountServiceImpl();
        BankReportServiceImpl bankReportService = new BankReportServiceImpl();

        AddClientCommand addClientCommand = new AddClientCommand(clientService);
        AddAccountCommand addAccountCommand = new AddAccountCommand(clientService);
        DepositCommand depositCommand = new DepositCommand(accountService);
        ExitCommand exitCommand = new ExitCommand();
        FindClientCommand findClientCommand = new FindClientCommand(clientService);
        GetAccountsCommand getAccountsCommand = new GetAccountsCommand();
        GetBankInfoCommand getBankInfoCommand = new GetBankInfoCommand(bankReportService);
        RemoveClientCommand removeClientCommand = new RemoveClientCommand(clientService);
        SelectActiveAccountCommand selectActiveAccountCommand = new SelectActiveAccountCommand();
        TransferCommand transferCommand = new TransferCommand(accountService);
        WithdrawCommand withdrawCommand = new WithdrawCommand(accountService);

        commands[0] = findClientCommand;
        commands[1] = addClientCommand;
        commands[2] = removeClientCommand;
        commands[3] = getBankInfoCommand;
        commands[4] = exitCommand;
        commands[5] = getAccountsCommand;
        commands[6] = selectActiveAccountCommand;
        commands[7] = depositCommand;
        commands[8] = withdrawCommand;
        commands[9] = transferCommand;
        commands[10] = addAccountCommand;

    }

    public void run() {
        // запускаем наше приложение
        // выводим в цикле доступные команды
        // ждем от пользователя выбора
        // после выбора команды передаем управление ей
        // вызываем ее метод execute
        Scanner scanner = new Scanner(System.in);
        while (true) {
//            for (Command command: commands) {
//                command.printCommandInfo();
//            }
            if (BankCommander.currentClient != null) {
                for (int i = 0; i < commands.length; i++) {
                    System.out.print("Enter " + (i + 1) + " ");
                    commands[i].printCommandInfo();
                }
                int choice = 0;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    commands[choice - 1].execute();
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect data entered");
                }
            } else {
                for (int i = 0; i < commands.length; i++) {
                    if(!commands[i].selectCurentClient()) {
                        System.out.print("Enter " + (i + 1) + " ");
                        commands[i].printCommandInfo();
                    }
                }
                int choice = 0;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    commands[choice - 1].execute();
                } catch (NumberFormatException e) {
                    System.out.println("Incorrect data entered");
                }
            }
        }
    }

    // запуск нашего приложения
    public static void main(String[] args) {
        BankCommander bankCommander = new BankCommander();
        bankCommander.run();
    }
}
