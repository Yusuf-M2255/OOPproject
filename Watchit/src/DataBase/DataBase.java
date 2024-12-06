package DataBase;

import AccountControl.*;
import Cast.CastMember;
import Cast.Director;
import ContentControl.*;
import Subscription.*;
import java.util.*;

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
    public DataObjectController<Admin> adminsData;
    public DataObjectController<User>usersData;
    public static DataObjectController<Account>accountsData =new DataObjectController<Account>();
    public Account CurrentUser = null;

    //Content Data
    public DataObjectController<Movie> moviesData;
    public DataObjectController<Series> seriesData;
    public DataObjectController<Episode> episodesData;
    public static DataObjectController<Content> contentsData = new DataObjectController<Content>();

    //Cast Data
    public DataObjectController<Director> DirectorsData;
    public DataObjectController<CastMember>castMemberData;

    //Watch Data
    public DataObjectController<WatchRecord>watchRecordData;

    //Credit Card Data
    public DataObjectController<CreditCard> creditData;

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
        episodesData = new DataObjectController<Episode>("./episodes.txt","nslSSiind",'E');
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
        System.out.print("Enter your password (or enter f if you forgot your password): ");
        Password = sc.next();
        Account user;
        if(accountsData.getDataByString(Email,4).isEmpty()){
            System.out.println("Email is not Found!");
            return false;
        }else{
            user = accountsData.getDataByString(Email,4).get(0);
            if(user.getPassword().equals(Password)){
                System.out.println("Login Successful");
                DataBase.getInstance().CurrentUser = user;
                return true;
            }
            else if (Password.equals("f") || Password.equals("F"))
            {
                System.out.print("Enter Your Favourite Name: ");
                String name = sc.next();
                if (user.getFavoriteName().equals(name))
                {
                    System.out.println("Your Password Is : "+ user.getPassword());
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
     * return boolean that describe if Login is Successful or Failed (True -> Successful / False -> Failed)
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
        while(!accountsData.getDataByString(Email,4).isEmpty() || !Email.matches(EmailRegex)){
            String c;
            if(!accountsData.getDataByString(Email,4).isEmpty()) {
                do {
                    System.out.println("Email already exists if you want to go back enter y, else if you want to try another email enter n.");
                    c = input.nextLine();
                    if ((c.charAt(0) == 'y' || c.charAt(0) == 'Y' || c.charAt(0) == 'n' || c.charAt(0) == 'N') && c.length() == 1)
                        break;
                    else
                        System.out.println("Sorry, Invalid Input, Try Again");
                } while (true);
                if(c.charAt(0) == 'y' || c.charAt(0) == 'Y'){
                    return false;
                }
            }else if(!Email.matches(EmailRegex)) {
                System.out.println("Invalid Email, Please Try Again");
            }
            System.out.print("Enter Email: ");
            Email = input.nextLine();
        }
        do{
            System.out.print("Enter Password: ");
            Password = input.nextLine();
            if (!Password.matches(PasswordRegex))
                System.out.println("Password is Invalid, it should have at least One Capital Letter, One small letter, one number, one special character, and a total of at least 8 characters");
            else
                break;
        }while (true);
        do
        {
            System.out.print("reEnter Password: ");
            String Password1 = input.nextLine();
            if(!Password.equals(Password1))
                System.out.println("Passwords doesn't match, please try again.");
            else
                break;
        }while (true);
        int i = 0;
        String j;
        for(String genre : genres)
            System.out.println((i++)+ "- " + genre);
        System.out.println("Enter -1 when you want stop choosing your Favorite Genres");
        do {
            j = input.nextLine();
            if((j.length() == 1 && j.charAt(0) - '0' >= 0 && j.charAt(0) - '0' <= 9) || (j.length() == 2 && j.charAt(0) - '0' == 1 && j.charAt(1) - '0' >= 0 && j.charAt(1) - '0' <= 7))
            {
                if (j.length() == 1)
                    fav.add(genres[j.charAt(0) - '0']);
                else
                    fav.add(genres[10 + (j.charAt(1) - '0')]);
            }
            else if (!j.equals("-1"))
                System.out.println("Sorry, " + j + " is an Invalid Input, Try Again");
        }while(!j.equals("-1"));
        System.out.print("Enter your Favorite Name (This name will be used to recover your Password if you forgot it): ");
        String FavoriteName = input.next();
        System.out.println("Choose your Plan : ");
        for (i = 0 ;i<3;i++) {
            System.out.println((i + 1) + "- " + Subscription.Plans[i] + "   |   " + Subscription.Prices[i] + "EGP/Year   |   " + Subscription.Descriptions[i]);
        }
        int Type;
        do
        {
            System.out.print("Enter the number of the subscription plan: ");
            String s = sc.nextLine();
            if (s.length() == 1 && s.charAt(0) - '0' < 4 && s.charAt(0) - '0' > 0)
            {
                Type = (s.charAt(0) - '0') - 1;
                break;
            }
            else
                System.out.println("Sorry, Invalid Input, Try Again");
        }while (true);
        do
        {
            String CreditNumber, cvv, ExpireDate;
            System.out.print("Enter your credit card number: ");
            CreditNumber = sc.nextLine();
            System.out.print("Enter your credit card expiration date (YY/MM): ");
            Date d = new Date();
            ExpireDate = sc.nextLine();
            System.out.print("Enter your credit card CVV: ");
            cvv = sc.nextLine();
            CreditCard credit = new CreditCard(CreditNumber, cvv, 1000, ExpireDate);
            if (DataBase.getInstance().creditData.getDataByObject(credit) != null)
            {
                System.out.println("Credit Card Accepted");
                break;
            }
            else
                System.out.println("Sorry, Invalid Credit Card, Please Try Again");
        }while (true);
        DataBase.getInstance().usersData.addData(new User(UserName,FirstName,LastName,Email,Password,new Subscription(Account.cnt+1,Type),fav,new ArrayList<>(),new ArrayList<>(),FavoriteName));
        DataBase.getInstance().CurrentUser = DataBase.getInstance().usersData.getDataByString(Email,4).get(0);
        accountsData.addData(DataBase.getInstance().CurrentUser);
        return true;
    }
}