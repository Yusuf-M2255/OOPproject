package DataBase;

import AccountControl.*;
import Cast.CastMember;
import Cast.Director;
import ContentControl.*;
import Subscription.*;
import com.sun.source.tree.TryTree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * DataBase Administration Class that is built Using SingleTone Design Pattern
 */
public class DataBase {
    // SingleTone Instance
    private static DataBase dataBase;

    // Regex Strings
    final String EmailRegex = "[\\w-]+@(gmail|yahoo|outlook)\\.(com|org|io|net)",
            PasswordRegex="^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*\\W)(?=.\\S+$).{8,}$";

    // Genre of Movies and Series
    String[] genres = {
            "Action", "Adventure", "Comedy", "Drama", "Horror",
            "Romance", "Science Fiction", "Fantasy", "Mystery",
            "Thriller", "Documentary", "Animation", "Family",
            "Musical", "Crime", "Historical", "War", "Western"
    };

    //Accounts Data
    public DataObjectController<Admin> adminsData= null;
    public DataObjectController<User>usersData =null;
    public static DataObjectController<Account>accountsData =new DataObjectController<Account>();
    public Account CurrentUser = null;

    //Content Data
    public DataObjectController<Movie> moviesData = null;
    public DataObjectController<Series> seriesData = null;
    public static DataObjectController<Content> contentsData = new DataObjectController<Content>();

    //Cast Data
    public DataObjectController<Director> DirectorsData = null;
    public DataObjectController<CastMember>castMemberData = null;

    //Watch Data
    public DataObjectController<WatchRecord>watchRecordData = null;

    //Credit Card Data
    public DataObjectController<CreditCard> creditData = null;

    /**
     * Non-Parameterized Constructor that init all Data Objects and Loading Data From Files
     */
    private DataBase() {
        // Loading Accounts
        usersData = new DataObjectController<User>("./users.txt","nslw5SWw3oSWSiw2ndW",'U');
        adminsData = new DataObjectController<Admin>("./admins.txt","nslw6SW",'A');
        // Loading Contents
        moviesData = new DataObjectController<Movie>("./movies.txt","nslw4SWiioSoSndni",'M');
        seriesData = new DataObjectController<Series>("./series.txt","nslw4SWiioSoSndnsiind",'S');
        // Loading Cast
        DirectorsData = new DataObjectController<Director>("./Directors.txt","nslw5SWoSnd",'D');
        castMemberData = new DataObjectController<CastMember>("./CastMembers.txt","nslw5SWoSnd",'C');
        //Loading Watch Record
        watchRecordData = new DataObjectController<WatchRecord>("./watchRecord.txt","nslfSnd",'W');
        // Loading Credit Cards
        creditData = new DataObjectController<CreditCard>("./creditCard.txt","nsSSfnd",'R');
    }

    /**
     * getting Instance Of DataBase to reach all Data
     * check if dataBase instance is null then Create instance of DataBase otherwise return the same instance
     * @return DataBase
     */
    public static DataBase getInstance() {
        if(dataBase == null) {
            dataBase = new DataBase();
            return dataBase;
        }
        return dataBase;
    }

    /**
     * Saving All Data in Files
     */
    public void Save(){
        // save accounts data
        adminsData.Write();
        usersData.Write();
        // save content data
        moviesData.Write();
        seriesData.Write();
        // save cast data
        DirectorsData.Write();
        castMemberData.Write();
        // save watch records
        watchRecordData.Write();
        // save valid credit cards
        creditData.Write();
    }

    /**
     * Login Form
     * @return boolean that describe if Login is Successful or Failed (True -> Successful / False -> Failed)
     */
    public boolean Login(){
        String Email,Password;
        System.out.print("Enter your email: ");
        Scanner sc = new Scanner(System.in);
        Email = sc.next();
        System.out.print("Enter your password (or inter f if you forgot your password): ");
        Password = sc.next();
        Account user =accountsData.getDataByEmail(Email);
        if(user==null){
            System.out.println("Email is not Found!");
            return false;
        }else{
            if(user.getPassword().equals(Password)){
                System.out.println("Login Successful");
                DataBase.getInstance().CurrentUser = user;
                return true;
            }
            else if (Password.equals('f') || Password.equals('F'))
            {
                System.out.println("Enter Your Favourite Name: ");
                String name = sc.next();
                if (user.getFavoriteName().equals(name))
                {
                    System.out.println("Login Successful");
                    DataBase.getInstance().CurrentUser = user;
                    return true;
                }
                else {
                    System.out.println("Wrong answer!");
                    return false;
                }
            }
            else{
                System.out.println("Wrong Password!");
                return false;
            }
        }
    }

