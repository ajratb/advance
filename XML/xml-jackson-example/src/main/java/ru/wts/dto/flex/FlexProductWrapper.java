package ru.wts.dto.flex;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class FlexProductWrapper {

    @JacksonXmlProperty(isAttribute = true, localName = "NAME")
    private String name;

    @JacksonXmlElementWrapper(useWrapping = false)
            @JacksonXmlProperty(localName = "INSTANCE")
    List<FlexProduct> products;
}
