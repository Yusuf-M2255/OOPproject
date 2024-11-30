package ContentControl;

import Cast.CastMember;
import Cast.Director;
import DataBase.DataBase;

import java.awt.*;
import java.util.Date;

abstract public class Content {
    public String contentID;
    public String contentTitle;
    public Date Date;
    public CastMember[] cast;
    public Director director;
    public String genres;
    public String language;
    public String country;
    public int budget;
    public int revenue;
    public Image image;
    public float [] rating;
    public int RateCounter;
    public float Rate_Sum;

    public Content(String contentID, String contentTitle, java.util.Date date, int SizeOfCast, Director director, String genres, String language, String country, int budget, int revenue, Image image) {
        director.Contents.add(contentTitle);
        this.contentID = contentID;
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
    }

    public void AddRate(int UserID, float rate){
        DataBase.getInstance().watchRecordData.addData(new WatchRecord((long)UserID,contentTitle,new Date(),rate));
    }

    public void RemoveRate(int UserID){
        DataBase.getInstance().watchRecordData.removeData(contentTitle,(long)UserID);
        Rate_Sum -= rating[UserID];
        RateCounter--;
        rating[UserID] = 0;
    }
    public float TotalRate(){
        return (Rate_Sum/RateCounter);
    }

}

