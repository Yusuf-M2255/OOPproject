package ContentControl;

import DataBase.DataObject;

import java.text.DateFormat;
import java.time.Duration;
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
  public String getSeriesName() { return SeriesName; }
  public int getEpisodeNumber(){
    return this.episodeNumber;
  }
  public String getEpisodeTitle(){
    return this.episodeTitle;
  }
  public int getDuration(){
    return this.duration;
  }
  public Date getreleaseDate(){
    return this.releaseDate;
  }
  //--------------------------------------DataBase Methods-----------------------------------------//
  @Override
  public String toString() {
    return Id.toString()+","+SeriesName+","+episodeTitle+","+
            Integer.valueOf(episodeNumber).toString()+Integer.valueOf(duration).toString()+
            System.lineSeparator()+ DateFormat.getInstance().format(releaseDate) +System.lineSeparator();
  }
  @Override
  public boolean equals(Object o) {
    if(o instanceof  Episode){
      Episode ep = (Episode)o;
      return ep.episodeTitle.equals(episodeTitle) && ep.episodeNumber == episodeNumber && ep.releaseDate.equals(releaseDate);
    }
    return false;
  }

  /**
   * @param op send any Value
   * @return Long Id
   */
  @Override
  public Long getId(int op) {
    return Id;
  }

  /**
   * @param op
   * 0 -> Series Name       /
   * 1 -> Episode Title     /
   * 2 -> Series + " " + Episode Number
   * @return String
   */
  @Override
  public String getName(int op){
    if(op==0)
      return this.SeriesName;
    if(op==1)
      return episodeTitle;
    return SeriesName+" "+Integer.valueOf(episodeNumber).toString();
  }
}
