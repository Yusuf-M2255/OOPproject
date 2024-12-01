package DataBase;

import AccountControl.User;
import Subscription.CreditCard;
import Subscription.Subscription;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UsersData implements Data<User>,ReadableClass,ConsoleDisplay<User> {
    List<User> users = null;
    public UsersData() {
        users = new ArrayList<>();
        LoadData();
    }
    /**
     * get Data of users from files
     * its throws messages when files not founded or any other error
     */

    public void LoadData(){
        File userFile = new File("./users.txt");
        try {
            if(!userFile.exists()){
                userFile.createNewFile();
            }
            ElarabyLanguage UserL = new ElarabyLanguage(userFile,"nslw5SWw3oSWSiw2ndW");
            while (UserL.notNull()) {
                ReturnedData re = UserL.Run(UserL.Code);
                addData(new User(re.longs.get(0), re.strings.get(0), re.strings.get(3), re.strings.get(4), re.strings.get(2), re.strings.get(1), new Subscription(re.longs.get(0), re.integers.get(0), re.dates.get(0), re.dates.get(1)), re.stringLists.get(1), re.stringLists.get(2), re.stringLists.get(0), re.strings.get(5)));
            }
        }catch (FileNotFoundException e){
            System.out.println("File users.txt is not found");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("error while opening users.txt file ");
        }
    }


    /**
     * save Data of users in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File userFile = new File("./users.txt");
        try {
            userFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(userFile);
            for (User user : users) {
                fos.write(user.toString().getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("File users.txt is not found");
        }
        catch (Exception e){
            System.out.println("Save users.txt failed");
        }
    }

    /**
     * function that used to get the users by its name
     * @param name name of Series you want to get it
     * @return Series
     */
    public User getDataByName(String name){
        for (User user : users) {
            if(user.getUserName().equals(name))
                return user;
        }
        return null;
    }

    public User getDataByEmail(String Email){
        for (User user : users) {
            if(user.getEmail().equals(Email))
                return user;
        }
        return null;
    }

    public User getDataById(Long Id){
        int l = 0,r = users.size()-1;
        while (l<=r){
            int m = (l+r)/2;
            if(users.get(m).getID()>Id){
                r = m-1;
            }else if(users.get(m).getID()<Id){
                l = m+1;
            }else
                return users.get(m);
        }
        return null;
    }

    /**
     * function that used to get the users that contains searchText
     * @param searchText is the substring of user you search
     * @return User[]
     */
    public User[] getDataThatContains(String searchText){
        List<User> Searched = new ArrayList<>();
        for (User user : users) {
            if(user.getUserName().contains(searchText))
                Searched.add(user);
        }
        return Searched.toArray(new User[0]);
    }

    /**
     * function that return all users in application
     * @return User[]
     */
    public User[] getData() {
        return users.toArray(new User[0]);
    }

    /**
     * function that return all Users in application as List
     * @return List<User>
     */
    public List<User> getDataAsList() {
        return users;
    }

    /**
     * function that add new user to application
     * @param user the user that will be added
     */
    public void addData(User user){
        users.add(user);
        DataBase.accountsData.addData(user);
    }

    /**
     * function that remove user from application
     * @param user name of user that will be removed
     */
    public void removeData(long user){
        users.remove(getDataById(Long.valueOf(user)));
    }

    public void removeData(String user){
        users.remove(getDataByName(user));
    }


    public void Display(User[] Users){
        DisplayHeadLine();
        for (User user : Users) {
            DisplayLine(user);
        }
    }

    public void DisplayLine(User user){
        String Line = "|    "+user.getID()+ "    |    "+user.getUserName()+ "    |    "+user.getFirstName()+ "    |    "+
                user.getLastName()+ "    |    "+user.getEmail()+ "    |    "+user.getPassword()+
                "    |";
        for (int i = 0;i<Line.length();i++){
            System.out.print('-');
        }
        System.out.print("\n");
        System.out.println(Line);
        for (int i = 0;i<Line.length();i++){
            System.out.print('-');
        }
        System.out.print("\n");
    }

    public void DisplayHeadLine(){
        String Line = "|    ID     |    UserName     |    FirstName    |    LastName    |    Email    |    Password    |";
        for (int i = 0;i<Line.length();i++){
            System.out.print('-');
        }
        System.out.print("\n");
        System.out.println(Line);
    }
}
