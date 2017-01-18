package ua.spalah.bank.observer;


import ua.spalah.bank.models.Client;

import java.time.LocalDateTime;

/**
 * Created by MyPc on 05.01.2017.
 */
public class RegistrationLoggerListener implements ClientRegistrationListener{
    @Override
    public void onClientAdded(Client c) {
        System.out.println("Client " + c.getName() + " added on " + LocalDateTime.now());
    }
}
