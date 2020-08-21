package baeldung.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BikchentaevAA
 */
public class AccountDeserializer extends StdDeserializer<UserData> {

    public AccountDeserializer() {
        this(null);
    }

    public AccountDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public UserData deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        JsonNode node = parser.getCodec().readTree(parser);
        int id = (Integer) ((IntNode) node.get("id")).numberValue();
        String itemName = node.get("itemName").asText();
        int userId = (Integer) ((IntNode) node.get("createdBy")).numberValue();

        return new UserData(id, itemName, getUserById(userId));
    }

    private User getUserById(int id) {
        List<User> users = new ArrayList<>();
        users.add(new User(2, "BigBoss"));

        return users.stream().filter(u -> u.id == id).findFirst()
                .orElse(new User(id, "NoName"));
    }
}
