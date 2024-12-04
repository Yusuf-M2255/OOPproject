package App;
import AccountControl.*;
import ContentControl.Episode;
import ContentControl.Movie;
import ContentControl.Series;
import DataBase.DataBase;
import Engines.RecommendationEngine;
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
    }

    public void DisplayMain()
    {
        if (!DataBase.getInstance().adminsData.getDataByString(DataBase.getInstance().CurrentUser.getEmail(), 4).isEmpty())
        {
            System.out.println("                                                                                         Admin Mode");
            System.out.println("                                                                                      Welcome " + DataBase.getInstance().CurrentUser.getUserName());
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
                    System.out.println("Enter The ID Of The Movie Or The Series You Want to Watch Or Enter S To Search For A Movie/Series: ");
                    String c = input.nextLine();
                    boolean check = true;
                    for (char i : c.toCharArray())
                    {
                        if (i < '0' || i > '9')
                        {
                            check = false;
                            break;
                        }
                    }
                    if (check)
                    {
                        Long l = stol(c);
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
            }while (true);

        }
    }
}
