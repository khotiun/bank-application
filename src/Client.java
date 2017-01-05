import accounts.Account;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by MyPc on 28.12.2016.
 */
public class Client {

    private String name;
    private Gender gender;
    private ArrayList<Account> accounts = new ArrayList<>();
    private Account activeAccount;

    public Client(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public void addAccount(Account account)
    {
        if(accounts.size() == 0) {
            activeAccount = account;
        }
            accounts.add(account);
    }

    public void setActiveAccount(Account account)
    {
       if(accounts.contains(account))
       {
           activeAccount = account;
       }
       else
           System.out.println("Такого счета у клиента нет!");

    }
    public int getTotalBalance()
    {
        int allBalance = 0;
        for (Account acc : accounts) {
            allBalance += acc.getBalance();
        }
        return allBalance;
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

    @Override
    public String toString() {
        return "Client{ " +
                 gender.getSalutation() +
                "" + name  +
                ", accounts=" + accounts +
                ", activeAccount=" + activeAccount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null) return false;
        if(getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return Objects.equals(name, client.name) && Objects.equals(gender,client.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }
}
