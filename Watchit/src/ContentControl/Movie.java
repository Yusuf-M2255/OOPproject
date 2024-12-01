package ContentControl;

import Cast.Director;

import java.util.Date;
import java.util.List;

public class Movie extends Content{
  // Variables
  private final int duration;

  // Constructor
  public Movie(String contentTitle, List<String> genres, List<String> CastMembers, String language, String country, int budget, int revenue, java.util.Date date, Director director, int duration) {
    super(contentTitle, genres, CastMembers, language, country, budget, revenue, date, director);
    this.duration = duration;
  }

  // Getters & Setters
  public int getDuration() {
    return duration;
  }
}
