package ua.spalah.bank.commands;

/**
 * Created by MyPc on 19.01.2017.
 */
public class ExitCommand implements Command {//прекращает выполнение программы
    @Override
    public void execute() {
        System.exit(0);
    }

    @Override
    public void printCommandInfo() {
        System.out.println("for get Exit command");
    }

    @Override
    public boolean selectCurentClient() {
        return false;
    }
}
