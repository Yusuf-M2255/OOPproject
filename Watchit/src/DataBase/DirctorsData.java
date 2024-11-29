package DataBase;

import Cast.Director;
import ContentControl.Series;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirctorsData implements Data<Director> {
    List<Director> Directors = null;
    public DirctorsData() {
        Directors = new ArrayList<>();
        //LoadData();
    }
    /**
     * get Data of Series from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData(){
        File dirctorsFile = new File("director.txt");
        try {
            Scanner scanner = new Scanner(dirctorsFile);
        }catch (FileNotFoundException e){
            System.out.println("File director.txt is not found");
        }
        catch (Exception e){
            System.out.println("error while opening director.txt");
        }
    }


    /**
     * save Data of Series in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File seriesFile = new File("/director.txt");
        try {
            FileOutputStream fos = new FileOutputStream(seriesFile);
        }catch (FileNotFoundException e){
            System.out.println("File director.txt is not found");
        }
        catch (Exception e){
            System.out.println("Save director.txt failed");
        }
    }

    /**
     * function that used to get the Series by its name
     * @param name name of Series you want to get it
     * @return Series
     */
    public Director getDataByName(String name){
        for (Director director : Directors) {
            //if(director.getName().equals(name))
            return director;
        }
        return null;
    }

    /**
     * function that used to get the series that contains searchText
     * @param searchText is the substring of series you search
     * @return Series[]
     */
    public Director[] getDataThatContains(String searchText){
        List<Director> Searched = new ArrayList<>();
        for (Director director : Directors) {
            //if(director.getName().contains(searchText))
            Searched.add(director);
        }
        return Searched.toArray(new Director[0]);
    }

    /**
     * function that return all series in application
     * @return Series[]
     */
    public Director[] getData() {
        return Directors.toArray(new Director[0]);
    }

    /**
     * function that return all Series in application as List
     * @return List<Series>
     */
    public List<Director> getDataAsList() {
        return Directors;
    }

    /**
     * function that add new director to application
     * @param director the director that will be added
     */
    public void addData(Director director){
        Directors.add(director);
    }

    /**
     * function that remove director from application
     * @param director name of director that will be removed
     */
    public void removeData(String director){
        Directors.remove(getDataByName(director));
    }

}
