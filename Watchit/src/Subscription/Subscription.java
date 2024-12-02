package Subscription;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Subscription {
    //attributes
    private final long userID;
    private  final Date startDate;
    private final Date endDate;
    public final Integer Type;
    public final static String[] Plans = {"Basic","Standard","Premium"};
    public final static Long[] Prices = {(long)1000,(long)1750,(long)3000};
    public final static String[] Descriptions = {"1 Screen / Ads","3 Screen / Ads","3 Screen / No Ads"};
    // constructors

    //for Yusuf (I don't know why you use default constructor)
    public Subscription(long userID, Integer Type, Date startDate, Date endDate){
        this.userID = userID;
        this.Type = Type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Subscription(long userID, Integer Type){
        this.userID = userID;
        this.Type = Type;
        this.startDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.YEAR, 1);
        this.endDate = new Date(calendar.getTime().getTime());
    }
    public Long getUserID() {
        return userID;
    }
    public String getPlan() {return Plans[Type];}
    public Long getPrice() { return Prices[Type];}
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {return endDate;}
    public String getDescription() {return Descriptions[Type];}
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public String toString() {
        return Type+System.lineSeparator()+ DateFormat.getInstance().format(startDate) +System.lineSeparator()+DateFormat.getInstance().format(endDate);
    }
}