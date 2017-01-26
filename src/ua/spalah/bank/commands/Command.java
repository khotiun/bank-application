package ua.spalah.bank.commands;

/**
 * Created by MyPc on 18.01.2017.
 */
public interface Command {
    // взаимодействует с клиетом читая его ввод с консоли и печатая ему ответы
    void execute();//выполнить

    // выводит информацию о команде в консоль
    void printCommandInfo();

    boolean selectCurentClient();
}
