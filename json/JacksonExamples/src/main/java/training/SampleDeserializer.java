package training;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SampleDeserializer extends StdDeserializer<Sample> {

    public SampleDeserializer() {
        this(null);
    }

    public SampleDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Sample deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {

        JsonNode node = parser.getCodec().readTree(parser);
        String[] accessGroups = getAsArray(node, "accessGroups");
        String[] toGroups = getAsArray(node, "toGroups");
        String[] exceptGroups = getAsArray(node, "exceptGroups");
        return new Sample(accessGroups, toGroups, exceptGroups);
    }

    private String[] getAsArray(JsonNode node, String key) {
        Object value = node.get(key);
        if (value instanceof ArrayNode) {
            Set<String> result= new HashSet<>();
            for(JsonNode jn: (ArrayNode)value){
                result.add(jn.textValue());
            }
            return result.toArray(new String[result.size()]);
        }
        else if (!(value instanceof TextNode)) return null;
        else return new String[]{((JsonNode) value).textValue()};
    }
}
