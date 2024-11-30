package Cast;

import java.util.Date;
import java.util.List;

public class Director extends CastMember {
    public Director(String firstName, String lastName, Date dateOfBirth, String gender, String nationality, String socialMediaLink, List<String>Contents) {
        super(firstName,lastName,dateOfBirth,gender,Contents,nationality,socialMediaLink);
    }
}
