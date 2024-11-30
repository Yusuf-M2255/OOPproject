package DataBase;

import Cast.CastMember;
import ContentControl.WatchRecord;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            if(!watchRecordFile.exists()){
                watchRecordFile.createNewFile();
            }
            Scanner scanner = new Scanner(watchRecordFile);
            while (scanner.hasNextLine()) {
                String lineScanner = scanner.nextLine();
                Long UserID = Long.parseLong(lineScanner);
                lineScanner = scanner.nextLine();
                Date dateOfWatching = DateFormat.getInstance().parse(lineScanner);
                lineScanner = scanner.nextLine();
                String[] data = lineScanner.split(" ");
                String ContentName = data[0];
                Float Rating = Float.parseFloat(data[1]);
                watchRecords.add(new WatchRecord(UserID,ContentName,dateOfWatching,Rating));
            }
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
            if(!watchRecordFile.exists()){
                watchRecordFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(watchRecordFile);
            for (WatchRecord record : watchRecords){
                fos.write(record.UserId.toString().getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(record.DateOfWatching.toString().getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(record.Content.getBytes());
                fos.write(" ".getBytes());
                fos.write(record.Rating.toString().getBytes());
                fos.write(System.lineSeparator().getBytes());
            }
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
