package Engines;
import ContentControl.Movie;
import ContentControl.Content;
import ContentControl.*;

import java.util.ArrayList;
import java.util.List;

public class RecommendationEngine {
    private List<String> favouriteGenres;
    private Content[] content;

    RecommendationEngine(List<String> favouriteGenres, Content[] content) {
        this.favouriteGenres = favouriteGenres;
        this.content = content;
    }

    public List<Movie> getMovieBasedRecommendations() {
        List<Movie> movieBasedRecommendations = new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            if (content[i] instanceof Movie) {
                Movie movie = (Movie) content[i];
                for (int j = 0; j < favouriteGenres.size(); j++) {
                    if (movie.genres.contains(favouriteGenres.get(j))) {
                        movieBasedRecommendations.add(movie);
                        break;
                    }
                }
            }
        }

        return movieBasedRecommendations;
    }

    public List<Series> getSeriesBasedRecommendations() {
        List<Series> seriesBasedRecommendations = new ArrayList<>();
        for (int i = 0; i < content.length; i++) {
            if (content[i] instanceof Series) {
                Series series = (Series) content[i];
                for (int j = 0; j < favouriteGenres.size(); j++) {
                    if (series.genres.contains(favouriteGenres.get(j))) {
                        seriesBasedRecommendations.add(series);
                        break;
                    }
                }
            }
        }

        return seriesBasedRecommendations;
    }
}
