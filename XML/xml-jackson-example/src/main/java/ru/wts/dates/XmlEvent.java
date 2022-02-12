package ru.wts.dates;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.time.LocalDateTime;

public class XmlEvent {

    @JacksonXmlProperty(localName = "name")
    public String name;

    @JacksonXmlProperty(localName = "eventDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime eventDate;
}
