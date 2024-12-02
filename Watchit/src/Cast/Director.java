package Cast;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class Director extends CastMember {
    public Director(String firstName, String lastName, String gender, String nationality, String socialMediaLink, List<String>Contents,Date dateOfBirth) {
        super(firstName,lastName,gender,nationality,socialMediaLink,Contents,dateOfBirth);
    }
    public Director(Long Id,String firstName, String lastName, String gender, String nationality, String socialMediaLink, List<String>Contents,Date dateOfBirth) {
        super(Id,firstName,lastName,gender,nationality,socialMediaLink,Contents,dateOfBirth);
    }
    //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CastMemberId.toString()+" ");
        sb.append(firstName + " " + lastName+" "+gender+" "+nationality+" "+socialMediaLink+" ");
        sb.append(Integer.valueOf(Contents.size()).toString()+" ");
        for (int i = 0; i < Contents.size(); i++) {
            sb.append(Contents.get(i)+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(System.lineSeparator());
        sb.append(DateFormat.getInstance().format(dateOfBirth));
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
