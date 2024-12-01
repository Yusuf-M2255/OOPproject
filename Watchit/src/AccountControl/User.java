package AccountControl;

import Subscription.CreditCard;
import Subscription.Subscription;

import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

public class User extends Account {
    private List<String> FavoriteGenres,WatchLater,History;
    private Subscription subscriptionPlan;
    public User(String userName,String firstName,String lastName,String email,String password,Subscription subscriptionPlan,List<String> FavoriteGenres,List<String> WatchLater,List<String> History,String FavoriteName){
        super(userName,firstName,lastName,email,password,FavoriteName);
        this.subscriptionPlan = subscriptionPlan;
        this.WatchLater = WatchLater;
        this.History = History;
        this.FavoriteGenres = FavoriteGenres;
    }
    public User(Long Id,String userName,String firstName,String lastName,String email,String password,Subscription subscriptionPlan,List<String> FavoriteGenres,List<String> WatchLater,List<String> History,String FavoriteName){
        super(userName,firstName,lastName,email,password,FavoriteName,Id);
        this.subscriptionPlan = subscriptionPlan;
        this.WatchLater = WatchLater;
        this.History = History;
        this.FavoriteGenres = FavoriteGenres;
    }
    public List<String> getWatchLater() {
        return WatchLater;
    }
    public void setWatchLater(String WatchLater) {
        this.WatchLater.add(WatchLater);
    }
    public List<String> getHistory() {
        return History;
    }
    public void Watched(String Content) {
        this.History.add(Content);
    }
    public Subscription getSubscriptionPlan() {
        return subscriptionPlan;
    }
    public void Renew(Subscription subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }
    public List<String> getFavoriteGenres() {
        return FavoriteGenres;
    }
    public void addGenre(String Genre) {
        FavoriteGenres.add(Genre);
    }
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(ID.toString() + " " + userName + " " + password + " " + email + " " + firstName
                + ' ' + lastName + " ");
        s.append(Integer.valueOf(History.size()).toString()).append(" ");
        for (String history : History) {
            s.append(history).append(" ");
        }

        s.append(Integer.valueOf(FavoriteGenres.size()).toString()).append(" ");
        for (String Genre : FavoriteGenres) {
            s.append(Genre).append(" ");
        }

        s.append(Integer.valueOf(WatchLater.size()).toString()).append(" ");
        for (String watchLater : WatchLater) {
            s.append(watchLater).append(" ");
        }
        s.append(FavoriteName).append(" ");
        s.append(subscriptionPlan.toString());
        s.append(System.lineSeparator());
        return s.toString();
    }
}
