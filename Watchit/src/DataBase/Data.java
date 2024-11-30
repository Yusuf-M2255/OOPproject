package DataBase;

import java.util.List;

public interface Data <T> {
    public T[] getData();
    public List<T> getDataAsList();
    public T getDataByName(String name);
    public T[] getDataThatContains(String searchText);
    public T  getDataById(Long Id);
    public void addData(T data);
    public void removeData(String name);
    public void removeData(long Id);
}
