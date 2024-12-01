package DataBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnedData{
    public List<Float> floats;
    public List<String> strings;
    public List<Long> longs;
    public List<Integer> integers;
    public List<Date> dates;
    public List<List<Float>> floatLists;
    public List<List<String>> stringLists;
    public List<List<Long>> longLists;
    public List<List<Integer>> integerLists;
    public List<List<Date>> dateLists;
    public ReturnedData(){
        this.floats = new ArrayList<>();
        this.strings = new ArrayList<>();
        this.longs = new ArrayList<>();
        this.integers = new ArrayList<>();
        this.dates = new ArrayList<>();
        this.floatLists = new ArrayList<>();
        this.stringLists = new ArrayList<>();
        this.longLists = new ArrayList<>();
        this.integerLists = new ArrayList<>();
        this.dateLists = new ArrayList<>();
    }
}
