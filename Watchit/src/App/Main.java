package App;
import DataBase.DataBase;

public class Main {
    public static void main(String[] args) {
        System.out.println("                                                                                             Welcome To WatchIt Lite");
        DataBase.getInstance();
        tmp t = new tmp();
        t.LoginDisplay();
        DataBase.getInstance().Save();
        t.DisplayMain();
        DataBase.getInstance().Save();
    }
}