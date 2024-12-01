package Subscription;

import java.util.Date;

public class Subscription {
    //attributes
    private long userID;
    private String plan;
    private int price;
    private Date startDate;
    private Date endDate;
    // constructors

    //for Yusuf (I don't know why you use default constructor)
    public Subscription() {
        userID = 0;
        plan = "";
        price = 0;
        startDate = new Date();
        endDate = new Date();
    }
    public Subscription(long userID, String plan, int price, Date startDate, Date endDate){
        this.userID = userID;
        this.plan = plan;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    //setters
    public void setUserID(long userID) {
        this.userID = userID;
    }
    public void setPlan(String plan) {
        this.plan = plan;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    //getters
    public long getUserID() {
        return userID;
    }
    public String getPlan() {
        return plan;
    }
    public int getPrice() {
        return price;
    }
    public Date getStartDate() {
        return startDate;
    }
}