    /**
     * Register Form
     * @return boolean that describe if Login is Successful or Failed (True -> Successful / False -> Failed)
     */
    public boolean Register() {
        String FirstName, LastName, UserName, Email, Password;
        List<String> fav = new ArrayList<>();
        Scanner input = new Scanner(System.in), sc = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        FirstName = input.nextLine();
        System.out.print("Enter Last Name: ");
        LastName = input.nextLine();
        System.out.print("Enter User Name: ");
        UserName = input.nextLine();
        System.out.print("Enter Email: ");
        Email = input.nextLine();
        while(true){
            char c;
            if(accountsData.getDataByEmail(Email)!=null) {
                do {
                    System.out.println("User already exists if you want to go back enter y, else if you want to try again enter n.");
                    c = input.nextLine().charAt(0);
                    if (c == 'y' || c == 'Y' || c == 'n' || c == 'N')
                        break;
                    else
                        System.out.println("Sorry, Invalid Input, Try Again");
                } while (true);
                if(c=='y' || c == 'Y'){
                    return false;
                }
            }else if(!Email.matches(EmailRegex)){
                do {
                    System.out.println("Email Invalid. if you want to go back enter y, else if you want to try again enter n.");
                    c = input.nextLine().charAt(0);
                    if (c == 'y' || c == 'Y' || c == 'n' || c == 'N')
                        break;
                    else
                        System.out.println("Sorry, Invalid Input, Try Again");
                } while (true);
                if(c=='y' || c == 'Y'){
                    return false;
                }
            }else
                break;
            do {
                System.out.println("User already exists if you want to go back enter Y, else if you want to try again enter N.");
                c = sc.next().charAt(0);
                if (c == 'y' || c == 'Y' || c == 'n' || c == 'N')
                    break;
                else
                    System.out.println("Sorry, Invalid Input, Try Again");
            }while (true);
            if(c=='y' || c == 'Y'){
                return false;
            }
            System.out.print("Enter Email: ");
            Email = input.nextLine();
        }
        System.out.print("Enter Password: ");
        Password = input.nextLine();
        while (!Password.matches(PasswordRegex)){
            char c;
            do {
                System.out.println("Password is Invalid");
                System.out.println("if you want to go back enter y, else if you want to try again enter n.");
                c = input.nextLine().charAt(0);
                if (c == 'y' || c == 'Y' || c == 'n' || c == 'N')
                    break;
                else
                    System.out.println("Sorry, Invalid Input, Try Again");
            } while (true);
            if(c=='y' || c == 'Y'){
                return false;
            }
            System.out.print("Enter Password: ");
            Password = input.nextLine();
        }
        System.out.print("reEnter Password: ");
        String Password1 = input.nextLine();
        char c;
        while(!Password.equals(Password1)){
            do {
                c = input.nextLine().charAt(0);
                System.out.println("Passwords doesn't match if you want to go back enter Y, else if you want to try again enter N.");
                c = sc.next().charAt(0);
                if (c == 'y' || c == 'Y' || c == 'n' || c == 'N')
                    break;
                else
                    System.out.println("Sorry, Invalid Input, Try Again");
            }while (true);
            if(c=='y' || c =='Y'){
                return false;
            }
            System.out.print("reEnter Password: ");
            Password1 = input.nextLine();
        }
        int i = 0,j;
        for(String genre : genres)
            System.out.println((i++)+ "- " + genre);
        System.out.println("Enter -1 when you want stop choosing your Favorite Genres");
        do {
            j = input.nextInt();
            if(j<genres.length&&j>=0)
                fav.add(genres[j]);
        }while(j!=-1);
        System.out.print("Enter your Favorite Name : ");
        String FavoriteName = input.next();
        System.out.println("Choose your Plan : ");
        for (i = 0 ;i<3;i++){
            System.out.println((i+1)+"- "+Subscription.Plans[i] +"   |   "+Subscription.Prices[i]+"EGP/Year   |   "+ Subscription.Descriptions[i]);
        }
        Integer Type = sc.nextInt() - 1;
        DataBase.getInstance().usersData.addData(new User(UserName,FirstName,LastName,Email,Password,new Subscription(Account.cnt+1,Type),fav,new ArrayList<>(),new ArrayList<>(),FavoriteName));
        DataBase.getInstance().CurrentUser = DataBase.getInstance().usersData.getDataByEmail(Email);
        accountsData.addData(DataBase.getInstance().usersData.getDataByEmail(Email));
        return true;
    }
}