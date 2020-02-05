/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waytosky.study.xml;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 *
 * @author ayrat
 */
public class SAX_example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
//            File inputFile = new File("xml/input.txt");
            File inputFile = new File("xml/деловед.xml");
            String content = "";

            try (Reader r = new FileReader(inputFile);
                    Writer wr = new StringWriter()) {
                int count = 0;
                int read = 0;
                while ((read = r.read()) != -1) {
                    content += (char) read;
                }
            }

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
//            UserHandler userhandler = new UserHandler();
            TikaXhtmlHandler handler = new TikaXhtmlHandler();
            try (InputStream is = new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8))) {
                saxParser.parse(is, handler);
                for (String[] s : handler.getResult()) {
                    System.out.println(s[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
