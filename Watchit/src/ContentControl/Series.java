package ContentControl;

import Cast.Director;

import java.util.Date;
import java.util.List;

public class Series extends Content{
    // Variables
    private int numberOfEpisodes;
    private final Date firstAireDate;
    private Date lastAireDate;
    private boolean onGoing;

    // Constructors
    public Series(String contentTitle, List<String> genres, List<String> CastMembers, String language, String country, int budget, int revenue, java.util.Date date, Director director, int numberOfEpisodes, java.util.Date firstAireDate, java.util.Date lastAireDate, boolean onGoing) {
        super(contentTitle, genres, CastMembers, language, country, budget, revenue, date, director);
        this.numberOfEpisodes = numberOfEpisodes;
        this.firstAireDate = firstAireDate;
        this.lastAireDate = lastAireDate;
        this.onGoing = onGoing;
    }

    // Getters & Setters
    public int getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
    public Date getFirstAireDate() {
        return firstAireDate;
    }
    public Date getLastAireDate() {
        return lastAireDate;
    }
    public void setLastAireDate(Date lastAireDate) {
        this.lastAireDate = lastAireDate;
    }
    public boolean isOnGoing() {
        return onGoing;
    }
    public void setOnGoing(boolean onGoing) {
        this.onGoing = onGoing;
    }
}
