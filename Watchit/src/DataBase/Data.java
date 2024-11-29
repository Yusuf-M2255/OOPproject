package DataBase;

import java.util.List;

public interface Data <T> {
    public void LoadData();
    public void SaveData();
    public T[] getData();
    public List<T> getDataAsList();
    public T getDataByName(String name);
    public T[] getDataThatContains(String searchText);
    public void addData(T data);
    public void removeData(String name);
}
