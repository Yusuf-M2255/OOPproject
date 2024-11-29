package Cast;

import java.util.Date;
import ContentControl.Content;
public class Director {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String gender;
    public int DirectorWorksNumber;
    public String[] Contents;
    public String nationality;
    public String socialMediaLink;

    public Director(String firstName, String lastName, Date dateOfBirth, String gender, String[] Contents, String nationality, String socialMediaLink) {
        DirectorWorksNumber++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.Contents = Contents;
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
    }
}
