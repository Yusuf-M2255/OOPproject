package ContentControl;

import Cast.CastMember;
import Cast.Director;
import DataBase.DataBase;

import java.awt.*;
import java.util.Date;

abstract public class Content {
    public Long contentID;
    public String contentTitle;
    public Date Date;
    public static long cnt = (long)1;
    public CastMember[] cast;
    public Director director;
    public String genres;
    public String language;
    public String country;
    public int budget;
    public int revenue;
    public Image image;
    public int RateCounter;
    public float Rate_Sum;

    public Content(String contentTitle, java.util.Date date, int SizeOfCast, Director director, String genres, String language, String country, int budget, int revenue, Image image) {
        this.contentID = (Long) cnt++;
        this.contentTitle = contentTitle;
        Date = date;
        this.cast = new CastMember[SizeOfCast];
        this.director = director;
        this.genres = genres;
        this.language = language;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        this.image = image;
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

