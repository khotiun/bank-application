package ua.spalah.bank.observer;


import ua.spalah.bank.models.Client;

/**
 * Created by MyPc on 05.01.2017.
 */
public interface ClientRegistrationListener {//следить за добавлением клиента в банк
    void onClientAdded(Client c);//клиент добавлен
}
