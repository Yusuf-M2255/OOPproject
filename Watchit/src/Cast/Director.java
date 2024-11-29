package Cast;

import java.util.ArrayList;
import java.util.Date;
import ContentControl.Content;

public class Director {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String gender;
    public int DirectorWorksNumber;
    public ArrayList<String> Contents;
    public String nationality;
    public String socialMediaLink;

    public Director(String firstName, String lastName, Date dateOfBirth, String gender, String nationality, String socialMediaLink, int DirectorWorksNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        Contents = new ArrayList<>();
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
        this.DirectorWorksNumber = DirectorWorksNumber;
    }
}
