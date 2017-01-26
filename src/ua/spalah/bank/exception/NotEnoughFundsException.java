package ua.spalah.bank.exception;

/**
 * Created by MyPc on 12.01.2017.
 */
public class NotEnoughFundsException extends BankException {//Не хватает средств

    public NotEnoughFundsException(String message) {
        super(message);
    }

    public NotEnoughFundsException(double available) {
        super("Not enough funds, only $" + available);
    }
}
