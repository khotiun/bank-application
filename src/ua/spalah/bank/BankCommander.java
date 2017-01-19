package ua.spalah.bank;

import ua.spalah.bank.commands.*;
import ua.spalah.bank.models.Bank;
import ua.spalah.bank.models.Client;
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
        commands[1] = getAccountsCommand;
        commands[2] = selectActiveAccountCommand;
        commands[3] = depositCommand;
        commands[4] = withdrawCommand;
        commands[5] = transferCommand;
        commands[6] = addClientCommand;
        commands[7] = addAccountCommand;
        commands[8] = removeClientCommand;
        commands[9] = getBankInfoCommand;
        commands[10] = exitCommand;

    }

    public void run() {
        // запускаем наше приложение
        // выводим в цикле доступные команды
        // ждем от пользователя выбора
        // после выбора команды передаем управление ей
        // вызываем ее метод execute
        Scanner scanner = new Scanner(System.in);
        while (true){
            for (Command command: commands) {
                command.printCommandInfo();
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

    // запуск нашего приложения
    public static void main(String[] args) {
        BankCommander bankCommander = new BankCommander();
        bankCommander.run();
    }
}
