package App;
import AccountControl.*;
import Cast.CastMember;
import Cast.Director;
import ContentControl.*;
import DataBase.DataBase;
import Engines.RecommendationEngine;
import Engines.SearchEngine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class tmp {

    private Long stol(String s)
    {
        return Long.parseLong(s);
    }

    public boolean LoginDisplay()
    {
        InputChecker inputChecker = new InputChecker();
        String[] validInput;
        Scanner input = new Scanner(System.in);
        String choice;
        boolean check;
        do {
            System.out.println("To Login enter (l)");
            System.out.println("To Register enter (r)");
            System.out.println("To close the program enter (c)");
            validInput = new String[]{"l", "r", "c"};
            choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
            if (choice.equals("l"))
                check = DataBase.getInstance().Login();
            else if (choice.equals("r"))
                check = DataBase.getInstance().Register();
            else
                return false;
            if (check)
                return true;
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
        System.out.println("Last Aired Date: " + series.getLastAireDate());
        System.out.println("On Going: " + series.isOnGoing());
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
        InputChecker inputChecker = new InputChecker();
        SearchEngine searchEngine = new SearchEngine();
        String[] validInput;
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
            System.out.println("                                                                                    Welcome " + DataBase.getInstance().CurrentUser.getUserName());
            do
            {
                System.out.println("To Administrate movies enter (am)");
                System.out.println("To Administrate series enter (as)");
                System.out.println("To Administrate episodes enter (ae)");
                System.out.println("To Administrate users enter (au)");
                System.out.println("To Logout (lo)");
                validInput = new String[]{"am", "as", "ae", "au", "lo"};
                choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                if (choice.equals("am"))
                {
                    do
                    {
                        System.out.println("To add movie enter (am)");
                        System.out.println("To remove movie enter (rm)");
                        System.out.println("To Go Back (ba)");
                        validInput = new String[]{"am", "rm", "ba"};
                        choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                        if (choice.equals("am"))
                        {
                            System.out.print("Enter movie title: ");
                            String title = input.nextLine();
                            System.out.print("Enter movie language: ");
                            String language = input.nextLine();
                            System.out.print("Enter movie's country: ");
                            String country = input.nextLine();
                            System.out.println("Movie's director: ");
                            String directorFirstName, directorLastName;
                            System.out.print("Enter The Director's First Name: ");
                            directorFirstName = input.nextLine();
                            System.out.print("Enter The Director's Last Name: ");
                            directorLastName = input.nextLine();
                            String directorNameCapital = (directorFirstName + " " + directorLastName);
                            directorFirstName = directorFirstName.toLowerCase();
                            directorLastName = directorLastName.toLowerCase();
                            String directorName = (directorFirstName + " " + directorLastName);
                            if (!DataBase.getInstance().DirectorsData.getDataByString(directorName, 2).isEmpty())
                            {
                                DataBase.getInstance().DirectorsData.getDataByString(directorName, 2).getFirst().joinContent(title);
                            }
                            else
                            {
                                Director director = inputChecker.InputDirector(directorFirstName, directorLastName, title);
                                DataBase.getInstance().DirectorsData.addData(director);
                            }
                            Long budgetLong = inputChecker.GetValidNumber("Enter the movies budget: ", 9);
                            int budgetInt = budgetLong.intValue();
                            Long revenueLong = inputChecker.GetValidNumber("Enter the movies revenue: ", 9);
                            int revenueInt = revenueLong.intValue();
                            Long durationLong = inputChecker.GetValidNumber("Enter the movies duration: ", 3);
                            int durationInt = durationLong.intValue();
                            int i = 0;
                            List<String> moviesGenres = new ArrayList<>();
                            String j;
                            for(String genre : genres)
                                System.out.println((i++)+ "- " + genre);
                            System.out.println("Enter -1 when you want stop choosing the movies Genres");
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
                            System.out.println("Add an actor: ");
                            do {
                                String actorFirstName, actorLastName;
                                System.out.print("Enter The Actor's First Name: ");
                                actorFirstName = input.nextLine();
                                System.out.print("Enter The Actor's Last Name: ");
                                actorLastName = input.nextLine();
                                castMembers.add(actorFirstName + " " + actorLastName);
                                actorFirstName = actorFirstName.toLowerCase();
                                actorLastName = actorLastName.toLowerCase();
                                String actorName = (actorFirstName + " " + actorLastName);
                                if (!DataBase.getInstance().castMemberData.getDataByString(actorName, 2).isEmpty())
                                {
                                    DataBase.getInstance().castMemberData.getDataByString(actorName, 2).getFirst().joinContent(title);
                                }
                                else
                                {
                                    CastMember actor = inputChecker.InputActor(actorFirstName, actorLastName, title);
                                    DataBase.getInstance().castMemberData.addData(actor);
                                }
                                validInput = new String[]{"y", "n"};
                                choice = inputChecker.GetValidChoice("Do you want to add another actor ? (y/n): ", validInput);
                                if (choice.equals("n"))
                                    break;
                            }while (true);
                            Calendar cal;
                            do
                            {
                                System.out.print("Enter movie's publication year: ");
                                cal = Calendar.getInstance();
                                String YY;
                                try {
                                    YY = input.nextLine();
                                    cal.set(Integer.parseInt(YY), 6, 0);
                                }catch (NumberFormatException e){
                                    System.out.println("Invalid Date, Please Try Again");
                                    continue;
                                }
                                if (YY.length() == 4 && ((YY.charAt(0) == '1' && YY.charAt(1) == '9') || (YY.charAt(0) == '2' && YY.charAt(1) == '0')))
                                    break;
                                else
                                    System.out.println("Sorry, " + YY + " is an Invalid Date, Try Again");
                            }while (true);
                            Movie movie = new Movie(title,language,country,directorNameCapital,budgetInt,revenueInt,durationInt,moviesGenres,castMembers,cal.getTime());
                            admin.addMovie(movie);
                            DataBase.getInstance().Save();
                            System.out.println("Movie Added");
                        }
                        else if (choice.equals("rm"))
                        {
                            do
                            {
                                boolean search = searchEngine.SearchMovie();
                                if (!search)
                                {
                                    System.out.println("No Data Found");
                                    System.out.println("To try again enter (t)");
                                    System.out.println("To go back enter (ba)");
                                    validInput = new String[]{"t", "ba"};
                                    choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
                                    if (choice.equals("t"))
                                        continue;
                                    else
                                        break;
                                }
                                System.out.println("To delete one of the shown movies enter (d)");
                                System.out.println("To Search again enter (s)");
                                System.out.println("To Go Back enter (ba)");
                                validInput = new String[]{"d", "s", "ba"};
                                choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                if (choice.equals("d")  || choice.equals("ba"))
                                    break;
                            }while (true);
                            if (choice.equals("d"))
                            {
                                Long movieID = inputChecker.GetValidNumber("Enter The ID Of The Movie You Want To Delete: ", 10);
                                if (DataBase.getInstance().moviesData.getDataById(movieID) != null)
                                {
                                    admin.deleteMovie(DataBase.getInstance().moviesData.getDataById(movieID));
                                    DataBase.getInstance().Save();
                                    System.out.println("Movie Deleted");
                                }
                                else
                                    System.out.println("No Movie Found");
                            }
                        }
                        else if (choice.equals("ba"))
                            break;
                    }while (true);
                }
                else if (choice.equals("as"))
                {
                    do
                    {
                        System.out.println("To add series enter (as)");
                        System.out.println("To remove series enter (rs)");
                        System.out.println("To Go Back (ba)");
                        validInput = new String[]{"as", "rs", "ba"};
                        choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                        if (choice.equals("as"))
                        {
                            System.out.print("Enter series title: ");
                            String title = input.nextLine();
                            System.out.print("Enter series language: ");
                            String language = input.nextLine();
                            System.out.print("Enter series's country: ");
                            String country = input.nextLine();
                            validInput = new String[]{"y", "n"};
                            choice = inputChecker.GetValidChoice("Is it on going? (y/n): ", validInput);
                            int onGoing;
                            if (choice.equals("y"))
                                onGoing = 1;
                            else
                                onGoing = 0;
                            System.out.println("series's director: ");
                            String directorFirstName, directorLastName;
                            System.out.print("Enter The Director's First Name: ");
                            directorFirstName = input.nextLine();
                            System.out.print("Enter The Director's Last Name: ");
                            directorLastName = input.nextLine();
                            String directorNameCapital = (directorFirstName + " " + directorLastName);
                            directorFirstName = directorFirstName.toLowerCase();
                            directorLastName = directorLastName.toLowerCase();
                            String directorName = (directorFirstName + " " + directorLastName);
                            if (!DataBase.getInstance().DirectorsData.getDataByString(directorName, 2).isEmpty())
                            {
                                DataBase.getInstance().DirectorsData.getDataByString(directorName, 2).getFirst().joinContent(title);
                            }
                            else
                            {
                                Director director = inputChecker.InputDirector(directorFirstName, directorLastName, title);
                                DataBase.getInstance().DirectorsData.addData(director);
                            }
                            Long budgetLong = inputChecker.GetValidNumber("Enter the series budget: ", 9);
                            int budgetInt = budgetLong.intValue();
                            Long revenueLong = inputChecker.GetValidNumber("Enter the series revenue: ", 9);
                            int revenueInt = revenueLong.intValue();
                            Long numberOfEpisodesLong = inputChecker.GetValidNumber("Enter the series number of episodes: ", 4);
                            int numberOfEpisodesInt = numberOfEpisodesLong.intValue();
                            int i = 0;
                            List<String> seriesGenres = new ArrayList<>();
                            String j;
                            for(String genre : genres)
                                System.out.println((i++)+ "- " + genre);
                            System.out.println("Enter -1 when you want stop choosing the series Genres");
                            do {
                                j = input.nextLine();
                                if((j.length() == 1 && j.charAt(0) - '0' >= 0 && j.charAt(0) - '0' <= 9) || (j.length() == 2 && j.charAt(0) - '0' == 1 && j.charAt(1) - '0' >= 0 && j.charAt(1) - '0' <= 7))
                                {
                                    if (j.length() == 1)
                                        seriesGenres.add(genres[j.charAt(0) - '0']);
                                    else
                                        seriesGenres.add(genres[10 + (j.charAt(1) - '0')]);
                                }
                                else if (!j.equals("-1"))
                                    System.out.println("Sorry, " + j + " is an Invalid Input, Try Again");
                            }while(!j.equals("-1"));
                            List<String> castMembers = new ArrayList<>();
                            System.out.println("Add an actor: ");
                            do {
                                String actorFirstName, actorLastName;
                                System.out.print("Enter The Actor's First Name: ");
                                actorFirstName = input.nextLine();
                                System.out.print("Enter The Actor's Last Name: ");
                                actorLastName = input.nextLine();
                                castMembers.add(actorFirstName + " " + actorLastName);
                                actorFirstName = actorFirstName.toLowerCase();
                                actorLastName = actorLastName.toLowerCase();
                                String actorName = (actorFirstName + " " + actorLastName);
                                if (!DataBase.getInstance().castMemberData.getDataByString(actorName, 2).isEmpty())
                                {
                                    DataBase.getInstance().castMemberData.getDataByString(actorName, 2).getFirst().joinContent(title);
                                }
                                else
                                {
                                    CastMember actor = inputChecker.InputActor(actorFirstName, actorLastName, title);
                                    DataBase.getInstance().castMemberData.addData(actor);
                                }
                                validInput = new String[]{"y", "n"};
                                choice = inputChecker.GetValidChoice("Do you want to add another actor ? (y/n): ", validInput);
                                if (choice.equals("n"))
                                    break;
                            }while (true);
                            Calendar date, air;
                            do
                            {
                                System.out.print("Enter series's publication date (MM/YYYY): ");
                                date = Calendar.getInstance();
                                String[] YYMM;
                                try {
                                    YYMM = input.nextLine().split("/");
                                    date.set(Integer.parseInt(YYMM[0]), Integer.parseInt(YYMM[1]), 0);
                                }catch (NumberFormatException e){
                                    System.out.println("Invalid Date, Please Try Again");
                                    continue;
                                }
                                if ((YYMM[1].length() == 4 && ((YYMM[1].charAt(0) == '1' && YYMM[1].charAt(1) == '9') || (YYMM[1].charAt(0) == '2' && YYMM[1].charAt(1) == '0'))) && ((YYMM[0].length() == 2 && YYMM[0].charAt(0) == '0') || YYMM[0].length() == 1 || YYMM[0].equals("10") || YYMM[0].equals("11") || YYMM[0].equals("12")))
                                    break;
                                else
                                    System.out.println("Sorry, " + YYMM[0] + "/" + YYMM[1] + " is an Invalid Date, Try Again");
                            }while (true);
                            do
                            {
                                System.out.print("Enter series's last aired date (MM/YYYY): ");
                                air = Calendar.getInstance();
                                String[] YYMM;
                                try {
                                    YYMM = input.nextLine().split("/");
                                    air.set(Integer.parseInt(YYMM[0]), Integer.parseInt(YYMM[1]), 0);
                                }catch (NumberFormatException e){
                                    System.out.println("Invalid Date, Please Try Again");
                                    continue;
                                }
                                if ((YYMM[1].length() == 4 && ((YYMM[1].charAt(0) == '1' && YYMM[1].charAt(1) == '9') || (YYMM[1].charAt(0) == '2' && YYMM[1].charAt(1) == '0'))) && ((YYMM[0].length() == 2 && YYMM[0].charAt(0) == '0') || YYMM[0].length() == 1 || YYMM[0].equals("10") || YYMM[0].equals("11") || YYMM[0].equals("12")))
                                    break;
                                else
                                    System.out.println("Sorry, " + YYMM[0] + "/" + YYMM[1] + " is an Invalid Date, Try Again");
                            }while (true);
                            Series series = new Series(title,language,country,directorNameCapital,budgetInt,revenueInt,numberOfEpisodesInt,onGoing,seriesGenres,castMembers,date.getTime(),air.getTime());
                            admin.addSeries(series);
                            DataBase.getInstance().Save();
                            System.out.println("Series Added");
                        }
                        else if (choice.equals("rs"))
                        {
                            do
                            {
                                boolean search = searchEngine.SearchSeries();
                                if (!search)
                                {
                                    System.out.println("No Data Found");
                                    System.out.println("To try again enter (t)");
                                    System.out.println("To go back enter (ba)");
                                    validInput = new String[]{"t", "ba"};
                                    choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
                                    if (choice.equals("t"))
                                        continue;
                                    else
                                        break;
                                }
                                System.out.println("To delete one of the shown series enter (d)");
                                System.out.println("To Search again enter (s)");
                                System.out.println("To Go Back enter (ba)");
                                validInput = new String[]{"d", "s", "ba"};
                                choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                if (choice.equals("d")  || choice.equals("ba"))
                                    break;
                            }while (true);
                            if (choice.equals("d"))
                            {
                                Long seriesID = inputChecker.GetValidNumber("Enter The ID Of The Series You Want To Delete: ", 10);
                                if (DataBase.getInstance().seriesData.getDataById(seriesID) != null)
                                {
                                    admin.deleteSeries(DataBase.getInstance().seriesData.getDataById(seriesID));
                                    DataBase.getInstance().Save();
                                    System.out.println("Series deleted");
                                }
                                else
                                    System.out.println("No Series Found");
                            }
                        }
                        else if (choice.equals("ba"))
                            break;
                    }while (true);
                }
                else if (choice.equals("ae"))
                {
                    do
                    {
                        System.out.println("To add episode enter (ae)");
                        System.out.println("To remove episode enter (re)");
                        System.out.println("To Go Back enter (ba)");
                        validInput = new String[]{"ae", "re", "ba"};
                        choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                        if (choice.equals("ae"))
                        {
                            String sTitle;
                            do {

                                System.out.print("Enter the series title: ");
                                sTitle = input.nextLine();
                                sTitle = sTitle.toLowerCase();
                                if (DataBase.getInstance().seriesData.getDataByString(sTitle, 2).isEmpty())
                                    System.out.println("Series Does Not Exist");
                                else
                                    break;
                            }while (true);
                            do
                            {
                                System.out.print("Enter episode title: ");
                                String eTitle = input.nextLine();
                                Long eNumber = inputChecker.GetValidNumber("Enter the episode number: ", 4);
                                int episodeNumber = eNumber.intValue();
                                Long eDuration = inputChecker.GetValidNumber("Enter the episode duration: ", 3);
                                int episodeDuration = eDuration.intValue();
                                Calendar date;
                                do
                                {
                                    System.out.print("Enter episode release date (MM/YYYY): ");
                                    date = Calendar.getInstance();
                                    String[] YYMM;
                                    try {
                                        YYMM = input.nextLine().split("/");
                                        date.set(Integer.parseInt(YYMM[0]), Integer.parseInt(YYMM[1]), 0);
                                    }catch (NumberFormatException e){
                                        System.out.println("Invalid Date, Please Try Again");
                                        continue;
                                    }
                                    if ((YYMM[1].length() == 4 && ((YYMM[1].charAt(0) == '1' && YYMM[1].charAt(1) == '9') || (YYMM[1].charAt(0) == '2' && YYMM[1].charAt(1) == '0'))) && ((YYMM[0].length() == 2 && YYMM[0].charAt(0) == '0') || YYMM[0].length() == 1 || YYMM[0].equals("10") || YYMM[0].equals("11") || YYMM[0].equals("12")))
                                        break;
                                    else
                                        System.out.println("Sorry, " + YYMM[0] + "/" + YYMM[1] + " is an Invalid Date, Try Again");
                                }while (true);
                                Episode episode = new Episode(sTitle, eTitle, episodeNumber, episodeDuration, date.getTime());
                                admin.addEpisode(episode);
                                DataBase.getInstance().Save();
                                System.out.println("Episode Added");
                                validInput = new String[]{"y", "n"};
                                choice = inputChecker.GetValidChoice("Do you want to add another episode ? (y/n): ", validInput);
                                if (choice.equals("n"))
                                    break;
                            }while (true);
                        }
                        else if (choice.equals("re"))
                        {
                            do
                            {
                                System.out.println("Search for the series that contain the episode you want to delete");
                                boolean search = searchEngine.SearchSeries();
                                if (!search)
                                {
                                    System.out.println("No Data Found");
                                    System.out.println("To try again enter (t)");
                                    System.out.println("To go back enter (ba)");
                                    validInput = new String[]{"t", "ba"};
                                    choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
                                    if (choice.equals("t"))
                                        continue;
                                    else
                                        break;
                                }
                                System.out.println("To delete an episode from one of the shown series enter (d)");
                                System.out.println("To Search again enter (s)");
                                System.out.println("To Go Back (ba)");
                                validInput = new String[]{"d", "s", "ba"};
                                choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                if (choice.equals("d")  || choice.equals("ba"))
                                    break;
                            }while (true);
                            if (choice.equals("d"))
                            {
                                Long seriesID = inputChecker.GetValidNumber("Enter the id of the series you want to delete from: ", 10);
                                DisplaySeries(DataBase.getInstance().seriesData.getDataById(seriesID));
                                Long episodeID = inputChecker.GetValidNumber("Enter The ID Of The Episode You Want To Delete: ", 10);
                                if (DataBase.getInstance().episodesData.getDataById(episodeID) != null)
                                {
                                    admin.deleteEpisode(DataBase.getInstance().episodesData.getDataById(episodeID));
                                    DataBase.getInstance().Save();
                                    System.out.println("Episode deleted");
                                }
                                else
                                    System.out.println("Episode Not Found");
                            }
                        }
                        else if (choice.equals("ba"))
                            break;
                    }while (true);
                }
                else if (choice.equals("au"))
                {
                    do
                    {
                        System.out.println("To display users enter (du)");
                        System.out.println("To remove user enter (ru)");
                        System.out.println("To Go Back (ba)");
                        validInput = new String[]{"du", "ru", "ba"};
                        choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                        if (choice.equals("du"))
                        {
                            User user = new User();
                            user.DisplayHeadLine();
                            for (User u : DataBase.getInstance().usersData.getData())
                                u.DisplayLine();
                        }
                        else  if (choice.equals("ru"))
                        {
                            Long id = inputChecker.GetValidNumber("Enter the id of the user you want to remove: ", 10);
                            if (DataBase.getInstance().usersData.getDataById(id) != null)
                            {
                                DataBase.getInstance().usersData.removeData(DataBase.getInstance().usersData.getDataById(id));
                                DataBase.getInstance().Save();
                                System.out.println("User Removed");
                            }
                            else
                                System.out.println("No User Found");
                        }
                        else
                            break;
                    } while (true);
                }
                else
                    break;
            }while (true);
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
                System.out.println("To watch one of the shown movies/series enter (w)");
                System.out.println("To search for another movie/series enter (s)");
                System.out.println("To logout enter (lo)");
                validInput = new String[]{"w", "s", "lo"};
                choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
                if (choice.equals("w"))
                {
                    do
                    {
                        Long id = inputChecker.GetValidNumber("Enter The ID Of The Movie Or The Series You Want to Watch: ", 10);
                        if (DataBase.getInstance().moviesData.getDataById(id) != null)
                        {
                            DisplayMovie(DataBase.getInstance().moviesData.getDataById(id));
                            do
                            {
                                System.out.println("To watch the movie enter (w)");
                                System.out.println("To go back enter (ba)");
                                validInput = new String[]{"w", "ba"};
                                choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                if (choice.equals("w"))
                                {

                                }
                                else
                                    break;
                            }while (true);
                            break;
                        }
                        else if (DataBase.getInstance().seriesData.getDataById(id) != null)
                        {
                            DisplaySeries(DataBase.getInstance().seriesData.getDataById(id));
                            do {
                                System.out.println("To watch an episode enter (w)");
                                System.out.println("To go back enter (ba)");
                                validInput = new String[]{"w", "ba"};
                                choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                if (choice.equals("w")) {

                                } else
                                    break;
                            }while (true);
                            break;
                        }
                        else
                        {
                            System.out.println("No movies nor series found");
                            System.out.println("To try again enter (t)");
                            System.out.println("To go back enter (ba)");
                            validInput = new String[]{"t", "ba"};
                            choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
                            if (choice.equals("ba"))
                                break;
                        }
                    }while (true);
                }
                else if (choice.equals("s"))
                {
                    do
                    {
                        boolean search = searchEngine.Search();
                        if (!search)
                        {
                            System.out.println("No Data Found");
                            System.out.println("To try again enter (t)");
                            System.out.println("To go back enter (ba)");
                            validInput = new String[]{"t", "ba"};
                            choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
                            if (choice.equals("t"))
                                continue;
                            else
                                break;
                        }
                        System.out.println("To watch one of the shown movies/series enter (w)");
                        System.out.println("To search again movie/series enter (s)");
                        System.out.println("To go back enter (ba)");
                        validInput = new String[]{"w", "s", "ba"};
                        choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                        if (choice.equals("w"))
                        {
                            do
                            {
                                Long id = inputChecker.GetValidNumber("Enter The ID Of The Movie Or The Series You Want to Watch: ", 10);
                                if (DataBase.getInstance().moviesData.getDataById(id) != null)
                                {
                                    DisplayMovie(DataBase.getInstance().moviesData.getDataById(id));
                                    do
                                    {
                                        System.out.println("To watch the movie enter (w)");
                                        System.out.println("To go back enter (ba)");
                                        validInput = new String[]{"w", "ba"};
                                        choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                        if (choice.equals("w")) {
                                            // rate movie
                                            validInput = new String[]{"y", "n"};
                                            choice = inputChecker.GetValidChoice("Do you want to rate this movie? (y/n): ", validInput);
                                            if(choice.equals("y")) {
                                                float rate = inputChecker.GetValidRate("How do you rate this movie (0->10): ");
                                                DataBase.getInstance().moviesData.getDataById(id).AddRate(user.getId(0), rate);
                                            }
                                        }
                                        else
                                            break;
                                    }while (true);
                                    break;
                                }
                                else if (DataBase.getInstance().seriesData.getDataById(id) != null)
                                {
                                    DisplaySeries(DataBase.getInstance().seriesData.getDataById(id));
                                    do {
                                        System.out.println("To watch an episode enter (w)");
                                        System.out.println("To go back enter (ba)");
                                        validInput = new String[]{"w", "ba"};
                                        choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                        if (choice.equals("w")){
                                            // Choose episode
                                            do {
                                                Long episodeId = inputChecker.GetValidNumber("Enter The ID Of The Episode You Want to Watch: ", 10);
                                                DisplayEpisode(DataBase.getInstance().episodesData.getDataById(episodeId));
                                                System.out.println("To watch this episode enter (w)");
                                                System.out.println("To go back enter (ba)");
                                                validInput = new String[]{"w", "ba"};
                                                choice = inputChecker.GetValidChoice("Chose what you want to do: ", validInput);
                                                if(choice.equals("w")){
                                                    // rate episode
                                                    validInput = new String[]{"y", "n"};
                                                    choice = inputChecker.GetValidChoice("Do you want to rate this series? (y/n): ", validInput);
                                                    if(choice.equals("y")) {
                                                        float rate = inputChecker.GetValidRate("How do you rate this series (0->10): ");
                                                        DataBase.getInstance().seriesData.getDataById(id).AddRate(user.getId(0), rate);
                                                    }
                                                }
                                                else
                                                    break;
                                            }while(true);
                                        }
                                        else
                                            break;
                                    }while (true);
                                    break;
                                }
                                else
                                {
                                    System.out.println("No movies nor series found");
                                    System.out.println("To try again enter (t)");
                                    System.out.println("To go back enter (ba)");
                                    validInput = new String[]{"t", "ba"};
                                    choice = inputChecker.GetValidChoice("Choose what you want to do: ", validInput);
                                    if (choice.equals("ba"))
                                        break;
                                }
                            }while (true);
                        }
                        else if (choice.equals("ba"))
                            break;
                    }while (true);
                }
                else
                    break;
            }while (true);
        }
    }
}
