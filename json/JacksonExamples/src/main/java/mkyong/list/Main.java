package mkyong.list;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import mkyong.Staff;

/**
 *
 * @author BikchentaevAA
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException,
            IOException {
        URI uri = Main.class.getResource("/mkyong/staff_list.json").toURI();
        File json = new File(uri);
        List<Staff> staffList = new ObjectMapper().readValue(json,
                new TypeReference<List<Staff>>() {
        });
//        System.out.println(staffList.size());
        for (Staff stf : staffList) {
            System.out.println("name: " + stf.getName()
                    + " position: " + stf.getPosition());
        }
    }
}
