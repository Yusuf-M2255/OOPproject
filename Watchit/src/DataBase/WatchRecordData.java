package DataBase;

import ContentControl.WatchRecord;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Scanner;

public class WatchRecordData implements Data<WatchRecord> {
    List<WatchRecord> watchRecords = null;
    public  WatchRecordData(){
        watchRecords = new ArrayList<>();
        //LoadData();
    }
    /**
     * get Data of Series from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData(){
        File watchRecordFile = new File("/watchRecord.txt");
        try {
            Scanner scanner = new Scanner(watchRecordFile);
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
        File watchRecordFile = new File("/watchRecord.txt");
        try {
            FileOutputStream fos = new FileOutputStream(watchRecordFile);
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
    public WatchRecord getDataByName(String name){
        for (WatchRecord watchRecord : watchRecords) {
            //if(watchRecord.getName().equals(name))
            return watchRecord;
        }
        return null;
    }

    /**
     * function that used to get the series that contains searchText
     * @param searchText is the substring of series you search
     * @return Series[]
     */
    public WatchRecord[] getDataThatContains(String searchText){
        List<WatchRecord> Searched = new ArrayList<>();
        for (WatchRecord watchRecord : watchRecords) {
            //if(movie.getName().contains(searchText))
            Searched.add(watchRecord);
        }
        return Searched.toArray(new WatchRecord[0]);
    }

    /**
     * function that return all series in application
     * @return Series[]
     */
    public WatchRecord[] getData() {
        return watchRecords.toArray(new WatchRecord[0]);
    }

    @Override
    public List<WatchRecord> getDataAsList() {
        return watchRecords;
    }

    /**
     * function that add new series to application
     * @param watchRecord the series that will be added
     */
    public void addData(WatchRecord watchRecord){
        watchRecords.add(watchRecord);
    }

    /**
     * function that remove series from application
     * @param watchRecord name of watchRecord that will be removed
     */
    public void removeData(String watchRecord){
        watchRecords.remove(getDataByName(watchRecord));
    }
}
