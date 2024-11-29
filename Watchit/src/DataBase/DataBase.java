package DataBase;

import AccountControl.*;
import Cast.CastMember;
import Cast.Director;
import ContentControl.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataBase {
    private static DataBase dataBase;
    private List<Admin> admins = null;
    private List<Account> accounts = null;
    private MoviesData moviesData = null;
    private UsersData usersData = null;
    private SeriesData seriesData = null;
    private List<Content> contents = null;
    private List<WatchRecord> Records = null;
    private List<Director> Directors = null;
    private List<CastMember> CastMembers = null;
    private DataBase() {
        usersData = new UsersData();
        admins = new ArrayList<>();
        moviesData = new MoviesData();
        seriesData = new SeriesData();
        Records = new ArrayList<>();
        Directors = new ArrayList<>();
        CastMembers = new ArrayList<>();
        accounts = new ArrayList<>();
        contents = new ArrayList<>();
        dataBase = new DataBase();
        Load();
    }
    public void ContentLoad(){
//        contents.addAll(moviesData.getDataAsList());
//        contents.addAll(seriesData.getDataAsList());
    }
    public static DataBase getInstance() {
        if(dataBase == null)
            return new DataBase();
        return dataBase;
    }

    public void Load(){
        moviesData.LoadData();
        seriesData.LoadData();
        ContentLoad();
    }

    public void Save(){
        moviesData.SaveData();
        seriesData.SaveData();
    }


}
