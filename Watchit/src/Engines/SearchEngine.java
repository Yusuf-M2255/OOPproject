package Engines;

import ContentControl.Movie;
import ContentControl.Series;
import DataBase.DataBase;

import java.util.Scanner;

public class SearchEngine {
    public void Search()
    {
        String choice;
        Scanner input = new Scanner(System.in);
        do
        {
            System.out.print("To Search For a movie enter m, To Search For a Series enter s: ");
            choice = input.nextLine();
            choice = choice.toLowerCase();
            if (choice.equals("m") || choice.equals("s"))
                break;
            else
                System.out.println("Sorry, " + choice + " is not an Invalid input, Please try again.");
        }while (true);
        if (choice.equals("m"))
        {
            do
            {
                System.out.print("To search by name enter n, To search by actor enter a, To search by director enter d: ");
                choice = input.nextLine();
                choice = choice.toLowerCase();
                if (choice.equals("n") || choice.equals("a") || choice.equals("d"))
                    break;
                else
                    System.out.println("Sorry, " + choice + " is not an Invalid input, Please try again.");
            }while (true);
            if (choice.equals("n"))
            {
                System.out.print("Enter the movie title: ");
                choice = input.nextLine();
                if (!DataBase.getInstance().moviesData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
                {
                    for (Movie movie : DataBase.getInstance().moviesData.getDataThatContains(choice.toLowerCase(), 2))
                        System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                }
                else
                    System.out.println("No Data Found");
            }
            else if (choice.equals("a"))
            {
                System.out.print("Enter the actor's name: ");
                choice = input.nextLine();
                if (!DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
                {
                    if (!DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents.isEmpty())
                    {
                        for (String content : DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents)
                        {
                            if (!DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Movie movie : DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2))
                                    System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                            }
                        }
                    }
                    else
                        System.out.println("No Data Found");
                }
                else
                    System.out.println("No Data Found");
            }
            else
            {
                System.out.print("Enter the director's name: ");
                choice = input.nextLine();
                if (!DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
                {
                    if (!DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents.isEmpty())
                    {
                        for (String content : DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents)
                        {
                            if (!DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Movie movie : DataBase.getInstance().moviesData.getDataByString(content.toLowerCase(), 2))
                                    System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                            }
                        }
                    }
                    else
                        System.out.println("No Data Found");
                }
                else
                    System.out.println("No Data Found");
            }
        }
        else
        {
            do
            {
                System.out.print("To search by name enter n, To search by actor enter a, To search by director enter d: ");
                choice = input.nextLine();
                choice = choice.toLowerCase();
                if (choice.equals("n") || choice.equals("a") || choice.equals("d"))
                    break;
                else
                    System.out.println("Sorry, " + choice + " is not an Invalid input, Please try again.");
            }while (true);
            if (choice.equals("n"))
            {
                System.out.print("Enter the series title: ");
                choice = input.nextLine();
                if (!DataBase.getInstance().seriesData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
                {
                    for (Series series : DataBase.getInstance().seriesData.getDataThatContains(choice.toLowerCase(), 2))
                        System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                }
                else
                    System.out.println("No Data Found");
            }
            else if (choice.equals("a"))
            {
                System.out.print("Enter the actor's name: ");
                choice = input.nextLine();
                if (!DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
                {
                    if (!DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents.isEmpty())
                    {
                        for (String content : DataBase.getInstance().castMemberData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents)
                        {
                            if (!DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Series series : DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2))
                                    System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                            }
                        }
                    }
                    else
                        System.out.println("No Data Found");
                }
                else
                    System.out.println("No Data Found");
            }
            else
            {
                System.out.print("Enter the director's name: ");
                choice = input.nextLine();
                if (!DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).isEmpty())
                {
                    if (!DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents.isEmpty())
                    {
                        for (String content : DataBase.getInstance().DirectorsData.getDataThatContains(choice.toLowerCase(), 2).getFirst().Contents)
                        {
                            if (!DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2).isEmpty())
                            {
                                for (Series series : DataBase.getInstance().seriesData.getDataByString(content.toLowerCase(), 2))
                                    System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                            }
                        }
                    }
                    else
                        System.out.println("No Data Found");
                }
                else
                    System.out.println("No Data Found");
            }
        }
    }
}
