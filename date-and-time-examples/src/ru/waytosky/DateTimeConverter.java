package ru.waytosky;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
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
public class DateTimeConverter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Date date = new Date();
        LocalDate locDate = LocalDate.now();
        System.out.println("Local Date now: " + locDate);
        LocalDate firstDateOfThisYear  =  LocalDate.of(
                LocalDate.now().getYear(), Month.JANUARY, 1
        );
        System.out.println("The date of the beginning this year: " + firstDateOfThisYear);
        LocalDateTime locDateTime = LocalDateTime.now();
        Calendar cal;
        XMLGregorianCalendar xCal;
        
        locDateTime=LocalDateTime.now();

        try {
             xCal=localDateToXml(locDate, false);
            System.out.println("xmlCalendar.getTime after converting:"+xCal);
            xCal=localDateToXml(locDate, true);
            System.out.println("xmlCalendar.getTime after converting:"+xCal);
        } catch (DatatypeConfigurationException ex) {
           
        }
//        
//        date=new Date();
//        cal = new GregorianCalendar();
//        cal.setTime(date);
//        try {
//            xCal=dateToXmlCalendar(date);
//            System.out.println("xmlCalendar.getTime after converting:"+xCal);
//        } catch (DatatypeConfigurationException ex) {
//            Logger.getLogger(DateTimeConverter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//         try {
//            XMLGregorianCalendar calFromLocalDate = localDateTimeToXmlCalendar(LocalDateTime.now());
//            System.out.println(calFromLocalDate);
//            XMLGregorianCalendar calFromDate = dateToXmlCalendar(new Date());
//            System.out.println(calFromDate);
//            System.out.println(xmlCalendarToString(calFromDate));
//            System.out.println(xmlCalendarToString(calFromLocalDate));
//        } catch (DatatypeConfigurationException ex) {
//             System.out.println("DatatypeConfigurationException");
//        }
    }

    public static XMLGregorianCalendar localDateToXml(LocalDate localDate, boolean toDayEnd)
            throws DatatypeConfigurationException {
        if (localDate == null) {
            return null;
        }
        Calendar outCalendar = new GregorianCalendar(localDate.getYear(),
                localDate.getMonthValue() - 1, localDate.getDayOfMonth());
        if (toDayEnd) {
            outCalendar.add(Calendar.DAY_OF_WEEK, 1);
            outCalendar.add(Calendar.SECOND, -1);
        }
        return DatatypeFactory.newInstance()
                .newXMLGregorianCalendar((GregorianCalendar) outCalendar);
    }
    
    public static LocalDateTime dateTolocalDateTime(Date date) {
        LocalDateTime ldt = LocalDateTime.ofInstant(date
                .toInstant(), ZoneId.systemDefault());
        return ldt;
    }

    public static LocalDate dateToLocalDate(Date date) {
        LocalDate result = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return result;
    }

    public static Date localDateTimeToDate(LocalDateTime ldt) {
        Date out = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        return out;
    }

    public static XMLGregorianCalendar localDateTimeToXmlCalendar(LocalDateTime ldt)
            throws DatatypeConfigurationException {
        Date date = localDateTimeToDate(ldt);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        XMLGregorianCalendar result = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        return result;
    }

    

    public static LocalDateTime xmlToLocalDateTime(XMLGregorianCalendar cal) {
        Date date = cal.toGregorianCalendar().getTime();
        return dateTolocalDateTime(date);
    }

    public static String xmlCalendarToString(XMLGregorianCalendar cal) {
        String format = "dd.MM.yyyy";
        DateFormat df = new SimpleDateFormat(format);
        return df.format(cal.toGregorianCalendar().getTime());
    }

    public static Date getDateFromString(String dateInString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = formatter.parse(dateInString);
        return date;
    }

}
