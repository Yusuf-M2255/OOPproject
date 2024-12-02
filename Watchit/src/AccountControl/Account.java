package AccountControl;

import DataBase.DataObject;

public class Account extends DataObject {
    protected final String userName,firstName,lastName,email,password,FavoriteName;
    protected Long ID;
    public static long cnt= (long) 1;
    public Account(){
        userName = null;
        firstName = null;
        lastName = null;
        email = null;
        password = null;
        FavoriteName = null;
    }
    public Account(String userName,String firstName,String lastName,String email,String password,String FavoriteName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.FavoriteName = FavoriteName;
        this.ID = (Long) cnt++;

    }
    public Account(String userName,String firstName,String lastName,String email,String password,String FavoriteName,Long id) {
        this(userName, firstName, lastName, email, password, FavoriteName);
        ID=id;
        cnt = id+1;
    }
    public String getFavoriteName(){ return this.FavoriteName;}
    public String getUserName() {
        return userName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Account) {
            Account a = (Account) obj;
            return a.ID.equals(this.ID);
        }
        return false;
    }
    @Override
    public String getName(int op){
        if(op==0)
            return this.userName;
        if(op==1)
            return this.firstName;
        if(op==2)
            return this.lastName;
        return null;
    }
    @Override
    public String getEmail(){
        return this.email;
    }
    @Override
    public Long getId(int op){
        return this.ID;
    }
    @Override
    public String toString(){
        return  ID.toString() + " " + userName + " " + firstName + " " + lastName + " " + email
                + ' ' + password + " " + FavoriteName + System.lineSeparator();
    }
}
