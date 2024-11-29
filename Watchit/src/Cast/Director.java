package Cast;

import java.util.Date;

public class Director {
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String gender;
    public Movie [] movies;
    public String nationality;
    public String socialMediaLink;

    public Director(String firstName, String lastName, Date dateOfBirth, String gender, Movie[] movies, String nationality, String socialMediaLink) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.movies = movies;
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
    }
}
