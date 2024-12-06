package AccountControl;

import DataBase.*;
import ContentControl.*;
import Subscription.Subscription;

public class Admin extends Account {
    public Admin(String userName,String firstName,String lastName,String email,String password,String FavoriteName) {
        super(userName,firstName,lastName,email,password,FavoriteName);
    }
    public Admin(Long Id,String userName,String firstName,String lastName,String email,String password,String FavoriteName) {
        super(userName,firstName,lastName,email,password,FavoriteName,Id);
    }
    public void editUser(long userID , User user){
        DataObjectController<User>data=DataBase.getInstance().usersData;
        data.removeData(userID,0);
        data.addData(user);
    }
    public void deleteUser(long userID){
        DataObjectController<User>data=DataBase.getInstance().usersData;
        data.removeData(userID,0);
    }
    public void addMovie(Movie movie){
        DataBase.getInstance().moviesData.addData(movie);
    }
    public void addSeries(Series series){
        DataObjectController<Series> data = DataBase.getInstance().seriesData;
        data.addData(series);
    }
    public void deleteMovie(String movie){
        DataObjectController<Movie> data = DataBase.getInstance().moviesData;
        data.removeData(movie,0);
    }
    public void deleteSeries(String series){
        DataObjectController<Series> data = DataBase.getInstance().seriesData;
        data.removeData(series,0);
    }
    // episode is not done yet
    public long calculateRevenue(){
        DataObjectController<User>data=DataBase.getInstance().usersData;
        long revenue = 0, numOfBasic = 0 , numOfStandard = 0, numOfPremium = 0;
        for (User user : data.getData()){
            String plan = user.getSubscriptionPlan().getPlan();
            if(plan.equals("Basic"))numOfBasic++;
            else if(plan.equals("Standard"))numOfStandard++;
            else numOfPremium++;
        }
        revenue+=(numOfBasic* Subscription.Prices[0])+(numOfStandard*Subscription.Prices[1])+(numOfPremium*Subscription.Prices[2]);
        return revenue;
    }
    public String plansAnalysis(){
        DataObjectController<User>data=DataBase.getInstance().usersData;
        long numOfBasic = 0 , numOfStandard = 0, numOfPremium = 0;
        for (User user : data.getData()){
            String plan = user.getSubscriptionPlan().getPlan();
            if(plan.equals("Basic"))numOfBasic++;
            else if(plan.equals("Standard"))numOfStandard++;
            else numOfPremium++;
        }
        String analysis =
                  "The Number of Users in Basic Plan is: "+ Long.toString(numOfBasic)
                + "\n The Number of Users in Standard Plan is: " + Long.toString(numOfStandard)
                + "\n The Number of Users in Premium Plan is: " + Long.toString(numOfPremium)+'\n';
        return analysis;
    }
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public boolean equals(Object obj){
        if(obj instanceof Admin other){
            return other.getId(0).equals(this.getId(0));
        }
        return false;
    }
}
