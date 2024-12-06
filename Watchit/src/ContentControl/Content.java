package ContentControl;
import DataBase.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Content extends DataObject {
    public Long contentID;
    public String contentTitle;
    public Date datePublished;
    public static long cnt = (long)1;
    public List<String> cast;
    public String director;
    public List<String>genres;
    public String language;
    public String country;
    public int budget;
    public int revenue;
    public int RateCounter;
    public float Rate_Sum;
    public Content(String contentTitle,String language, String country,String director,int budget, int revenue,List<String> genres,List<String>CastMembers,Date date){
        this.contentID = (Long) cnt++;
        this.contentTitle = contentTitle;
        datePublished = date;
        this.cast = CastMembers;
        this.director = director;
        this.genres = genres;
        this.language = language;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        Rate_Sum = 0;
        for(WatchRecord Record: DataBase.watchRecordData.getDataByString(contentTitle,0)){
            Rate_Sum += Record.Rating;
            RateCounter++;
        }
    }

    public Content(Long Id,String contentTitle,String language, String country,String director,int budget, int revenue,List<String> genres,List<String>CastMembers,Date date){
        this.contentID = Id;
        cnt = Id+1;
        this.contentTitle = contentTitle;
        datePublished = date;
        this.cast = CastMembers;
        this.director = director;
        this.genres = genres;
        this.language = language;
        this.country = country;
        this.budget = budget;
        this.revenue = revenue;
        Rate_Sum = 0;
        for(WatchRecord Record: DataBase.watchRecordData.getDataByString(contentTitle,0)){
            Rate_Sum += Record.Rating;
            RateCounter++;
        }
    }

    public void AddRate(int UserID, float rate)  {
        DataBase.watchRecordData.addData(new WatchRecord((long) UserID,rate, contentTitle, new Date()));
        RateCounter++;
        Rate_Sum += rate;
    }

    public void EditRate(int UserID, String contentTitle, float rate){
        WatchRecord WatchRecordTemp = DataBase.watchRecordData.removeData(contentTitle+","+Long.valueOf((long)UserID).toString(),1).get(0);
        Rate_Sum -= WatchRecordTemp.Rating;
        WatchRecordTemp.Rating = (Float) rate;
        Rate_Sum += rate;
        DataBase.watchRecordData.addData(WatchRecordTemp);
    }
    public float TotalRate(){
        return (Rate_Sum/RateCounter);
    }
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public Long getId(int op){
        return contentID;
    }
    @Override
    public String getName(int op){
        return contentTitle;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(contentID.toString());
        sb.append(",");
        sb.append(contentTitle);
        sb.append(",");
        sb.append(language);
        sb.append(",");
        sb.append(country);
        sb.append(",");
        sb.append(director);
        sb.append(",");
        sb.append(Integer.valueOf(budget).toString());
        sb.append(",");
        sb.append(Integer.valueOf(revenue).toString());
        sb.append(",");
        sb.append(Integer.valueOf(genres.size()).toString());
        sb.append(",");
        for (String s : genres)
        {
            sb.append(s);
            sb.append(",");
        }
        sb.append(Integer.valueOf(cast.size()).toString());
        sb.append(",");
        for (String s : cast){
            sb.append(s);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(System.lineSeparator());
        sb.append(DateFormat.getInstance().format(datePublished));
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}

