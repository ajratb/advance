package ru.wts;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;

public class StaxParserExample {

    public static void main(String[] args) throws URISyntaxException, IOException, XMLStreamException {
        File source = new File(StaxParserExample.class.getResource("/serious_stuff.xml").toURI());
        XMLInputFactory xFactory = XMLInputFactory.newInstance();
        XMLStreamReader xReader = xFactory.createXMLStreamReader(new FileInputStream(source));
        boolean elementFound = false;
        while (xReader.hasNext()) {
            int event = xReader.next();

            if (event == XMLStreamConstants.START_ELEMENT) {
                String element = xReader.getLocalName();
//                System.out.println(element);
                if (element.equals("seasonMasterReference"))
                    elementFound = true;
//                    System.out.println(xReader.getText());
            }
            if (event == XMLStreamConstants.CHARACTERS) {
                if (elementFound) {
                    System.out.println(xReader.getText());
                    elementFound = false;
                }
            }
        }
    }
}
