package baeldung.versus_gson.custom;

import baeldung.versus_gson.SuperStar;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

/**
 *
 * @author BikchentaevAA
 */
public class SuperStarSerializer
        extends StdSerializer<SuperStar> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public SuperStarSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize(SuperStar actor, JsonGenerator jsonGenerator,
            SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("imdbId", actor.getImdbId());
        jsonGenerator.writeObjectField("dateOfBirth",
                actor.getDateOfBirth() != null
                ? sdf.format(actor.getDateOfBirth()) : null);

        jsonGenerator.writeNumberField("N° Film: ",
                actor.getFilmography() != null ? actor.getFilmography().size() : null);
        jsonGenerator.writeStringField("filmography", actor.getFilmography()
                .stream().collect(Collectors.joining("-")));

        jsonGenerator.writeEndObject();
    }
}
