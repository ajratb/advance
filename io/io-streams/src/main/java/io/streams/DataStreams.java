package io.streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
//import java.io.StringReader;
//import java.io.StringWriter;

/**
 *
 * @author BikchentaevAA
 */
public class DataStreams {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException, IOException {
//        StringReader strReader = new StringReader("hello");
//        StringWriter strWriter = new StringWriter();

//        final URI uri = App.class.getResource("/files/123").toURI();
        final File LOCAL_FILE = new File("c:/temp/dest.txt");

        if (!LOCAL_FILE.exists()) {
            if (!LOCAL_FILE.createNewFile()) {
                return;
            }
        }
        try (
                DataInputStream din = new DataInputStream(new FileInputStream(LOCAL_FILE));
                DataOutputStream out = new DataOutputStream(new FileOutputStream(LOCAL_FILE));) {
            out.writeUTF("1. dsafadsfasd");
            out.writeUTF("2 . HEllO!");
            while (true) {
                String request = din.readUTF();
                System.out.println(request);
            }
        } catch (EOFException e) {
            System.out.println("END OF INPUT DATA STREAM");
        }
    }
}
