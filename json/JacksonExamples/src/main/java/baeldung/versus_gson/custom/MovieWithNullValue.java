package baeldung.versus_gson.custom;

import baeldung.versus_gson.SuperStar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public class MovieWithNullValue {
     private String imdbId;
     
    @JsonIgnore
    private String director;
     
    private List<SuperStar> actors;

    public MovieWithNullValue(String imdbId, String director, List<SuperStar> actors) {
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
}
