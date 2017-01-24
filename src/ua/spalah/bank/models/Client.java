package ua.spalah.bank.models;

import java.util.ArrayList;

/**
 * Created by MyPc on 28.12.2016.
 */
public class Client {

    private String name;
    private Gender gender;
    private ArrayList<Account> accounts = new ArrayList<>();
    private Account activeAccount;
    private String email;
    private String tel;
    private String city;

    public Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }

    public void setAccount(Account account) {
        if (accounts.isEmpty())
            activeAccount = account;
        accounts.add(account);
    }

    public void setActiveAccount(Account activeAccount) {
        this.activeAccount = activeAccount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public Account getActiveAccount() {
        return activeAccount;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (gender != client.gender) return false;
        if (accounts != null ? !accounts.equals(client.accounts) : client.accounts != null) return false;
        if (activeAccount != null ? !activeAccount.equals(client.activeAccount) : client.activeAccount != null)
            return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (tel != null ? !tel.equals(client.tel) : client.tel != null) return false;
        return city != null ? city.equals(client.city) : client.city == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (accounts != null ? accounts.hashCode() : 0);
        result = 31 * result + (activeAccount != null ? activeAccount.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", accounts=" + accounts +
                ", activeAccount=" + activeAccount +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
