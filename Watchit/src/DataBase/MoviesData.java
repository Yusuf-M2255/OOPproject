package DataBase;

import ContentControl.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoviesData implements Data<Movie>,ReadableClass{
    private List<Movie> movies =null ;
    public MoviesData(){
        movies = new ArrayList<>();
        //LoadData();
    }

    /**
     * get Data of movies from files
     * its throws messages when files not founded or any other error
     */
    public void LoadData(){
        File moviesFile = new File("/movies.txt");
        try {
            Scanner scanner = new Scanner(moviesFile);
        }catch (FileNotFoundException e){
            System.out.println("File movies.txt is not found");
        }
        catch (Exception e){
            System.out.println("error while opening");
        }
    }


    /**
     * save Data of movies in files
     * its throws messages when files not founded or any other error
     */
    public void SaveData(){
        File moviesFile = new File("./movies.txt");
        try {
            FileOutputStream fos = new FileOutputStream(moviesFile);
        }catch (FileNotFoundException e){
            System.out.println("File movies.txt is not found");
        }
        catch (Exception e){
            System.out.println("Save movies.txt failed");
        }
    }

    public void removeData(long Id){
        while(getDataById(Id)!=null) {
            movies.remove(getDataById(Id));
        }
    }
    /**
     * function that used to get the Movie by its name
     * @param name name of Movie you want to get it
     * @return Movie
     */
    public Movie getDataByName(String name){
        for (Movie movie : movies) {
            //if(movie.getName().equals(name))
            return movie;
        }
        return null;
    }
    public Movie getDataById(Long id){
        return null;
    }
    /**
     * function that used to get the Movies that contains searchText
     * @param searchText is the substring of movies you search
     * @return Movie[]
     */
    public Movie[] getDataThatContains(String searchText){
        List<Movie> Searched = new ArrayList<Movie>();
        for (Movie movie : movies) {
            //if(movie.getName().contains(searchText))
            Searched.add(movie);
        }
        return Searched.toArray(new Movie[0]);
    }

     /**
     * function that return all movies in application
     * @return Movie[]
     */
    public Movie[] getData() {
        return movies.toArray(new Movie[0]);
    }

    /**
     * function that return all movies in application as List
     * @return List<Movie>
     */
    public List<Movie> getDataAsList() {
        return movies;
    }

    /**
     * function that add new movie to application
     * @param movie the movie that will be added
     */
    public void addData(Movie movie){
        movies.add(movie);
    }

    /**
     * function that remove movie from application
     * @param movie name of movie that will be removed
     */
    public void removeData(String movie){
        movies.remove(getDataByName(movie));
    }

}
