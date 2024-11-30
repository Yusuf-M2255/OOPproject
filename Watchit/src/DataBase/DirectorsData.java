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
        File DirectorsFile = new File("Directors.txt");
        try {
            if(!DirectorsFile.exists()){
                DirectorsFile.createNewFile();
            }
            Scanner scanner = new Scanner(DirectorsFile);
            while (scanner.hasNextLine()) {
                String lineScanner = scanner.nextLine();
                String[] data = lineScanner.split(" ");
                String firstname = data[0];
                String lastname = data[1];
                lineScanner = scanner.nextLine();
                Date date = DateFormat.getDateTimeInstance().parse(lineScanner);
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
                Directors.add(new Director(firstname,lastname,date,gender,nationality,socialMediaLink,contents));
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
        File DirectorsFile = new File("/Directors.txt");
        try {
            if(!DirectorsFile.exists()){
                DirectorsFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(DirectorsFile);
            for (Director director : Directors){
                fos.write(director.firstName.getBytes());
                fos.write(" ".getBytes());
                fos.write(director.lastName.getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(director.dateOfBirth.toString().getBytes());
                fos.write(System.lineSeparator().getBytes());
                fos.write(director.gender.toString().getBytes());
                fos.write(" ".getBytes());
                fos.write(director.nationality.toString().getBytes());
                fos.write(" ".getBytes());
                fos.write(director.socialMediaLink.toString().getBytes());
                fos.write(" ".getBytes());
                fos.write(director.Contents.size());
                fos.write(" ".getBytes());
                for (String content : director.Contents){
                    fos.write(content.getBytes());
                    fos.write(" ".getBytes());
                }
                fos.write(System.lineSeparator().getBytes());
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

}
