package DataBase;

import AccountControl.Account;
import AccountControl.User;

import java.util.ArrayList;
import java.util.List;

public class AccountsData implements Data<Account> {
    List<Account> accounts;
    public AccountsData() {
        this.accounts = new ArrayList<>();
        accounts.addAll(DataBase.getInstance().usersData.getDataAsList());
        //accounts.addAll(DataBase.getInstance().adminsData.getDataAsList());
    }

    public Account getDataByEmail(String Email){
        for (Account account : accounts) {
            if(account.getEmail().equals(Email))
                return account;
        }
        return null;
    }

    public boolean GetType(Account account){
        for (User ac : DataBase.getInstance().usersData.getDataAsList()) {
            if(ac.getEmail().equals(account.getEmail()))
                return true;
        }
        return false;
    }

    public Account getDataById(Long id){
        for (Account account : accounts) {
            if(account.getID().equals(id))
                return account;
        }
        return null;
    }
    /**
     * function that used to get the Account by its name
     * @param name name of Account you want to get it
     * @return Account
     */
    public Account getDataByName(String name){
        for (Account account : accounts) {
            //if(account.getName().equals(name))
            return account;
        }
        return null;
    }

    /**
     * function that used to get the Accounts that contains searchText
     * @param searchText is the substring of accounts you search
     * @return Account[]
     */
    public Account[] getDataThatContains(String searchText){
        List<Account> Searched = new ArrayList<Account>();
        for (Account account : accounts) {
            //if(account.getName().contains(searchText))
            Searched.add(account);
        }
        return Searched.toArray(new Account[0]);
    }

    /**
     * function that return all accounts in application
     * @return Account[]
     */
    public Account[] getData() {
        return accounts.toArray(new Account[0]);
    }

    /**
     * function that return all accounts in application as List
     * @return List<Account>
     */
    public List<Account> getDataAsList() {
        return accounts;
    }

    /**
     * function that add new account to application
     * @param account the account that will be added
     */
    public void addData(Account account){
        accounts.add(account);
    }

    /**
     * function that remove account from application
     * @param account name of account that will be removed
     */
    public void removeData(String account){
        accounts.remove(getDataByName(account));
    }

    public void removeData(long Id){
        while(getDataById(Id)!=null) {
            accounts.remove(getDataById(Id));
        }
    }
}
