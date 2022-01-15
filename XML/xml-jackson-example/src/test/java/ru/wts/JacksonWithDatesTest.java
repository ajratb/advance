package ru.wts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import ru.wts.dates.XmlEvent;
import ru.wts.dates.XmlEvent3;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

@Slf4j
public class JacksonWithDatesTest {

    ObjectMapper xmlMapper = new XmlMapper();


    @Test// can't execute it! why? It requires com.fasterxml.jackson.datatype:jackson-datatype-jsr310, but I added it!
    public void deserializeDateWithJsr310Lib() throws JsonProcessingException {
        //''2022-01-14T18:14:35.436393800
        //2021-12-12 00:00:00 GMT
        // GMT+08:00
        //
        String xml ="<XmlEvent><name>party</name><eventDate>2021-12-31 00:00:03 Asia/Krasnoyarsk</eventDate></XmlEvent>";
        XmlEvent3 event = xmlMapper.readValue(xml, XmlEvent3.class);
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        log.info("\n\n{}\n\n", event.name);
    }

    @Test
    public void deserializeDate() throws IOException {


        log.info("\n\n {} \n\n", LocalDateTime.now());
        DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
        log.info(LocalDateTime.now().format(dtFormatter));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss.SSS");
        LocalDateTime ldt = LocalDateTime.parse("20-12-2014 02:30:00.454", formatter);
        log.info("\n\n{}\n\n", ldt);
        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
        String xml ="<XmlEvent><name>party</name><eventDate>20-12-2014 02:30:00</eventDate></XmlEvent>";
//'2021-12-12 00:00:00 GMT'
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        XmlMapper mapper = new XmlMapper();
//        mapper.setDateFormat(df);

        XmlEvent event = mapper.readerFor(XmlEvent.class).readValue(xml);
//        assertEquals("20-12-2014 02:30:00", df.format(event.eventDate));
    }

    @Test
    public void datetimeToGmtAndBack() {

        LocalDateTime now = LocalDateTime.now();// 2022-01-15T22:50:34.840973400 - In Krasnoyarsk
        ZonedDateTime d  = now.atZone(ZoneOffset.UTC);
        log.info("{}",d);//2022-01-15T22:50:34.840973400Z - the same result
        assertEquals(d.toLocalDateTime(), now);

        log.info("{}",now);
        ZonedDateTime zonedNow = now.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedKrskNow = now.atZone(ZoneId.of("Asia/Krasnoyarsk"));
        ZonedDateTime gmtNow = zonedNow.withZoneSameInstant(ZoneOffset.UTC);
//        assertEquals(gmtNow.plusHours(7), zonedKrskNow); // test failed in such way
        assertEquals(gmtNow.plusHours(7).toLocalDateTime(), zonedKrskNow.toLocalDateTime());
    }
}
