package training;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import mkyong.Staff;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(Sample.class, new SampleDeserializer());
            mapper.registerModule(module);
            //JSON file to Java object
            URL url = Object.class.getResource("/training/samples3.json");
            Sample[] objs = mapper.readValue(new File(url.toURI()), Sample[].class);
            System.out.println("Found " + objs.length + " objects");

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
