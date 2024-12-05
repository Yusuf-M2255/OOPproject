package Cast;
import ContentControl.Content;
import ContentControl.Movie;
import DataBase.DataBase;
import DataBase.DataObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CastMember extends DataObject {
    public String firstName;
    public String lastName;
    public static long cnt = 1;
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
        CastMemberId = cnt++;
    }
    public CastMember(Long Id ,String firstName, String lastName, String gender, String nationality, String socialMediaLink,List<String>Contents, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.Contents =Contents;
        this.nationality = nationality;
        this.socialMediaLink = socialMediaLink;
        CastMemberId = Id;
        cnt = Id+1;
    }
   public void joinContent(String Content){
        Contents.add(Content);
   }
   //--------------------------------------DataBase Methods-----------------------------------------//
    @Override
    public boolean equals(Object o) {
        if(o instanceof CastMember castMember){
            return castMember.firstName.equals(firstName)&&castMember.lastName.equals(lastName)&&castMember.dateOfBirth.equals(dateOfBirth)&&castMember.gender.equals(gender)&&castMember.nationality.equals(nationality);
        }
        return false;
    }
   @Override
   public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(CastMemberId.toString()).append(" ").append(firstName).append(" ").append(lastName).append(" ").append(gender).append(" ").append(nationality).append(" ").append(socialMediaLink).append(" ");
        sb.append(Integer.valueOf(Contents.size()).toString()).append(" ");
        for (var item : Contents) {
            sb.append(item);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(System.lineSeparator());
        sb.append(DateFormat.getInstance().format(dateOfBirth));
        sb.append(System.lineSeparator());
        return sb.toString();
   }
    @Override
    public String getName(int op){
        if(op==0)
            return this.firstName;
        if(op==1)
            return this.lastName;
        if(op==2)
            return this.firstName+" "+this.lastName;
        return null;
    }
    @Override
    public Long getId(int op){
        return this.CastMemberId;
    }
}
