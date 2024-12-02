package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataObjectController <T> {
    List<T>data;
    final String Code;
    final File file;
    final char type;

    DataObjectController() {
        data = new ArrayList<>();
        type = '\0';
        Code = null;
        file = null;
    }

    public DataObjectController(String filePath,String Code,char type){
        data = new ArrayList<>();
        file= new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e){
                System.out.println("Error while creating "+file.getName()+" file");
            }
        }
        this.Code=Code;
        this.type=type;
        Read();
    }

    public void Display(T[] da){
        boolean ok = true;
        for (T item : da) {
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
        return data.stream().filter(item -> ((DataObject)item).getName().equals(name)).findFirst().orElse(null);
    }

    public T getDataByFullName(String name){
        return data.stream().filter(item -> ((DataObject)item).getFullName().equals(name)).findFirst().orElse(null);
    }

    public T getDataByEmail(String Email){
        return data.stream().filter(item -> ((DataObject)item).getEmail().equals(Email)).findFirst().orElse(null);
    }

    public T getDataByObject(T obj){
        return data.stream().filter(item -> (item).equals(obj)).findFirst().orElse(null);
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
    public List<T> getDataThatContains(String searchText){
        List<T>ret=new ArrayList<>();
        data.stream().filter(item -> ((DataObject)item).getName().contains(searchText)).forEach(ret::add);
        return ret;
    }

    /**
     * function that return all users in application
     * @return T[]
     */
    public List<T> getData() {
        return data;
    }

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
    }

    public List<T> getAllDataByName(String name){
        List<T> Searched = new ArrayList<>();
        data.stream().filter(item -> ((DataObject)item).getName().equals(name)).forEach(Searched::add);
        return Searched;
    }

    public List<T> getAllDataById(Long Id){
        List<T> Searched = new ArrayList<>();
        data.stream().filter(item -> ((DataObject)item).getId().equals(Id)).forEach(Searched::add);
        return Searched;
    }

    public T removeData(String name){
        T item = getDataByName(name);
        data.remove(getDataByName(name));
        if(type=='U'||type=='A')
            DataBase.accountsData.removeData(name);
        else if(type=='S'||type=='M')
            DataBase.contentsData.removeData(name);
        return item;
    }

    public T removeDataFullName(String name){
        T item = getDataByFullName(name);
        data.remove(getDataByFullName(name));
        if(type=='U'||type=='A')
            DataBase.accountsData.removeData(name);
        else if(type=='S'||type=='M')
            DataBase.contentsData.removeData(name);
        return item;
    }

    public void removeData(long Id){
        data.remove(getDataById(Id));
        if(type=='U'||type=='A')
            DataBase.accountsData.removeData(Id);
        else if(type=='S'||type=='M')
            DataBase.contentsData.removeData(Id);
    }
    public void removeAllExpired(){
        Date newDate = new Date();
        int i = 0;
        while(i<data.size()){
            if(((DataObject)(data.get(i))).getDate().compareTo(newDate)<0)
                data.remove(i);
            else
                i++;
        }
    }
}
