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
            Scanner scanner = new Scanner(userFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int j = 0;
                String[] data = line.split(" ");
                Long userId = Long.parseLong(data[j++]);
                String Username = data[j++];
                String Password = data[j++];
                String Email = data[j++];
                String FirstName = data[j++];
                String LastName = data[j++];
                Long size = (Long) Long.parseLong(data[j++]);
                List<String>history = new ArrayList<>(),fav = new ArrayList<>(),watchLater = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    history.add(data[j++]);
                }
                size = (Long) Long.parseLong(data[j++]);
                for (int i = 0; i < size; i++) {
                    fav.add(data[j++]);
                }
                size = (Long) Long.parseLong(data[j++]);
                for (int i = 0; i < size; i++) {
                    watchLater.add(data[j++]);
                }
                String Fav = data[j++];
                Integer subscriptionType = Integer.parseInt(data[j++]);
                Date StartDate = DateFormat.getInstance().parse(scanner.nextLine());
                Date EndDate = DateFormat.getInstance().parse(scanner.nextLine());
                users.add(new User(Username,FirstName,LastName,Email,Password,new Subscription(userId,subscriptionType,StartDate,EndDate),fav,watchLater,history,Fav));
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
                fos.write(user.getID().toString().getBytes());
                fos.write(" ".getBytes());
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
                fos.write(user.getFavoriteName().getBytes());
                fos.write(" ".getBytes());
                fos.write(user.getSubscriptionPlan().Type.toString().getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(DateFormat.getInstance().format(user.getSubscriptionPlan().getStartDate()).getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(DateFormat.getInstance().format(user.getSubscriptionPlan().getEndDate()).getBytes());
                fos.write(System.lineSeparator().getBytes());
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
