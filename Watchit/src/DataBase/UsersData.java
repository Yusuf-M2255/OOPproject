package DataBase;

import AccountControl.User;
import Subscription.CreditCard;
import Subscription.Subscription;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsersData implements Data<User> {
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
        File userFile = new File("users.txt");
        try {
            Scanner scanner = new Scanner(userFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(" ");
                String Username = data[0];
                String Password = data[1];
                String Email = data[2];
                String FirstName = data[3];
                String LastName = data[4];
                Long size = Long.parseLong(data[5]);
                List<String>history = new ArrayList<>(),fav = new ArrayList<>(),watchLater = new ArrayList<>();
                int j = 6;
                for (int i = 0; i < size; i++) {
                    history.add(data[j++]);
                }
                size = Long.parseLong(data[j++]);
                for (int i = 0; i < size; i++) {
                    fav.add(data[j++]);
                }
                size = Long.parseLong(data[j++]);
                for (int i = 0; i < size; i++) {
                    watchLater.add(data[j++]);
                }
                users.add(new User(Username,FirstName,LastName,Email,Password,new CreditCard(),new Subscription(),fav,watchLater,history));
            }

        }catch (FileNotFoundException e){
            System.out.println("File movies.txt is not found");
        }
        catch (Exception e){
            System.out.println("error while opening");
        }
    }


    /**
     * save Data of users in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File userFile = new File("users.txt");
        try {
            userFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(userFile);
            for (User user : users) {
                fos.write(user.getUserName().getBytes());
                fos.write(" ".getBytes());
                fos.write(user.getPassword().getBytes());
                fos.write(" ".getBytes());
                fos.write(user.getEmail().getBytes());
                fos.write(" ".getBytes());
                fos.write(user.getFirstName().getBytes());
                fos.write(" ".getBytes());
                fos.write(user.getLastName().getBytes());
                fos.write(" ".getBytes());
                fos.write(Integer.valueOf(user.getHistory().size()).toString().getBytes());
                fos.write(" ".getBytes());
                for (String history : user.getHistory()) {
                    fos.write(history.getBytes());
                    fos.write(" ".getBytes());
                }
                fos.write(Integer.valueOf(user.getFavoriteGenres().size()).toString().getBytes());
                fos.write(" ".getBytes());
                for (String favoriteGenre : user.getFavoriteGenres()) {
                    fos.write(favoriteGenre.getBytes());
                    fos.write(" ".getBytes());
                }
                fos.write(Integer.valueOf(user.getWatchLater().size()).toString().getBytes());
                fos.write(" ".getBytes());
                for (String watchLater : user.getWatchLater()) {
                    fos.write(watchLater.getBytes());
                    fos.write(" ".getBytes());
                }
                fos.write(System.lineSeparator().getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("File movies.txt is not found");
        }
        catch (Exception e){
            System.out.println("Save movies.txt failed");
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
        List<User> Searched = new ArrayList<User>();
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
    }

    /**
     * function that remove user from application
     * @param user name of user that will be removed
     */
    public void removeData(String user){
        users.remove(getDataByName(user));
    }

    public void displayData(@org.jetbrains.annotations.NotNull User user){
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
    public void PrintHeadline(){
        String Line = "|    ID     |    UserName     |    FirstName    |    LastName    |    Email    |    Password    |";

        for (int i = 0;i<Line.length();i++){
            System.out.print('-');
        }
        System.out.print("\n");
        System.out.println(Line);
    }

}
