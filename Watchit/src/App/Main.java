package App;


import DataBase.DataBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        DataBase.getInstance().Register();
        DataBase.getInstance().Save();
        System.out.println("                                                                                            Welcome To WatchIt Lite");
        tmp t = new tmp();
        t.LoginDisplay();
    }
}