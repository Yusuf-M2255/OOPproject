package ContentControl;

import Cast.CastMember;
import Cast.Director;
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
        director.Contents[director.DirectorWorksNumber] = contentTitle;
        director.DirectorWorksNumber++;
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
        this.rating = new float[5000];
        Rate_Sum = 0;
    }

    public void AddRate(int UserID, float rate){
        rating[UserID] = rate;
        if(rating[UserID] == 0)
            RateCounter++;
    }

    public void RemoveRate(int UserID){
        Rate_Sum -= rating[UserID];
        RateCounter--;
        rating[UserID] = 0;
    }
    public float GetRate(){
        return (Rate_Sum/RateCounter);
    }
    abstract void AddCast();

}

