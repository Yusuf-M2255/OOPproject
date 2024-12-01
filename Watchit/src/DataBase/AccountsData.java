package DataBase;

import AccountControl.Account;
import AccountControl.Admin;
import AccountControl.User;
import java.util.ArrayList;
import java.util.List;

public class AccountsData implements Data<Account>  {
    List<Account> accounts;
    public AccountsData() {
        this.accounts = new ArrayList<>();
    }

    public Account getDataByEmail(String Email){
        for (Account account : accounts) {
            if(account.getEmail().equals(Email))
                return account;
        }
        return null;
    }

    public boolean isUser(Account account){
        for (User ac : DataBase.getInstance().usersData.getDataAsList()) {
            if(ac.equals(account))
                return true;
        }
        return false;
    }

    public boolean isAdmin(Account account){
        for (Admin ac : DataBase.getInstance().adminsData.getDataAsList()) {
            if(ac.equals(account))
                return true;
        }
        return false;
    }
    public Account getDataById(Long Id){
        int l = 0,r = accounts.size()-1;
        while (l<=r){
            int m = (l+r)/2;
            if(accounts.get(m).getID()>Id){
                r = m-1;
            }else if(accounts.get(m).getID()<Id){
                l = m+1;
            }else
                return accounts.get(m);
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
            if(account.getUserName().equals(name))
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
            if(account.getUserName().contains(searchText))
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

    public void removeData(long Id) {
        accounts.remove(getDataById(Id));
    }
}
