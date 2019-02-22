package ru.waytosky;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Ayrat
 */
public class OldUtilPackageApi {

    //Смотри джавадок по SimpleDateFormat - полно примеров паттернов для формата!
    DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
    Calendar cal;
    Date date;

    public void showNow() {
        Date date = new Date();
        System.out.println("Without formating date - now is: " + date);
        System.out.println("Formating date - now is: " + sdf.format(date));
        cal = new GregorianCalendar();
//        cal.setTime(date);
        Calendar cal2 = Calendar.getInstance();//тоже Gregorian

//        System.out.println("GregorianCalendar is: " + cal);
        System.out.println("GregorianCalendar getTime is: " + cal.getTime());
        System.out.println("GregorianCalendar getTime is: " + cal2.getTime());
    }

    public void showOf(int year, int month, int dayOfMonth, int hour,
            int minute, int sec) {
        cal = new GregorianCalendar(year, month - 1, dayOfMonth, hour, minute, sec);
        System.out.println("Calendar \"Of\" getTime: " + cal.getTime());
    }

    public Calendar dateToCalendar(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        System.out.println("GregorianCalendar is: " + cal);
        System.out.println("GregorianCalendar getTime is: " + cal.getTime());
        return cal;
    }

    public XMLGregorianCalendar dateToXmlCalendar(Date date) throws DatatypeConfigurationException {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar result = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        System.out.println("GregorianCalendar is: " + cal);
        System.out.println("GregorianCalendar getTime is: " + cal.getTime());
        return result;
    }

    public Date xmlCalendarToDate(XMLGregorianCalendar cal) {
        return cal.toGregorianCalendar().getTime();
    }

    public static void main(String[] args) {
        OldUtilPackageApi utilPkgAPI = new OldUtilPackageApi();
        System.out.println("\n=========showNow========\n");
        utilPkgAPI.showNow();
        System.out.println("\n=========showOf========\n");
        utilPkgAPI.showOf(1980, 11, 28, 12, 5, 59);
    }
}
