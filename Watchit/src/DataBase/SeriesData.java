package DataBase;

import ContentControl.Series;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeriesData implements Data<Series> {
    List<Series>series = null;
    public SeriesData() {
        series = new ArrayList<>();
        LoadData();
    }
    /**
     * get Data of Series from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData(){
        File seriesFile = new File("/series.txt");
        try {
            Scanner scanner = new Scanner(seriesFile);
        }catch (FileNotFoundException e){
            System.out.println("File movies.txt is not found");
        }
        catch (Exception e){
            System.out.println("error while opening");
        }
    }


    /**
     * save Data of Series in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File seriesFile = new File("/series.txt");
        try {
            FileOutputStream fos = new FileOutputStream(seriesFile);
        }catch (FileNotFoundException e){
            System.out.println("File movies.txt is not found");
        }
        catch (Exception e){
            System.out.println("Save movies.txt failed");
        }
    }

    /**
     * function that used to get the Series by its name
     * @param name name of Series you want to get it
     * @return Series
     */
    public Series getDataByName(String name){
        for (Series seriesInstance : series) {
            //if(serie.getName().equals(name))
            return seriesInstance;
        }
        return null;
    }

    /**
     * function that used to get the series that contains searchText
     * @param searchText is the substring of series you search
     * @return Series[]
     */
    public Series[] getDataThatContains(String searchText){
        List<Series> Searched = new ArrayList<Series>();
        for (Series seriesInstance : series) {
            //if(movie.getName().contains(searchText))
            Searched.add(seriesInstance);
        }
        return Searched.toArray(new Series[0]);
    }

    /**
     * function that return all series in application
     * @return Series[]
     */
    public Series[] getData() {
        return series.toArray(new Series[0]);
    }

    @Override
    public List<Series> getDataAsList() {
        return series;
    }

    /**
     * function that add new series to application
     * @param seriesInstance the series that will be added
     */
    public void addData(Series seriesInstance){
        series.add(seriesInstance);
    }

    /**
     * function that remove series from application
     * @param seriesInstance name of series that will be removed
     */
    public void removeData(String seriesInstance){
        series.remove(getDataByName(seriesInstance));
    }

}
