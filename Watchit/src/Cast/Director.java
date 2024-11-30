package Cast;

import java.util.Date;
import java.util.List;

public class Director extends CastMember{

    public Director(String firstName, String lastName, Date dateOfBirth, String gender, List<String> Contents, String nationality, String socialMediaLink) {
        super(firstName, lastName, dateOfBirth, gender, Contents, nationality, socialMediaLink);
    }
}
