package App;


import Cast.CastMember;
import DataBase.DataBase;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase.getInstance();
        DataBase.getInstance().castMembersData.removeData(3);
        DataBase.getInstance().castMembersData.addData(new CastMember("hossam","essam","male","Egyption","https://..",new ArrayList<>(),new Date()));
        DataBase.getInstance().Save();
    }
}