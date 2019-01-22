package mkyong;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Jackson 2 – Convert Java Object to / from JSON.
 * https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
 *
 * @author BikchentaevAA
 */
public class Main {

    public static void main(String[] args) throws JsonGenerationException,
            JsonMappingException, IOException, URISyntaxException {
        ObjectMapper mapper = new ObjectMapper();

        Staff staff = new Main().createDummyObject();
        System.out.println("After getting dummy obj, staff name: "+ staff.getName());

        URL url = Object.class.getResource("/mkyong/staff.json");
//        System.out.println(url);

        Path path = Paths.get(url.toURI());
        File json = path.toFile();
//        System.out.println(json.getAbsolutePath());
//        System.out.println("is file exist " + json.exists());
        mapper.writeValue(json, staff);

        // Convert object to JSON string
        String jsonInString = mapper.writeValueAsString(staff);
        System.out.println("");
        System.out.println("== writeValueAsString ==");
        System.out.println("Write staff to string. Result is:");
        System.out.println(jsonInString);
        System.out.println("");
        
        // Convert object to JSON string and pretty print
        jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
        System.out.println("== write value with default pretty printer as string ==");
        System.out.println("Write staff to string in pretty way. Result is:");
        System.out.println(jsonInString);
        System.out.println("");
        
        staff = mapper.readValue(json, Staff.class);
        System.out.println("== Staff after deserialization ==");
        System.out.println("staff name is "+staff.getName());
        System.out.println("");
        
        // Convert JSON string to Object
        jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
        Staff staff1 = mapper.readValue(jsonInString, Staff.class);
        System.out.println("== Staff after deserialization of string == ");
        System.out.println("name is "+staff1.getName());
        System.out.println("");
//
        //Pretty print
        String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
        System.out.println("== Serialization to string with pretty printer");
        System.out.println(prettyStaff1);
    }

    private Staff createDummyObject() {

        Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(33);
        staff.setPosition("Developer");
        staff.setSalary(new BigDecimal("7500"));

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");

        staff.setSkills(skills);

        return staff;

    }
}
