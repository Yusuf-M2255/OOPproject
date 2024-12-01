package AccountControl;

import DataBase.*;
import ContentControl.*;

public class Admin {
    private String userName,firstName,lastName,email,password;
    private Long ID;
    private static long cnt= (long) 1;
    public Admin(String userName,String firstName,String lastName,String email,String password) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.ID = (Long) cnt;
        cnt++;
    }
    public void editUser(long userID , User user){
        UsersData data = DataBase.getInstance().usersData;
        data.removeData(userID);
        data.addData(user);
    }
    public void deleteUser(long userID){
        UsersData data = DataBase.getInstance().usersData;
        data.removeData(userID);
    }
    public void addMovie(Movie movie){
        MoviesData data = DataBase.getInstance().moviesData;
        data.addData(movie);
    }
    public void addSeries(Series series){
        SeriesData data = DataBase.getInstance().seriesData;
        data.addData(series);
    }
    public void deleteMovie(String movie){
        MoviesData data = DataBase.getInstance().moviesData;
        data.removeData(movie);
    }
    public void deleteSeries(String series){
        SeriesData data = DataBase.getInstance().seriesData;
        data.removeData(series);
    }
    // episode is not done yet
    public long calculateRevenue(){
        long users = Account.cnt;
        long revenue = 0, numOfBasic = 0 , numOfStandard = 0, numOfPremium = 0;
        for (long i =1;i<=users;i++){
            UsersData data = new UsersData();
            User current = data.getDataById(i);
            String plan = current.subscriptionPlan.getPlan();
            if(plan=="Basic")numOfBasic++;
            else if(plan=="Standard")numOfStandard++;
            else numOfPremium++;
        }
        revenue+=(numOfBasic*1000)+(numOfStandard*1750)+(numOfPremium*3000);
        return revenue;
    }
    public String plansAnalysis(){
        String analysis = "The Number of Users in Basic Plan is: ";
        long users = Account.cnt;
        long numOfBasic = 0 , numOfStandard = 0, numOfPremium = 0;
        for (long i =1;i<=users;i++){
            UsersData data = new UsersData();
            User current = data.getDataById(i);
            String plan = current.subscriptionPlan.getPlan();
            if(plan=="Basic")numOfBasic++;
            else if(plan=="Standard")numOfStandard++;
            else numOfPremium++;
        }
        analysis+=Long.toString(numOfBasic);
        analysis+="\n The Number of Users in Standard Plan is: " + Long.toString(numOfStandard);
        analysis+="\n The Number of Users in Premium Plan is: " + Long.toString(numOfPremium);
        return analysis;

    }
}
