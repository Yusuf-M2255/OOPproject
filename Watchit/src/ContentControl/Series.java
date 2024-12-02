package ContentControl;

import Cast.Director;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Series extends Content{

    // Variables
    private Integer numberOfEpisodes;
    private Date lastAireDate;
    private Integer onGoing;
    // Constructors
    public Series(String contentTitle, String language, String country,String director, int budget, int revenue,int numberOfEpisodes, int onGoing, List<String> genres, List<String> CastMembers, Date date, Date lastAireDate) {
        super(contentTitle, language, country,director, budget, revenue, genres, CastMembers, date);
        this.numberOfEpisodes = numberOfEpisodes;
        this.lastAireDate = lastAireDate;
        this.onGoing = onGoing;
    }
    public Series(Long Id,String contentTitle, String language, String country,String director, int budget, int revenue,int numberOfEpisodes, int onGoing, List<String> genres, List<String> CastMembers, Date date, Date lastAireDate) {
        super(Id,contentTitle, language, country,director, budget, revenue, genres, CastMembers, date);
        this.numberOfEpisodes = numberOfEpisodes;
        this.lastAireDate = lastAireDate;
        this.onGoing = onGoing;
    }

    // Getters & Setters
    public Integer getNumberOfEpisodes() {
        return numberOfEpisodes;
    }
    public void setNumberOfEpisodes(int numberOfEpisodes) {
        this.numberOfEpisodes = numberOfEpisodes;
    }
    public Date getLastAireDate() {
        return lastAireDate;
    }
    public void setLastAireDate(Date lastAireDate) {
        this.lastAireDate = lastAireDate;
    }
    public Integer isOnGoing() {
        return onGoing;
    }
    public void setOnGoing(Integer onGoing) {
        this.onGoing = onGoing;
    }

    //DataBase override methods
    @Override
    public String toString() {
        return super.toString()+numberOfEpisodes+" "+onGoing+System.lineSeparator()+ DateFormat.getInstance().format(lastAireDate) +System.lineSeparator();
    }
}
