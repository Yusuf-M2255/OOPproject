package Cast;
import java.util.Date;
import java.util.List;

public class Director extends CastMember {
    public Director(String firstName, String lastName, String gender, String nationality, String socialMediaLink,Date dateOfBirth, List<String> contents) {
        super(firstName,lastName,gender,nationality,socialMediaLink,dateOfBirth, contents);
    }
    public Director(Long Id,String firstName, String lastName, String gender, String nationality, String socialMediaLink, List<String>Contents,Date dateOfBirth) {
        super(Id,firstName,lastName,gender,nationality,socialMediaLink,Contents,dateOfBirth);
    }
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public String toString() {
        return super.toString();
    }
}
