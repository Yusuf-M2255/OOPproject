package App;


import DataBase.DataBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DataBase.getInstance();
        DataBase.getInstance().Login();
        DataBase.getInstance().Save();
    }
}