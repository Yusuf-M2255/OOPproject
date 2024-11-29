package ContentControl;

import java.awt.*;
import java.util.Date;

public class Content {
    public String contentID;
    public String contentTitle;
    public Date Date;
    public CastMember [] cast;
    public Director director;
    public String genres;
    public String language;
    public String country;
    public int budget;
    public int revenue;
    public Image image;
    public float [] rating;

    public Content(String contentID, String contentTitle, java.util.Date date, CastMember[] cast, Director director, String genres, String language, String country, int budget, int revenue, Image image, float[] rating) {
        this.contentID = contentID;
        this.contentTitle = contentTitle;
        Date = date;
        this.cast = cast;
        this.director = director;
        this.genres = genres;
        this.language = language;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        this.image = image;
        this.rating = rating;
    }

    public void RateContent(int contentID, float rate){
        rating[contentID] = rate;
    }
    public float GetRate(int contentID){
        return rating[contentID];
    }
}

