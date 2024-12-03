package App;
import DataBase.DataBase;
import java.util.Scanner;

public class tmp {
    public void LoginDisplay()
    {
        Scanner input = new Scanner(System.in);
        String c;
        boolean check;
        do {
            do {
                System.out.print("Do you have an account? \n (Y/N) ");
                c = input.nextLine();
                if ((c.charAt(0) == 'Y' || c.charAt(0) == 'y' || c.charAt(0) == 'N' || c.charAt(0) == 'n') && c.length() == 1)
                    break;
                else
                    System.out.println("Invalid input, Please try again");
            }while (true);
            if (c.charAt(0) == 'Y' || c.charAt(0) == 'y')
                check = DataBase.getInstance().Login();
            else
                check = DataBase.getInstance().Register();
            if (check)
                break;
        }while (true);
    }
}
