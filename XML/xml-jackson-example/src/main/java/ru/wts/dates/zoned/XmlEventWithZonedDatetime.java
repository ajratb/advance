package ru.wts.dates.zoned;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.ZonedDateTime;

public class XmlEventWithZonedDatetime {

    @JacksonXmlProperty(localName = "name")
    public String name;

    @JacksonXmlProperty(localName = "eventDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss z")
    public ZonedDateTime eventDate;
}
