package ru.wts.dto.flex;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FlexProduct {
    @JacksonXmlProperty(localName = "seasonMasterReference")
    String seasonId;
}
