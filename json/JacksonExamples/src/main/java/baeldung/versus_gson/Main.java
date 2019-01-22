package baeldung.versus_gson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BikchentaevAA
 */
public class Main {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        ActorJackson rudyYoungblood = null;
        try {
            rudyYoungblood = new ActorJackson("nm2199632", sdf.parse("21-09-1982"),
                    Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Movie movie = new Movie("tt0472043", "Mel Gibson", Arrays.asList(rudyYoungblood));
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            String jsonResult = mapper.writeValueAsString(movie);
            System.out.println(jsonResult);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // DESERIALISATION
        String jsonInput = "{\"imdbId\":\"tt0472043\",\"actors\":[{\"imdbId\":"
                + "\"nm2199632\",\"dateOfBirth\":\"1982-09-21T12:00:00+01:00\","
                + "\"filmography\":[\"Apocalypto\",\"Beatdown\",\"Wind Walkers\"]}]}";
        try {
            Movie movie2 = mapper.readValue(jsonInput, Movie.class);
            System.out.println(movie2.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
