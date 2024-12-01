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
    
}
