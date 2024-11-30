package ContentControl;

import java.util.Date;

public class Episode {
  // Variables
  private int episodeNumber;
  private String episodeTitle;
  private int duration;
  private Date releaseDate;

  // Constructors
  public Episode(int episodeNumber, String episodeTitle, int duration, Date releaseDate) {
    this.episodeNumber = episodeNumber;
    this.episodeTitle = episodeTitle;
    this.duration = duration;
    this.releaseDate = releaseDate;
  }

  // getters
  public int getepisodeNumber(){
    return this.episodeNumber;
  }
  public String getepisodeTitle(){
    return this.episodeTitle;
  }
  public int getduration(){
    return this.duration;
  }
  public Date getreleaseDate(){
    return this.releaseDate;
  }

}
