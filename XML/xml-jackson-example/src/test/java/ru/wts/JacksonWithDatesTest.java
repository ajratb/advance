package ru.wts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import ru.wts.dates.JsonEvent;
import ru.wts.dates.XmlEventWithCustomSerDeser;
import ru.wts.dates.zoned.XmlEventWithZonedDatetime;

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
    ObjectMapper mapper = new ObjectMapper();


    @Test
    public void deserializeDate() throws IOException {

        String json = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        mapper.setDateFormat(df);

        JsonEvent event = mapper.readerFor(JsonEvent.class).readValue(json);
        assertEquals("20-12-2014 02:30:00", dtf.format(event.eventDate));
    }

    @Test
    public void deserializeDateWithJsr310Lib() throws JsonProcessingException {
        //''2022-01-14T18:14:35.436393800
        //2021-12-12 00:00:00 GMT
        // GMT+08:00
        //
        String xml ="<XmlEvent><name>party</name><eventDate>2021-12-31 00:00:03 Asia/Krasnoyarsk</eventDate></XmlEvent>";
//        String xml ="<XmlEvent><name>party</name><eventDate>2021-12-31 00:00:03 UTC</eventDate></XmlEvent>";
        xmlMapper.registerModule(new JavaTimeModule());
        XmlEventWithZonedDatetime event = xmlMapper.readValue(xml, XmlEventWithZonedDatetime.class);
        log.info("\n\n{}\n\n", event.name);
    }

    @Test
    public void deserializeXmlDate() throws IOException {

        String xml ="<XmlEvent><name>party</name><eventDate>20-12-2014 02:30:00</eventDate></XmlEvent>";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        XmlMapper mapper = new XmlMapper();
//        mapper.setDateFormat(dtf);
        XmlEventWithCustomSerDeser event = mapper.readerFor(XmlEventWithCustomSerDeser.class).readValue(xml);
        assertEquals("20-12-2014 02:30:00", dtf.format(event.eventDate));
    }
}
