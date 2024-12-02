package App;

import AccountControl.User;
import DataBase.DataBase;

public class Main {
    public static void main(String[] args) {
        DataBase.getInstance().usersData.Display(DataBase.getInstance().usersData.getDataThatContains("Say",0).toArray(new User[0]));
    }
}