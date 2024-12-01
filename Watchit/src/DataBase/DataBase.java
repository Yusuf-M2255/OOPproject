package DataBase;

import AccountControl.*;
import ContentControl.*;
import Subscription.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    private static DataBase dataBase;
    final String EmailRegex = "[\\w-]+@(gmail|yahoo|outlook)\\.(com|org|io|net)",
            PasswordRegex="^(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*\\W)(?=.\\S+$).{8,}$";
    String[] genres = {
            "Action", "Adventure", "Comedy", "Drama", "Horror",
            "Romance", "Science Fiction", "Fantasy", "Mystery",
            "Thriller", "Documentary", "Animation", "Family",
            "Musical", "Crime", "Historical", "War", "Western"
    };
    public AdminsData adminsData= null;
    public Account CurrentUser = null;
    public static AccountsData accountsData= null;
    public MoviesData moviesData = null;
    public UsersData usersData = null;
    public WatchRecordData watchRecordData = null;
    public SeriesData seriesData = null;
    public static ContentsData contentsData = null;
    public DirectorsData DirectorsData = null;
    public CastMembersData castMembersData = null;
    private DataBase() {
        accountsData = new AccountsData();
        usersData = new UsersData();
        adminsData = new AdminsData();
        moviesData = new MoviesData();
        seriesData = new SeriesData();
        watchRecordData = new WatchRecordData();
        DirectorsData = new DirectorsData();
        castMembersData = new CastMembersData();

    }
    public static DataBase getInstance() {
        if(dataBase == null) {
            dataBase = new DataBase();
            contentsData = new ContentsData();
            return dataBase;
        }
        return dataBase;
    }

    public void Save(){
        moviesData.SaveData();
        seriesData.SaveData();
        watchRecordData.SaveData();
        DirectorsData.SaveData();
        castMembersData.SaveData();
        adminsData.SaveData();
        usersData.SaveData();
    }

    public boolean Login(){
        String Email,Password;
        System.out.print("Enter your email: ");
        Scanner sc = new Scanner(System.in);
        Email = sc.next();
        System.out.print("Enter your password: ");
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
            }else{
                System.out.println("Wrong Password!");
                return false;
            }
        }
    }
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