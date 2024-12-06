package App;
import AccountControl.*;
import ContentControl.*;
import DataBase.DataBase;
import Engines.RecommendationEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class tmp {

    private Long stol(String s)
    {
        return Long.parseLong(s);
    }

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

    private void DisplayMovie(Movie movie)
    {
        System.out.println();
        System.out.println("Name: " + movie.contentTitle);
        System.out.println("Duration: " + movie.getDuration() / 60 + "hours " + movie.getDuration() % 60 + "minutes");
        System.out.println("Language: " + movie.language);
        System.out.println("Publishing Date: " + movie.datePublished);
        System.out.println("Rate: " + movie.Rate_Sum);
        System.out.print("Genres: ");
        for (var genre : movie.genres)
            System.out.print(genre + ", ");
        System.out.println();
        System.out.println("Country: " + movie.country);
        System.out.println("Director: " + movie.director);
        System.out.print("Cast: ");
        for (var cast : movie.cast)
            System.out.print(cast + ", ");
        System.out.println();
    }

    private void DisplayEpisode(Episode episode)
    {
        System.out.println();
        System.out.println("Name: " + episode.getEpisodeTitle());
        System.out.println("Episode Number: " + episode.getEpisodeNumber());
        System.out.println("Duration: " + episode.getDuration() / 60 + "hours " + episode.getDuration() % 60 + "minutes");
        System.out.println("Publishing Date: " + episode.getreleaseDate());
    }

    private void DisplaySeries(Series series)
    {
        System.out.println();
        System.out.println("Name: " + series.contentTitle);
        System.out.println("Number Of Episodes: " + series.getNumberOfEpisodes());
        System.out.println("Language: " + series.language);
        System.out.println("Publishing Date: " + series.datePublished);
        System.out.println("Rate: " + series.Rate_Sum);
        System.out.print("Genres: ");
        for (var genre : series.genres)
            System.out.print(genre + ", ");
        System.out.println();
        System.out.println("Country: " + series.country);
        System.out.println("Director: " + series.director);
        System.out.print("Cast: ");
        for (var cast : series.cast)
            System.out.print(cast + ", ");
        System.out.println();
        System.out.println("Episodes: ");
        for (var episode : DataBase.getInstance().episodesData.getDataByString(series.contentTitle, 0))
        {
            System.out.println("Name: " + episode.getEpisodeTitle() + ", ID: " + episode.getEpisodeNumber());
        }
    }

    public void DisplayMain()
    {
        if (!DataBase.getInstance().adminsData.getDataByString(DataBase.getInstance().CurrentUser.getEmail(), 4).isEmpty())
        {
            Account acc = DataBase.getInstance().CurrentUser;
            Admin admin = (Admin)acc;
            String[] genres = {
                    "Action", "Adventure", "Comedy", "Drama", "Horror",
                    "Romance", "Science Fiction", "Fantasy", "Mystery",
                    "Thriller", "Documentary", "Animation", "Family",
                    "Musical", "Crime", "Historical", "War", "Western"
            };
            String choice;
            Scanner input = new Scanner(System.in);
            System.out.println("                                                                                         Admin Mode");
            System.out.println("                                                                                      Welcome " + DataBase.getInstance().CurrentUser.getUserName());
            System.out.println("To Administrate movies enter (am)");
            System.out.println("To Administrate series enter (as)");
            System.out.println("To Administrate users enter (aa)");
            do
            {
                System.out.print("Choose what you want to do: ");
                choice = input.nextLine();
                choice = choice.toLowerCase();
                if (choice.equals("am") || choice.equals("as") || choice.equals("aa"))
                    break;
                else
                    System.out.println("Invalid input, Please try again");
            }while (true);
            if (choice.equals("am"))
            {
                do
                {
                    System.out.println("To add movie enter (am)");
                    System.out.println("To remove movie enter (rm)");
                    do {
                        System.out.print("Choose what you want to do: ");
                        choice = input.nextLine();
                        choice = choice.toLowerCase();
                        if (choice.equals("am") || choice.equals("rm"))
                            break;
                        else
                            System.out.println("Invalid input, Please try again");
                    }while (true);
                    if (choice.equals("am"))
                    {
                        System.out.print("Enter movie title: ");
                        String title = input.nextLine();
                        title = title.toLowerCase();
                        System.out.print("Enter movie language: ");
                        String language = input.nextLine();
                        language = language.toLowerCase();
                        System.out.print("Enter movie's country: ");
                        String country = input.nextLine();
                        country = country.toLowerCase();
                        System.out.print("Enter movie's director: ");
                        String director = input.nextLine();
                        director = director.toLowerCase();
                        Long budgetLong;
                        do
                        {
                            System.out.print("Enter movie's budget: ");
                            String budget = input.nextLine();
                            boolean check = true;
                            for (char i : budget.toCharArray())
                            {
                                if (i < '0' || i > '9')
                                {
                                    check = false;
                                    break;
                                }
                            }
                            if (check)
                            {
                                budgetLong = Long.parseLong(budget);
                                break;
                            }
                            else
                                System.out.println("Invalid input, Please try again");
                        }while (true);
                        int budgetInt = budgetLong.intValue();
                        Long revenueLong;
                        do
                        {
                            System.out.print("Enter movie's revenue: ");
                            String revenue = input.nextLine();
                            boolean check = true;
                            for (char i : revenue.toCharArray())
                            {
                                if (i < '0' || i > '9')
                                {
                                    check = false;
                                    break;
                                }
                            }
                            if (check)
                            {
                                revenueLong = Long.parseLong(revenue);
                                break;
                            }
                            else
                                System.out.println("Invalid input, Please try again");
                        }while (true);
                        int revenueInt = revenueLong.intValue();
                        Long durationLong;
                        do
                        {
                            System.out.print("Enter movie's duration in minutes: ");
                            String duration = input.nextLine();
                            boolean check = true;
                            for (char i : duration.toCharArray())
                            {
                                if (i < '0' || i > '9')
                                {
                                    check = false;
                                    break;
                                }
                            }
                            if (check)
                            {
                                durationLong = Long.parseLong(duration);
                                break;
                            }
                            else
                                System.out.println("Invalid input, Please try again");
                        }while (true);
                        int durationInt = durationLong.intValue();
                        int i = 0;
                        List<String> moviesGenres = new ArrayList<>();
                        String j;
                        for(String genre : genres)
                            System.out.println((i++)+ "- " + genre);
                        System.out.println("Enter -1 when you want stop choosing your Favorite Genres");
                        do {
                            j = input.nextLine();
                            if((j.length() == 1 && j.charAt(0) - '0' >= 0 && j.charAt(0) - '0' <= 9) || (j.length() == 2 && j.charAt(0) - '0' == 1 && j.charAt(1) - '0' >= 0 && j.charAt(1) - '0' <= 7))
                            {
                                if (j.length() == 1)
                                    moviesGenres.add(genres[j.charAt(0) - '0']);
                                else
                                    moviesGenres.add(genres[10 + (j.charAt(1) - '0')]);
                            }
                            else if (!j.equals("-1"))
                                System.out.println("Sorry, " + j + " is an Invalid Input, Try Again");
                        }while(!j.equals("-1"));
                        List<String> castMembers = new ArrayList<>();
                        System.out.println("Enter The Cast Member Name and Enter -1 when you are done");
                        do {
                            j = input.nextLine();
                            if (!j.equals("-1"))
                                castMembers.add(j.toLowerCase());
                        }while(!j.equals("-1"));
                        Calendar cal;
                        do
                        {
                            System.out.print("Enter movie's publication year: ");
                            cal = Calendar.getInstance();
                            try {
                                String YY = input.nextLine();
                                cal.set(Integer.parseInt(YY), 6, 0);
                                break;
                            }catch (NumberFormatException e){
                                System.out.println("Invalid Date, Please Try Again");
                            }
                        }while (true);
                        Movie movie = new Movie(title,language,country,director,budgetInt,revenueInt,durationInt,moviesGenres,castMembers,cal.getTime());
                        admin.addMovie(movie);
                        DataBase.getInstance().Save();
                    }
                    else
                    {

                    }
                }while (true);
            }
            else if (choice.equals("as"))
            {

            }
            else
            {

            }
        }
        else
        {
            System.out.println("                                                                                      Welcome " + DataBase.getInstance().CurrentUser.getUserName());
            do
            {
                Account a = DataBase.getInstance().CurrentUser;
                User user = (User)a;
                RecommendationEngine RecommendatoinEngineMovies = new RecommendationEngine(user.getFavoriteGenres(), DataBase.getInstance().moviesData.getData().toArray(new Movie[0]));
                RecommendationEngine RecommendatoinEngineSeries = new RecommendationEngine(user.getFavoriteGenres(), DataBase.getInstance().seriesData.getData().toArray(new Series[0]));
                Scanner input = new Scanner(System.in);
                String choice;
                System.out.println("Recommended Movies: ");
                for (var movie : RecommendatoinEngineMovies.getMovieBasedRecommendations())
                {
                    System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                }
                System.out.println("Recommended Series: ");
                for (var series : RecommendatoinEngineSeries.getSeriesBasedRecommendations())
                {
                    System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                }
                do
                {
                    System.out.print("Enter W if you want to watch from the shown Movies/series, If you want to search for another movie/series enter S:");
                    choice = input.nextLine();
                    if (choice.equals("w") || choice.equals("W"))
                    {
                        do
                        {
                            System.out.print("Enter The ID Of The Movie Or The Series You Want to Watch: ");
                            choice = input.nextLine();
                            boolean check = true;
                            for (char i : choice.toCharArray())
                            {
                                if (i < '0' || i > '9')
                                {
                                    check = false;
                                    break;
                                }
                            }
                            if (check)
                            {
                                Long l = stol(choice);
                                if (DataBase.getInstance().moviesData.getDataById(l) != null)
                                {
                                    DisplayMovie(DataBase.getInstance().moviesData.getDataById(l));
                                    break;
                                }
                                else if (DataBase.getInstance().seriesData.getDataById(l) != null)
                                {
                                    DisplaySeries(DataBase.getInstance().seriesData.getDataById(l));
                                    break;
                                }
                                else
                                    System.out.println("Invalid input, Please try again");
                            }
                            else
                                System.out.println("Invalid input, Please try again");
                        }while (true);
                    }
                    else if (choice.equals("s") || choice.equals("S"))
                    {
                        System.out.println("Enter The Name Of The Movie Or The Series: ");
                        choice = input.nextLine();
                        if (!DataBase.getInstance().moviesData.getDataThatContains(choice.toLowerCase(), 0).isEmpty())
                        {
                            for (Movie movie : DataBase.getInstance().moviesData.getDataThatContains(choice.toLowerCase(), 0))
                                System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                        }
                        else if (!DataBase.getInstance().seriesData.getDataThatContains(choice.toLowerCase(), 0).isEmpty())
                        {
                            for (Series series : DataBase.getInstance().seriesData.getDataThatContains(choice.toLowerCase(), 0))
                                System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                        }
                        else if (!DataBase.getInstance().castMemberData.getDataThatContains(choice, 0).isEmpty())
                        {
                            if (!DataBase.getInstance().castMemberData.getDataThatContains(choice, 0).getFirst().Contents.isEmpty())
                            {
                                for (String content : DataBase.getInstance().castMemberData.getDataThatContains(choice, 0).getFirst().Contents)
                                {
                                    if (!DataBase.getInstance().moviesData.getDataThatContains(content.toLowerCase(), 0).isEmpty())
                                    {
                                        for (Movie movie : DataBase.getInstance().moviesData.getDataThatContains(content.toLowerCase(), 0))
                                            System.out.println("Name: " + movie.contentTitle + ", ID: " + movie.contentID);
                                    }
                                    else if (!DataBase.getInstance().seriesData.getDataThatContains(content.toLowerCase(), 0).isEmpty())
                                    {
                                        for (Series series : DataBase.getInstance().seriesData.getDataThatContains(content.toLowerCase(), 0))
                                            System.out.println("Name: " + series.contentTitle + ", ID: " + series.contentID);
                                    }
                                }
                            }
                        }
                        else
                            System.out.println("No Data Found");
                    }
                    else
                        System.out.println("Invalid input, Please try again");
                }while(true);
            }while (true);

        }
    }
}
