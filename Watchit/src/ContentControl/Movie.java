package ContentControl;
import java.util.Date;
import java.util.List;

public class Movie extends Content{
  // Variables
  private final int duration;
  // Constructor
  public Movie(String contentTitle, String language, String country,String director, int budget, int revenue, int duration,List<String> genres, List<String> CastMembers,Date date) {
    super(contentTitle, language, country,director, budget, revenue, genres, CastMembers, date);
    this.duration = duration;
  }
  public Movie(Long Id,String contentTitle, String language, String country,String director, int budget, int revenue, int duration,List<String> genres, List<String> CastMembers,Date date) {
    super(Id,contentTitle, language, country,director, budget, revenue, genres, CastMembers, date);
    this.duration = duration;
  }
  // Getters & Setters
  public int getDuration() {
    return duration;
  }

  //--------------------------------------DataBase Methods-----------------------------------------//
  @Override
  public String toString() {
    return super.toString() + Integer.valueOf(duration).toString() +System.lineSeparator();
  }
}
