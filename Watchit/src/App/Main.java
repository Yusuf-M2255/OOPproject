package App;


import DataBase.DataBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("                                                                                            Welcome To WatchIt Lite");
        tmp t = new tmp();
        t.LoginDisplay();
        DataBase.getInstance().Save();
    }
}