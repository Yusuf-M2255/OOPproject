package ContentControl;

import DataBase.DataObject;

import java.text.DateFormat;
import java.util.Date;

public class WatchRecord extends DataObject {
    public Float Rating;
    public Date DateOfWatching;
    public String ContentTitle;
    public Long UserId;
    public WatchRecord(long UserId, float Rating, String Content,Date DateOfWatching) {
        this.Rating = (Float) Rating;
        this.DateOfWatching = DateOfWatching;
        this.ContentTitle = Content;
        this.UserId = (Long) UserId;
    }
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public String toString() {
        return UserId.toString()+" "+Rating.toString()+" "+ ContentTitle+System.lineSeparator()+
                DateFormat.getInstance().format(DateOfWatching.toString())+System.lineSeparator();
    }
    @Override
    public Long getId(int op){
        return UserId;
    }
    public String getName(int op){
        if(op==0)
            return ContentTitle;
        return ContentTitle+" "+UserId.toString();
    }
}
