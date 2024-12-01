package Cast;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

public class CastMember {
    public String firstName;
    public String lastName;
    public static long cnt = (long) 1;
    public Long CastMemberId;
    public Date dateOfBirth;  
    public String gender;
    public List<String> Contents;
    public String nationality;
    public String socialMediaLink;
    public CastMember(String firstName, String lastName, String gender, String nationality, String socialMediaLink,List<String>Contents, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.Contents = Contents;
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
        CastMemberId = (Long) cnt++;
    }
    public CastMember(Long Id ,String firstName, String lastName, String gender, String nationality, String socialMediaLink,List<String>Contents, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.Contents = Contents;
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
        CastMemberId = Id;
        cnt = Id+1;
    }
   public void joinContent(String Content){
        Contents.add(Content);
   }
   @Override
   public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CastMemberId.toString()+" "+firstName + " " + lastName+" "+gender+" "+nationality+" "+socialMediaLink+" ");
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
