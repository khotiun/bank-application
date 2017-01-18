package ua.spalah.bank.observer;


import ua.spalah.bank.models.Client;

/**
 * Created by MyPc on 05.01.2017.
 */
public class PrintClientListener implements ClientRegistrationListener  {

    @Override
    public void onClientAdded(Client c) {
        System.out.println(c);

    }
}
