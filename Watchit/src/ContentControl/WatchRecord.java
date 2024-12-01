package ContentControl;

import DataBase.DataObject;

import java.text.DateFormat;
import java.util.Date;

public class WatchRecord extends DataObject {
    public Float Rating;
    public Date DateOfWatching;
    public String Content;
    public Long UserId;
    public WatchRecord(long UserId, float Rating, String Content,Date DateOfWatching) {
        this.Rating = (Float) Rating;
        this.DateOfWatching = DateOfWatching;
        this.Content = Content;
        this.UserId = (Long) UserId;
    }
    @Override
    public String toString() {
        return UserId.toString()+" "+Rating.toString()+" "+ Content+System.lineSeparator()+
                DateFormat.getInstance().format(DateOfWatching.toString())+System.lineSeparator();
    }
    @Override
    public String getFullName(){
        return UserId.toString()+" "+ Content;
    }
    @Override
    public String getName(){
        return Content;
    }
    @Override
    public Long getId(){
        return UserId;
    }
}
