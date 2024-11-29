package Cast;
import java.util.Date;

public class CastMember {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;  
    public String gender;
    public String[] movies; 
    public String nationality;
    public String socialMediaLink;
    public CastMember(String firstName, String lastName, Date dateOfBirth, String gender, String[] movies, String nationality, String socialMediaLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.movies = movies;
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
    }
   public void joinMovie(String movie){
    String[] newMoviesArray = new String[movies.length + 1];
    for (int i = 0; i < movies.length; i++) {
        newMoviesArray[i] = movies[i];
    }
    newMoviesArray[movies.length] = movie;
    movies = newMoviesArray;
   }
    
}
