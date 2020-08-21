package baeldung.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author BikchentaevAA
 */
public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {
        String sPath = Object.class.getResource("/baeldung/items.json").toExternalForm();
        Path path = Paths.get(new URI(sPath));
        File json = path.toFile();
//        File json = new File("src/main/resources/baeldung/items.json");
        System.out.println("json file exists: " + json.exists());
        UserData itemWithOwner = new ObjectMapper().readValue(json, UserData.class);

        System.out.println("item name is " + itemWithOwner.info);

        // System.out.println(System.getProperty("user.dir"));//D:\GIT\Эксперименты\JacksonExamples
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(UserData.class, new AccountDeserializer());
        mapper.registerModule(module);
        File json2 = new File("src/main/resources/baeldung/s_items.json");
        UserData readValue = mapper.readValue(json2, UserData.class);
        System.out.println("Item owner is: "+readValue.owner.name);
    }

}
