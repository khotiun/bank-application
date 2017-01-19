package ua.spalah.bank.exception;

/**
 * Created by MyPc on 12.01.2017.
 */
public class OverdraftLimitExceededException extends NotEnoughFundsException {//Овердрафт Превышен предел Исключение

    public OverdraftLimitExceededException(double available) {//доступный
        super("You exceeded your overdraft only $" + available);
    }
}
