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
            accountsData = new AccountsData();
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

    public void Login(){
        String Email,Password;
        System.out.print("Enter your email: ");
        Scanner sc = new Scanner(System.in);
        Email = sc.next();
        System.out.print("Enter your password: ");
        Password = sc.next();
        Account user = accountsData.getDataByEmail(Email);
        if(user==null){
            System.out.println("!!!Email is not Found");
        }else{
            if(user.getPassword().equals(Password)){
                System.out.println("Login Successful");
                DataBase.getInstance().CurrentUser = user;
            }else{
                System.out.println("!!!Wrong Password");
            }
        }
    }
    public boolean Register() {
        String FirstName, LastName, UserName, Email, Password;
        Subscription SubscriptionPlan = new Subscription();
        CreditCard creditCard=new CreditCard();
        List<String> fav = new ArrayList<String>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        FirstName = input.nextLine();
        System.out.print("Enter Last Name: ");
        LastName = input.nextLine();
        System.out.print("Enter User Name: ");
        UserName = input.nextLine();
        System.out.print("Enter Email: ");
        Email = input.nextLine();
        while(true){
            if(accountsData.getDataByEmail(Email)!=null)
                System.out.println("User already exists if you want back enter y");
            else if(!Email.matches(EmailRegex)){
                System.out.println("Email is not Valid");
            }
            else
                break;
            System.out.println("wanna continue ? (Y/N)");
            char c = input.nextLine().charAt(0);
            if(c=='N'){
                return false;
            }
            System.out.print("Enter Email: ");
            Email = input.nextLine();
        }
        System.out.print("Enter Password: ");
        Password = input.nextLine();
        while(true){
            if(!Password.matches(PasswordRegex)){
                System.out.println("Password is not Valid");
            }
            else
                break;
            System.out.println("wanna continue ? (Y/N)");
            char c = input.nextLine().charAt(0);
            if(c=='N'){
                return false;
            }
            System.out.print("Enter Password: ");
            Password = input.nextLine();
        }
        System.out.print("reEnter Password: ");
        String Password1 = input.nextLine();
        while(!Password.equals(Password1)){
            System.out.println("Passwords doesn't match");
            System.out.println("if you want back enter y");
            char c = input.nextLine().charAt(0);
            if(c=='y'){
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
        DataBase.getInstance().usersData.addData(new User(UserName,FirstName,LastName,Email,Password,new CreditCard(),new Subscription(),fav,new ArrayList<>(),new ArrayList<>(),FavoriteName));
        DataBase.getInstance().CurrentUser = DataBase.getInstance().usersData.getDataByEmail(Email);
        accountsData.addData(DataBase.getInstance().usersData.getDataByEmail(Email));
        return true;
    }
}
