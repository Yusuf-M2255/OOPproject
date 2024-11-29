package Cast;
import java.util.Date;
import java.util.List;

public class CastMember {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;  
    public String gender;
    public List<String> Contents;
    public String nationality;
    public String socialMediaLink;
    public CastMember(String firstName, String lastName, Date dateOfBirth, String gender, List<String>Contents, String nationality, String socialMediaLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.Contents = Contents;
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
    }
   public void joinMovie(String movie){
        Contents.add(movie);
   }

}
