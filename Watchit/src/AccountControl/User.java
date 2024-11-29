package src.AccountControl;

import Subscription.CreditCard;
import Subscription.Subscription;
import java.util.List;

public class User extends Account {
    private CreditCard creditCard;
    private List<String> FavoriteGenres,WatchLater,History;
    private Subscription subscriptionPlan;
    public User(String userName,String firstName,String lastName,String email,String password,CreditCard creditCard,Subscription subscriptionPlan,List<String> FavoriteGenres,List<String> WatchLater,List<String> History){
        super(userName,firstName,lastName,email,password);
        this.creditCard = creditCard;
        this.subscriptionPlan = subscriptionPlan;
        this.WatchLater = WatchLater;
        this.History = History;
        this.FavoriteGenres = FavoriteGenres;
    }
    public CreditCard getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
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

}
