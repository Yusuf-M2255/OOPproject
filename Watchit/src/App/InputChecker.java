package App;
import java.util.*;
import Cast.*;

public class InputChecker {

    public String GetValidChoice (String choices, String[] validAnswers)
    {
        Scanner sc = new Scanner(System.in);
        do
        {
            System.out.print(choices);
            String choice = sc.nextLine();
            choices = choices.toLowerCase();
            for (String validAnswer : validAnswers)
            {
                if (choice.equals(validAnswer))
                    return choice;
            }
            System.out.println("Sorry, " + choice + " is not an Invalid input, please try again.");
        }while (true);
    }

    public Director InputDirector (String directorFirstName, String directorLastName, String movieTitle)
    {
        String directorGender, directorNationality, directorSocialMediaLink;
        Date directorDateOfBirth;
        Scanner input = new Scanner(System.in);
        Calendar cal;
        do {
            System.out.print("Enter The director's Date Of Birth (MM/YYYY): ");
            cal = Calendar.getInstance();
            String[] YYMM;
            try {
                YYMM = input.nextLine().split("/");
                cal.set(Integer.parseInt(YYMM[0]), Integer.parseInt(YYMM[1]), 0);
            }catch (NumberFormatException e){
                System.out.println("Invalid Date, Please Try Again");
                continue;
            }
            if ((YYMM[1].length() == 4 && ((YYMM[1].charAt(0) == '1' && YYMM[1].charAt(1) == '9') || (YYMM[1].charAt(0) == '2' && YYMM[1].charAt(1) == '0'))) && ((YYMM[0].length() == 2 && YYMM[0].charAt(0) == '0') || YYMM[0].length() == 1 || YYMM[0].equals("10") || YYMM[0].equals("11") || YYMM[0].equals("12")))
                break;
            else
                System.out.println("Sorry, " + YYMM[0] + "/" + YYMM[1] + " is an Invalid Date, Try Again");
        }while (true);
        directorDateOfBirth = cal.getTime();
        System.out.print("Enter The director's Gender: ");
        directorGender = input.nextLine();
        System.out.print("Enter The director's Nationality: ");
        directorNationality = input.nextLine();
        System.out.print("Enter The director's Social Media Link: ");
        directorSocialMediaLink = input.nextLine();
        List<String> directorContent = new ArrayList<>();
        directorContent.add(movieTitle);
        return new Director(directorFirstName, directorLastName, directorGender, directorNationality, directorSocialMediaLink, directorDateOfBirth, directorContent);
    }

    public Long GetValidNumber (String ask, int maxLength)
    {
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print(ask);
            String s = input.nextLine();
            boolean check = s.length() <= maxLength;
            for (char i : s.toCharArray())
            {
                if (i < '0' || i > '9')
                {
                    check = false;
                    break;
                }
            }
            if (check)
            {
                return Long.parseLong(s);
            }
            else
                System.out.println("Sorry, " + s + " is an Invalid input, Please try again");
        }while (true);
    }

    public float GetValidRate(String ask){
        Scanner input = new Scanner(System.in);
        do {
            System.out.print(ask);
            String s = input.nextLine();
            boolean check = true;
            for (char i : s.toCharArray())
            {
                if ((i < '0' || i > '9') && i != '.')
                {
                    check = false;
                    break;
                }
            }
            if (check)
            {
                float rate =  Float.parseFloat(s);
                if(rate >= 0 && rate <= 10)
                    return rate;
            }
            System.out.println("Sorry, " + s + " is an Invalid input, Please try again");
        }while(true);
    }

    public CastMember InputActor (String actorFirstName, String actorLastName, String movieTitle)
    {
        String actorGender, actorNationality, actorSocialMediaLink;
        Date actorDateOfBirth;
        Scanner input = new Scanner(System.in);
        Calendar cal;
        do {
            System.out.print("Enter The Actor's Date Of Birth (MM/YYYY): ");
            cal = Calendar.getInstance();
            String[] YYMM;
            try {
                YYMM = input.nextLine().split("/");
                cal.set(Integer.parseInt(YYMM[0]), Integer.parseInt(YYMM[1]), 0);
            }catch (NumberFormatException e){
                System.out.println("Invalid Date, Please Try Again");
                continue;
            }
            if ((YYMM[1].length() == 4 && ((YYMM[1].charAt(0) == '1' && YYMM[1].charAt(1) == '9') || (YYMM[1].charAt(0) == '2' && YYMM[1].charAt(1) == '0'))) && ((YYMM[0].length() == 2 && YYMM[0].charAt(0) == '0') || YYMM[0].length() == 1 || YYMM[0].equals("10") || YYMM[0].equals("11") || YYMM[0].equals("12")))
                break;
            else
                System.out.println("Sorry, " + YYMM[0] + "/" + YYMM[1] + " is an Invalid Date, Try Again");
        }while (true);
        actorDateOfBirth = cal.getTime();
        System.out.print("Enter The Actor's Gender: ");
        actorGender = input.nextLine();
        System.out.print("Enter The Actor's Nationality: ");
        actorNationality = input.nextLine();
        System.out.print("Enter The Actor's Social Media Link: ");
        actorSocialMediaLink = input.nextLine();
        List<String> actorContent = new ArrayList<>();
        actorContent.add(movieTitle);
        return new CastMember(actorFirstName, actorLastName, actorGender, actorNationality, actorSocialMediaLink, actorDateOfBirth, actorContent);
    }
}
