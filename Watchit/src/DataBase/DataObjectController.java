package DataBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Used to search on Data Object , Load ,Save,Add and Remove Data from it
 * @param <T> Data Object Type
 */
public class DataObjectController <T> {
    List<T>data;
    final String Code;
    final File file;
    final char type;

    /**
     *  NoN-Parametrized Constructor that used to initialize object that Not saved in files
     */
    DataObjectController() {
        data = new ArrayList<>();
        type = '\0';
        Code = null;
        file = null;
    }

    /**
     * Parametrized Constructor that used to initialize objects which is saved in files
     * @param filePath path of file that contains data and in end of program will be saved there
     * @param Code Slang code to Load Data
     * @param type of T entered which is refers to Instance Creator Class
     */
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

    /**
     * used to Run Slang code then make Instance by data and push it in data List
     */
    private void Read(){
        Slang sLangCode = new Slang(file,Code);
        while(sLangCode.notNull()){
            InstanceCreator<T>creator = new InstanceCreator<T>(sLangCode.Run(sLangCode.Code),data,type);
        }
    }

    /**
     * Saving data at the end of Program
     */
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

    /**
     * @param name the input you search
     * @param op check the function getId in the module (watchRecordData -> WatchRecord)
     * @return List of module Type
     */
    public List<T> getDataByString(String name,int op){
        List<T>SearchedData = new ArrayList<>();
        data.stream().filter(item -> ((DataObject)item).getName(op).equals(name)).forEach(SearchedData::add);
        return SearchedData;
    }

    /**
     * Data By full obj
     * @param obj the obj you search
     * @return that Obj
     */
    public T getDataByObject(T obj){
        return data.stream().filter(item -> (item).equals(obj)).findFirst().orElse(null);
    }

    /**
     * Search Specific Element by its ID
     * @param Id of element
     * @return the element its found otherwise return null
     */
    public T getDataById(Long Id){
        int l = 0,r = data.size()-1;
        while (l<=r){
            int m = (l+r)/2;
            if(((DataObject)(data.get(m))).getId(0)>Id){
                r = m-1;
            }else if(((DataObject)(data.get(m))).getId(0)<Id){
                l = m+1;
            }else
                return data.get(m);
        }
        return null;
    }

    /**
     * @param Num the input you search
     * @param op check the function getId in the module (watchRecordData -> WatchRecord)
     * @return List of module Type
     */
    public List<T> getDateByNum(Long Num,int op){
        List<T>SearchedData = new ArrayList<>();
        data.stream().filter(item -> ((DataObject)item).getId(op).equals(Num)).forEach(SearchedData::add);
        return SearchedData;
    }

    /**
     * function that used to get the users that contains searchText
     * @param searchText is the substring of user you search
     * @return User[]
     */
    public List<T> getDataThatContains(String searchText,int op){
        List<T>ret=new ArrayList<>();
        data.stream().filter(item -> ((DataObject)item).getName(op).contains(searchText)).forEach(ret::add);
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
     * @return List<T>
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

    /**
     * remove all data that equal to Name
     * @param name the name you search
     * @param op go to module to understand
     * @return List of Module Type
     */
    public List<T> removeData(String name,int op){
        List<T> item = getDataByString(name,op);
        for (T item1 : item) {
            data.remove(item1);
            if(type=='U'||type=='A')
                DataBase.accountsData.removeData(((DataObject)item1).getId(0),0);
            else if(type=='S'||type=='M')
                DataBase.contentsData.removeData(((DataObject)item1).getId(0),0);
        }

        return item;
    }

    /**
     * remove all data that equal to Name
     * @param Num the name you search
     * @param op  -> -1 if your search specific element (ID)
     *            -> otherwise check function getId in module
     */
    public List<T> removeData(long Num,int op){
        if(op == -1) {
            List<T> items = new ArrayList<>();
            items.add(getDataById(Num));
            data.remove(getDataById(Num));
            if (type == 'U' || type == 'A')
                DataBase.accountsData.removeData(Num,0);
            else if (type == 'S' || type == 'M')
                DataBase.contentsData.removeData(Num,0);
            return items;
        }else{
            List<T> items = getDateByNum(Num,op);
            for (T item1 : items) {
                data.remove(item1);
            }
            return items;
        }
    }

    /**
     * remove full obj
     * @param obj object you want to remove
     */
    public void removeData(T obj){
        data.remove(obj);
    }

    /**
     * remove all Expired Credit Card / Subscriptions
     */
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

    /**
     * Displays Array of module Type
     * @param displayedData data you want Display
     */
    public void Display(T[] displayedData){
        boolean ok = true;
        for (T item : displayedData) {
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
}
