package ContentControl;

import Cast.CastMember;
import Cast.Director;
import DataBase.DataBase;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Content {
    public Long contentID;
    public String contentTitle;
    public Date Date;
    public static long cnt = (long)1;
    public List<String> cast;
    public Director director;
    public List<String>genres;
    public String language;
    public String country;
    public int budget;
    public int revenue;
    public int RateCounter;
    public float Rate_Sum;

    public Content(String contentTitle,List<String> genres,List<String>CastMembers, String language, String country, int budget, int revenue,Date date,Director director) {
        this.contentID = (Long) cnt++;
        this.contentTitle = contentTitle;
        Date = date;
        this.cast = CastMembers;
        this.director = director;
        this.genres = genres;
        this.language = language;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        Rate_Sum = 0;
        for(WatchRecord Record: DataBase.getInstance().watchRecordData.getAllDataByName(contentTitle)){
            Rate_Sum += Record.Rating;
            RateCounter++;
        }
    }

    public void AddRate(int UserID, float rate) {
        DataBase.getInstance().watchRecordData.addData(new WatchRecord((long) UserID, contentTitle, new Date(), rate));
        RateCounter++;
        Rate_Sum += rate;
    }

    public void EditRate(int UserID, String contentTitle, float rate){
        WatchRecord WatchRecordTemp = DataBase.getInstance().watchRecordData.removeData(contentTitle, Long.valueOf((long)UserID));
        Rate_Sum -= WatchRecordTemp.Rating;
        WatchRecordTemp.Rating = (Float) rate;
        Rate_Sum += rate;
        DataBase.getInstance().watchRecordData.addData(WatchRecordTemp);
    }
    public float TotalRate(){
        return (Rate_Sum/RateCounter);
    }

}

