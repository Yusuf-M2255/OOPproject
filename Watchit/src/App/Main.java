package App;

import DataBase.DataBase;

public class Main {
    public static void main(String[] args) {
        DataBase.getInstance().Register();
        DataBase.getInstance().usersData.SaveData();
    }
}