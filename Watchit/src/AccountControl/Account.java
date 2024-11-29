package src.AccountControl;

public class Account {
    private String userName,firstName,lastName,email,password;
    private Long ID;
    private static Long cnt=(long)1;
    public Account(String userName,String firstName,String lastName,String email,String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.ID = cnt;
        cnt++;
    }
    public String getUserName() {
        return userName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public Long getID() {
        return ID;
    }
    void Reset(){
        cnt = (long) 0;
    }
}
