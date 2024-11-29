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
    public AdminsData adminsData= null;
    private List<Account> accounts = null;
    private MoviesData moviesData = null;
    public UsersData usersData = null;
    public WatchRecordData watchRecordData = null;
    private SeriesData seriesData = null;
    private List<Content> contents = null;
    public DirctorsData DirectorsData = null;
    public CastMembersData castMembersData = null;
    private DataBase() {
        usersData = new UsersData();
        adminsData = new AdminsData();
        moviesData = new MoviesData();
        seriesData = new SeriesData();
        watchRecordData = new WatchRecordData();
        DirectorsData = new DirctorsData();
        castMembersData = new CastMembersData();
        accounts = new ArrayList<>();
        contents = new ArrayList<>();
    }
    public void ContentLoad(){
        contents.addAll(moviesData.getDataAsList());
        //contents.addAll(seriesData.getDataAsList());
        accounts.addAll(usersData.getDataAsList());
        //accounts.addAll(adminsData.getDataAsList())
    }

    public static DataBase getInstance() {
        if(dataBase == null)
            return dataBase = new DataBase();
        return dataBase;
    }

    public void Load(){
        ContentLoad();
    }

    public void Save(){
        moviesData.SaveData();
        seriesData.SaveData();
    }


}
