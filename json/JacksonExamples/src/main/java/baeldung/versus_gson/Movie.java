package baeldung.versus_gson;

import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public class Movie {

    private String imdbId;
    private String director;
    private List<SuperStar> actors;

    /**
     * For deserialization!.
     */
    public Movie() {
    }
    
    public Movie(String imdbId, String director, List<SuperStar> actors) {
        this.imdbId = imdbId;
        this.director = director;
        this.actors = actors;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<SuperStar> getActors() {
        return actors;
    }

    public void setActors(List<SuperStar> actors) {
        this.actors = actors;
    }
    

    /**
     * For deserialization.
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Movie [imdbId=" + imdbId + ", director=" + director
                + ", actors=" + actors + "]";
    }
}
