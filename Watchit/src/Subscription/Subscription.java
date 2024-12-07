package Subscription;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Subscription {
    //attributes
    private final long userId;
    private final int type;
    private final Date startDate;
    private final Date endDate;
    public final static String[] plans = {"Basic","Standard","Premium"};
    public final static int[] prices = {1000,1750,3000};
    public final static String[] descriptions = {"1 Screen / Ads","3 Screens / Ads","5 Screens / No Ads"};
    // constructors
    public Subscription(long userId,int type,Date startDate, Date endDate) {
        this.userId = userId;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Subscription(long userId, int type) {
        this.userId = userId;
        this.type = type;
        this.startDate = new Date();
        this.endDate=new Date();
        endDate.setYear(startDate.getYear()+1);
    }
    //getters
    public long getUserId() {
        return userId;
    }
    public String getPlan() {
        return plans[type];
    }
    public int getPrice() {
        return prices[type];
    }
    public Date getStartDate() {
        return startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public String getDescription() {
        return descriptions[type];
    }


    public static void displayPlans() {
        for (int i = 0; i < plans.length; i++) {
            System.out.println((i + 1) + "- " + Subscription.plans[i] + "   |   " + Subscription.prices[i] + "EGP/Year   |   " + Subscription.descriptions[i]);
        }
    }
    public boolean isExpired() {
        return endDate.before(new Date());
    }
    private String dateFormat(Date date) {
        return DateFormat.getInstance().format(date);
    }
    public String toString() {
        return type+System.lineSeparator()+dateFormat(startDate)+System.lineSeparator()+dateFormat(endDate);
    }
}
