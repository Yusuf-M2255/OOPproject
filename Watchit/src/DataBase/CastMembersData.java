package DataBase;

import Cast.CastMember;

import javax.xml.catalog.Catalog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class CastMembersData implements Data<CastMember>{
    private List<CastMember> CastMembers =null ;
    public CastMembersData(){
        CastMembers = new ArrayList<>();
        //LoadData();
    }

    /**
     * get Data of CastMembers from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData() {
        File CastMembersFile = new File("CastMembers.txt");
        try {
            if(!CastMembersFile.exists()){
                CastMembersFile.createNewFile();
            }
            Scanner scanner = new Scanner(CastMembersFile);
            while (scanner.hasNextLine()) {
                String lineScanner = scanner.nextLine();
                String[] data = lineScanner.split(" ");
                String firstname = data[0];
                String lastname = data[1];
                lineScanner = scanner.nextLine();
                String date = lineScanner;
                lineScanner = scanner.nextLine();
                data = lineScanner.split(" ");
                String gender = data[0];
                String nationality = data[1];
                String socialMediaLink = data[2];
                Long size = Long.parseLong(data[3]);
                List<String>contents=new ArrayList<>();
                for (int i = 0;i<size;i++){
                    contents.add(data[4+i]);
                }
                CastMembers.add(new CastMember(firstname,lastname, DateFormat.getDateInstance().parse(date),gender,contents,nationality,socialMediaLink));
            }
        }catch (FileNotFoundException e){
            System.out.println("File CastMembers.txt is not found");
        }
        catch(IOException e){
            System.out.println("creating file CastMembers.txt failed");
        }
        catch (Exception e){
            System.out.println("error while opening");
        }
    }


    /**
     * save Data of CastMembers in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File CastMembersFile = new File("/CastMembers.txt");
        try {
            if(!CastMembersFile.exists()){
                CastMembersFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(CastMembersFile);
            for (CastMember castMember : CastMembers){
                fos.write(castMember.firstName.getBytes());
                fos.write(" ".getBytes());
                fos.write(castMember.lastName.getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(castMember.dateOfBirth.toString().getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(castMember.gender.toString().getBytes());
                fos.write(" ".getBytes());
                fos.write(castMember.nationality.toString().getBytes());
                fos.write(" ".getBytes());
                fos.write(castMember.socialMediaLink.toString().getBytes());
                fos.write(" ".getBytes());
                fos.write(castMember.Contents.size());
                fos.write(" ".getBytes());
                for (String content : castMember.Contents){
                    fos.write(content.getBytes());
                    fos.write(" ".getBytes());
                }
                fos.write(System.lineSeparator().getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("File CastMembers.txt is not found");
        }
        catch(IOException e){
            System.out.println("creating file CastMembers.txt failed");
        }
        catch (Exception e){
            System.out.println("Save CastMembers.txt failed");
        }
    }

    /**
     * function that used to get the CastMember by its name
     * @param name name of CastMember you want to get it
     * @return CastMember
     */
    public CastMember getDataByName(String name){
        for (CastMember CastMember : CastMembers) {
            //if(CastMember.getName().equals(name))
            return CastMember;
        }
        return null;
    }

    /**
     * function that used to get the CastMembers that contains searchText
     * @param searchText is the substring of CastMembers you search
     * @return CastMember[]
     */
    public CastMember[] getDataThatContains(String searchText){
        List<CastMember> Searched = new ArrayList<CastMember>();
        for (CastMember CastMember : CastMembers) {
            //if(CastMember.getName().contains(searchText))
            Searched.add(CastMember);
        }
        return Searched.toArray(new CastMember[0]);
    }

    /**
     * function that return all CastMembers in application
     * @return CastMember[]
     */
    public CastMember[] getData() {
        return CastMembers.toArray(new CastMember[0]);
    }

    /**
     * function that return all CastMembers in application as List
     * @return List<CastMember>
     */
    public List<CastMember> getDataAsList() {
        return CastMembers;
    }

    /**
     * function that add new CastMember to application
     * @param CastMember the CastMember that will be added
     */
    public void addData(CastMember CastMember){
        CastMembers.add(CastMember);
    }

    /**
     * function that remove CastMember from application
     * @param CastMember name of CastMember that will be removed
     */
    public void removeData(String CastMember){
        CastMembers.remove(getDataByName(CastMember));
    }

}
