package App;


import DataBase.DataBase;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        DataBase.getInstance().Register();
        DataBase.getInstance().Save();
    }
}