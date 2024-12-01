package ContentControl;

import java.util.Date;

public class Episode {
  // Variables
  private final int episodeNumber;
  private final String episodeTitle;
  private final int duration;
  private final Date releaseDate;

  // Constructors
  public Episode(int episodeNumber, String episodeTitle, int duration, Date releaseDate) {
    this.episodeNumber = episodeNumber;
    this.episodeTitle = episodeTitle;
    this.duration = duration;
    this.releaseDate = releaseDate;
  }

  // Getters & Setters
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
