package src.Engines;
import ContentControl.Movie;
import ContentControl.Content;
import src.AccountControl.*;
import src.ContentControl.*;

public class RecommendationEngine {
    private User user;
    private Content[] content;

    RecommendationEngine(User user, Content[] content) {
        this.user = user;
        this.content = content;
    }

    public Content[] getContentBasedRecommendations() {
        return content;
    }

    public Content[] getTrendingRecommendations() {
        return content;
    }
}
