/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waytosky.study.xml;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author ayrat
 */
public class TikaXhtmlHandler extends DefaultHandler {

    List<String[]> result = new ArrayList();

    public List<String[]> getResult() {
        return result;
    }

//    public void addToList(){
//        list.add(new String[2]);
//        list.add(new String[]{"","sdfsd",""});
//    }
    boolean insideBody = false;
    int pageNum = 0;

    @Override
    public void startElement(String uri,
            String localName, String qName, Attributes attributes)
            throws SAXException {
        if (qName.equalsIgnoreCase("body")) {
            insideBody = true;
            System.out.println(insideBody);
        } else if (qName.equalsIgnoreCase("div")) {
            String classAttribute = attributes.getValue("class");
            if(classAttribute!=null&&classAttribute.equals("page")) 
                pageNum++;
        }
    }

    @Override
    public void endElement(String uri,
            String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("body")) {
            insideBody = false;
        }
    }

    @Override
    public void characters(char ch[],
            int start, int length) throws SAXException {
        if (insideBody) {
            String s=new String(ch, start, length);
            String[] array = new String[]{s};
            result.add(array);
        }
//        if (bFirstName) {
//            System.out.println("First Name: "
//                    + new String(ch, start, length));
//            bFirstName = false;
//        } else if (bLastName) {
//            System.out.println("Last Name: "
//                    + new String(ch, start, length));
//            bLastName = false;
//        } else if (bNickName) {
//            System.out.println("Nick Name: "
//                    + new String(ch, start, length));
//            bNickName = false;
//        } else if (bMarks) {
//            System.out.println("Marks: "
//                    + new String(ch, start, length));
//            bMarks = false;
//        }
    }
}
