package ContentControl;

import DataBase.DataObject;

import java.util.Date;

public class Episode extends DataObject {
  // Variables
  private static Long cnt = (long)1;
  private Long Id ;
  private String SeriesName;
  private final int episodeNumber;
  private final String episodeTitle;
  private final int duration;
  private final Date releaseDate;

  // Constructors
  public Episode(String SeriesName,String episodeTitle, int episodeNumber, int duration, Date releaseDate) {
    this.episodeNumber = episodeNumber;
    this.episodeTitle = episodeTitle;
    this.duration = duration;
    this.releaseDate = releaseDate;
    this.SeriesName = SeriesName;
    Id = cnt++;
  }

  public Episode(Long Id,String SeriesName,String episodeTitle, int episodeNumber, int duration, Date releaseDate) {
    this.episodeNumber = episodeNumber;
    this.episodeTitle = episodeTitle;
    this.duration = duration;
    this.releaseDate = releaseDate;
    this.SeriesName = SeriesName;
    this.Id = Id;
    cnt = Id+1;
  }

  // Getters & Setters
  public Long getId() { return Id; }
  public String getSeriesName() { return SeriesName; }
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
