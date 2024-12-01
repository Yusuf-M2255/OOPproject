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

public class CastMembersData implements Data<CastMember>,ReadableClass{
    private List<CastMember> CastMembers =null ;
    public CastMembersData(){
        CastMembers = new ArrayList<>();
        LoadData();
    }

    /**
     * get Data of CastMembers from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData() {
        File CastMembersFile = new File("./CastMembers.txt");
        try {
            if(!CastMembersFile.exists()){
                CastMembersFile.createNewFile();
            }
            ElarabyLanguage CastMemberL = new ElarabyLanguage(CastMembersFile,"nslw5SWoSnd");
            while (CastMemberL.notNull()) {
                ReturnedData re = CastMemberL.Run(CastMemberL.Code);
                CastMembers.add(new CastMember(re.longs.get(0),re.strings.get(0),re.strings.get(1), re.strings.get(2),re.strings.get(3),re.strings.get(4),re.stringLists.get(0),re.dates.get(0)));
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
        File CastMembersFile = new File("./CastMembers.txt");
        try {
            if(!CastMembersFile.exists()){
                CastMembersFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(CastMembersFile);
            for (CastMember castMember : CastMembers){
                fos.write(castMember.toString().getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("File CastMembers.txt is not found");
        }
        catch(IOException e){
            System.out.println("creating file CastMembers.txt failed");
        }
        catch (Exception e){
            e.printStackTrace();
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
            if(CastMember.firstName.equals(name))
                return CastMember;
        }
        return null;
    }

    public CastMember getDataById(Long Id){
        int l = 0,r = CastMembers.size()-1;
        while (l<=r){
            int m = (l+r)/2;
            if(CastMembers.get(m).CastMemberId>Id){
                r = m-1;
            }else if(CastMembers.get(m).CastMemberId<Id){
                l = m+1;
            }else
                return CastMembers.get(m);
        }
        return null;
    }

    public CastMember[] getAllDataByName(String name){
        List<CastMember>castMembers=new ArrayList<>();
        for (CastMember CastMember : CastMembers) {
            if(CastMember.firstName.equals(name))
                castMembers.add(CastMember);
        }
        return castMembers.toArray(new CastMember[0]);
    }
    /**
     * function that used to get the CastMembers that contains searchText
     * @param searchText is the substring of CastMembers you search
     * @return CastMember[]
     */
    public CastMember[] getDataThatContains(String searchText){
        List<CastMember> Searched = new ArrayList<CastMember>();
        for (CastMember CastMember : CastMembers) {
            if(CastMember.firstName.contains(searchText))
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

    public void removeData(long Id){
        while(getDataById(Long.valueOf(Id))!=null) {
            CastMembers.remove(getDataById(Long.valueOf(Id)));
        }
    }
}
