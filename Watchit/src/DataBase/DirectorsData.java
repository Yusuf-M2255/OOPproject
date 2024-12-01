package DataBase;

import Cast.Director;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DirectorsData implements Data<Director>,ReadableClass{
    private List<Director> Directors =null ;
    public DirectorsData(){
        Directors = new ArrayList<>();
        //LoadData();
    }

    /**
     * get Data of Directors from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData() {
        File DirectorsFile = new File("./Directors.txt");
        try {
            if(!DirectorsFile.exists()){
                DirectorsFile.createNewFile();
            }
            ElarabyLanguage DirectorL = new ElarabyLanguage(DirectorsFile,"nsw5SWoSnd");
            while (DirectorL.notNull()) {
                ReturnedData re = DirectorL.Run(DirectorL.Code);
                Directors.add(new Director(re.strings.get(0),re.strings.get(1), re.strings.get(2),re.strings.get(3),re.strings.get(4),re.stringLists.get(0),re.dates.get(0)));
            }
        }catch (FileNotFoundException e){
            System.out.println("File Directors.txt is not found");
        }
        catch(IOException e){
            System.out.println("creating file Directors.txt failed");
        }
        catch (Exception e){
            System.out.println("error while opening");
        }
    }


    /**
     * save Data of Directors in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File DirectorsFile = new File("./Directors.txt");
        try {
            if(!DirectorsFile.exists()){
                DirectorsFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(DirectorsFile);
            for (Director director : Directors){
                fos.write(director.toString().getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("File Directors.txt is not found");
        }
        catch(IOException e){
            System.out.println("creating file Directors.txt failed");
        }
        catch (Exception e){
            System.out.println("Save Directors.txt failed");
        }
    }

    /**
     * function that used to get the Director by its name
     * @param name name of Director you want to get it
     * @return Director
     */
    public Director getDataByName(String name){
        for (Director Director : Directors) {
            if(Director.firstName.equals(name))
                return Director;
        }
        return null;
    }

    public Director getDataById(Long Id){
        int l = 0,r = Directors.size()-1;
        while (l<=r){
            int m = (l+r)/2;
            if(Directors.get(m).CastMemberId>Id){
                r = m-1;
            }else if(Directors.get(m).CastMemberId<Id){
                l = m+1;
            }else
                return Directors.get(m);
        }
        return null;
    }

    public Director[] getAllDataByName(String name){
        List<Director>directors=new ArrayList<>();
        for (Director Director : Directors) {
            if(Director.firstName.equals(name))
                directors.add(Director);
        }
        return directors.toArray(new Director[0]);
    }
    /**
     * function that used to get the Directors that contains searchText
     * @param searchText is the substring of Directors you search
     * @return Director[]
     */
    public Director[] getDataThatContains(String searchText){
        List<Director> Searched = new ArrayList<Director>();
        for (Director Director : Directors) {
            if(Director.firstName.contains(searchText))
                Searched.add(Director);
        }
        return Searched.toArray(new Director[0]);
    }


    /**
     * function that return all Directors in application
     * @return Director[]
     */
    public Director[] getData() {
        return Directors.toArray(new Director[0]);
    }

    /**
     * function that return all Directors in application as List
     * @return List<Director>
     */
    public List<Director> getDataAsList() {
        return Directors;
    }

    /**
     * function that add new Director to application
     * @param Director the Director that will be added
     */
    public void addData(Director Director){
        Directors.add(Director);
    }

    /**
     * function that remove Director from application
     * @param Director name of Director that will be removed
     */
    public void removeData(String Director){
        Directors.remove(getDataByName(Director));
    }
    public void removeData(long Id){
        while(getDataById(Long.valueOf(Id))!=null) {
            Directors.remove(getDataById(Long.valueOf(Id)));
        }
    }

}
