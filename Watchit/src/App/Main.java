package App;


import DataBase.DataBase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("                                                                                            Welcome To WatchIt Lite");
        Scanner input = new Scanner(System.in);
        char c;
        boolean check = false;
        do {
            do {
                System.out.print("Do you have an account? \n (Y/N) ");
                c = input.next().charAt(0);
                if (c == 'Y' || c == 'y' || c == 'N' || c == 'n')
                    break;
                else
                    System.out.println("Invalid input, Please try again");
            }while (true);
            if (c == 'Y' || c == 'y')
                check = DataBase.getInstance().Login();
            else
                check = DataBase.getInstance().Register();
            if (check)
                break;
        }while (true);
    }
}