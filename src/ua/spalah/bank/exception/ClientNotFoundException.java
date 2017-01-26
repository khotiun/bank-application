package ua.spalah.bank.exception;

/**
 * Created by MyPc on 12.01.2017.
 */
public class ClientNotFoundException extends BankException {//Клиент уже существует исключение

    public ClientNotFoundException(String name) {
        super("Client " + name + " not found!");//Клиент не найден
    }
}
