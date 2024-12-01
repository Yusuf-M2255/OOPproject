package DataBase;

import AccountControl.Account;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataObjectController <T> {
    List<T>data;
    String Code;
    File file;
    final char type;
    public DataObjectController(File file,String Code,char type){
        data = new ArrayList<>();
        this.file = file;
        this.Code=Code;
        this.type=type;
        Read();
    }

    public void Display(){
        boolean ok = true;
        for (T item : data) {
            DataObject DO = (DataObject)item;
            if(ok) {
                DO.DisplayHeadLine();
                ok = false;
            }
            DO.DisplayLine();
        }
        if(ok)
            System.out.println("There is no Data");
    }

    public void Read(){
        Slang sLangCode = new Slang(file,Code);
        while(sLangCode.notNull()){
            InstanceCreator<T>creator = new InstanceCreator<T>(sLangCode.Run(sLangCode.Code),data,type);
        }
    }

    public void Write(){
        try {
            FileOutputStream fos = new FileOutputStream(file);
            for (T item : data) {
                fos.write(item.toString().getBytes());
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found "+file.getName());
        }catch (IOException e){
            System.out.println("Error while saving "+file.getName());
        }
    }

    public T getDataByName(String name){
        for (T item : data) {
            DataObject DO = (DataObject)item;
            if(DO.getName().equals(name))
                return item;
        }
        return null;
    }

    public T getDataByEmail(String Email){
        for (T item : data) {
            DataObject DO = (DataObject)item;
            if(DO.getEmail().equals(Email))
                return item;
        }
        return null;
    }

    public T getDataById(Long Id){
        int l = 0,r = data.size()-1;
        while (l<=r){
            int m = (l+r)/2;
            if(((DataObject)(data.get(m))).getId()>Id){
                r = m-1;
            }else if(((DataObject)(data.get(m))).getId()<Id){
                l = m+1;
            }else
                return data.get(m);
        }
        return null;
    }

    /**
     * function that used to get the users that contains searchText
     * @param searchText is the substring of user you search
     * @return User[]
     */
    public T[] getDataThatContains(String searchText){
        List<T> Searched = new ArrayList<>();
        for (T item : data) {
            DataObject DO = (DataObject)item;
            if(DO.getName().contains(searchText))
                Searched.add(item);
        }
        return (T[]) Searched.toArray();
    }

    /**
     * function that return all users in application
     * @return User[]
     */
    public T[] getData() {return (T[])data.toArray();}

    /**
     * function that return all Users in application as List
     * @return List<User>
     */
    public List<T> getDataAsList() {
        return data;
    }

    /**
     * function that add new user to application
     * @param item the user that will be added
     */
    public void addData(T item){
        data.add(item);
        if(type=='U')
            DataBase.accountsData.addData((Account)item);
    }

    public List<T> getAllDataByName(String name){
        List<T> Searched = new ArrayList<>();
        for (T item : data) {
            DataObject DO = (DataObject)item;
            if(DO.getName().equals(name))
                Searched.add(item);
        }
        return Searched;
    }

    public List<T> getAllDataById(Long Id){
        List<T> Searched = new ArrayList<>();
        for (T item : data) {
            DataObject DO = (DataObject)item;
            if(DO.getId().equals(Id))
                Searched.add(item);
        }
        return Searched;
    }

    public T removeData(String name){
        T item = getDataByName(name);
        data.remove(getDataByName(name));
        return item;
    }

    public void removeData(long Id){
        data.remove(getDataById(Id));
        if(type=='U')
            DataBase.accountsData.removeData(Id);
    }
}
