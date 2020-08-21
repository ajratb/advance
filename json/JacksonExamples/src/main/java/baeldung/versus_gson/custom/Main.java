package baeldung.versus_gson.custom;

import baeldung.versus_gson.SuperStar;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Custom Serialization.
 *
 * @author BikchentaevAA
 */
public class Main {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        SuperStar rudyYoungblood = null;
        try {
            rudyYoungblood = new SuperStar(
                    "nm2199632",
                    sdf.parse("21-09-1982"),
                    Arrays.asList("Apocalypto", "Beatdown", "Wind Walkers"));
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        MovieWithNullValue movieWithNullValue
                = new MovieWithNullValue(null, "Mel Gibson", Arrays.asList(rudyYoungblood));

        SimpleModule module = new SimpleModule();
        module.addSerializer(new SuperStarSerializer(SuperStar.class));
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonResult = mapper.registerModule(module)
                    .writer(new DefaultPrettyPrinter())
                    .writeValueAsString(movieWithNullValue);
            System.out.println("json result of custom serialization: ");
            System.out.println(jsonResult);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
