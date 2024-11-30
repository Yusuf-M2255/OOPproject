package DataBase;

import AccountControl.Admin;
import ContentControl.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminsData implements Data<Admin>,ReadableClass{
    private List<Admin> admins =null ;
    public AdminsData(){
        admins = new ArrayList<>();
        //LoadData();
    }

    /**
     * get Data of admins from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData(){
        File adminsFile = new File("./admins.txt");
        try {
            Scanner scanner = new Scanner(adminsFile);
        }catch (FileNotFoundException e){
            System.out.println("File admins.txt is not found");
        }
        catch (Exception e){
            System.out.println("error while opening");
        }
    }


    /**
     * save Data of admins in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File adminsFile = new File("./admins.txt");
        try {
            if(!adminsFile.exists()){
                adminsFile.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(adminsFile);
        }catch (FileNotFoundException e){
            System.out.println("File admins.txt is not found");
        }
        catch (Exception e){
            System.out.println("Save admins.txt failed");
        }
    }

    public Admin getDataById(Long id){
        return null;
    }

    /**
     * function that used to get the Admin by its name
     * @param name name of Admin you want to get it
     * @return Admin
     */
    public Admin getDataByName(String name){
        for (Admin admin : admins) {
            //if(admin.getName().equals(name))
            return admin;
        }
        return null;
    }

    /**
     * function that used to get the Admins that contains searchText
     * @param searchText is the substring of admins you search
     * @return Admin[]
     */
    public Admin[] getDataThatContains(String searchText){
        List<Admin> Searched = new ArrayList<Admin>();
        for (Admin admin : admins) {
            //if(admin.getName().contains(searchText))
            Searched.add(admin);
        }
        return Searched.toArray(new Admin[0]);
    }

    /**
     * function that return all admins in application
     * @return Admin[]
     */
    public Admin[] getData() {
        return admins.toArray(new Admin[0]);
    }

    /**
     * function that return all admins in application as List
     * @return List<Admin>
     */
    public List<Admin> getDataAsList() {
        return admins;
    }

    /**
     * function that add new admin to application
     * @param admin the admin that will be added
     */
    public void addData(Admin admin){
        admins.add(admin);
    }

    /**
     * function that remove admin from application
     * @param admin name of admin that will be removed
     */
    public void removeData(String admin){
        admins.remove(getDataByName(admin));
    }

    public void removeData(long Id){
        while(getDataById(Id)!=null) {
            admins.remove(getDataById(Id));
        }
    }
}
