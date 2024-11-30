package ContentControl;

import java.util.Date;

public class WatchRecord {
    public Float Rating;
    public Date DateOfWatching;
    public String Content;
    public Long UserId;
    public WatchRecord(long UserId, String Content,Date DateOfWatching, float Rating) {
        this.Rating = Rating;
        this.DateOfWatching = DateOfWatching;
        this.Content = Content;
        this.UserId = UserId;
    }
}
