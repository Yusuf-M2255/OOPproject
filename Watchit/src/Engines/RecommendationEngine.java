package src.Engines;
import ContentControl.Movie;
import src.AccountControl.*;
import src.ContentControl.*;

public class RecommendationEngine {
    private User user;
    private Movie[] movies;

    RecommendationEngine(User user, ContentControl.Movie[] movies) {
        this.user = user;
        this.movies = movies;
    }

    
}
