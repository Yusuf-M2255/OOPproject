package DataBase;

import AccountControl.User;
import ContentControl.Series;

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
        File seriesFile = new File("/users.txt");
        try {
            Scanner scanner = new Scanner(seriesFile);
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
        File seriesFile = new File("/series.txt");
        try {
            FileOutputStream fos = new FileOutputStream(seriesFile);
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
            //if(user.getName().equals(name))
            return user;
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
            //if(user.getName().contains(searchText))
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

    @Override
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
}
