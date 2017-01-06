package ua.spalah.bank.observer;


import ua.spalah.bank.Client;

/**
 * Created by MyPc on 05.01.2017.
 */
public class EmailNotificationListener implements ClientRegistrationListener{
    @Override
    public void onClientAdded(Client c) {
        System.out.println("Notification email for client " + c.getName() + " has been sent");

    }
}
