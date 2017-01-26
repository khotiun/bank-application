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
        if (gender.equals("MALE")) {
            BankCommander.currentClient = clientService.saveClient(BankCommander.currentBank, new Client(name, Gender.MALE));
            while (true) {
                System.out.println("Enter your e-mail client:");//Введите почту клиента:
                String mail = scanner.nextLine();
                boolean bMail = mail.matches("[a-zA-Z0-9.]{1,50}@[a-zA-Z0-9.]{1,50}\\.[a-zA-Z0-9.]{2,5}");
                if (bMail) {
                    BankCommander.currentClient.setEmail(mail);
                    break;
                } else {
                    System.out.println("Mail is invalid!");//Почта введена не коректно!
                }
            }
            while (true) {
                System.out.println("Enter the customer's phone number:");//Введите телефон клиента:
                String phone = scanner.nextLine();
                boolean bPhone = phone.matches("[0-9+]{5,13}");
                if (bPhone) {
                    BankCommander.currentClient.setEmail(phone);
                    break;
                } else {
                    System.out.println("Client telephone is invalid!");//Телефон клиента введен не коректно!
                }
            }
            System.out.println("Enter the city where the client resides:");//Введите город, где проживает клиент:
            String city = scanner.nextLine();
            BankCommander.currentClient.setCity(city);
        } else if (gender.equals("FEMALE")) {
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
