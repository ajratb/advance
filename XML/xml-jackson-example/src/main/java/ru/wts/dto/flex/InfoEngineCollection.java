package ru.wts.dto.flex;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(namespace = "wc:http://www.ptc.com/infoengine/1.0", localName = "COLLECTION")
public class InfoEngineCollection {

//    @JacksonXmlProperty(localName = "com.lcs.wc.product.LCSProduct")
//    FlexProductWrapper product;

    @JacksonXmlElementWrapper(localName = "com.lcs.wc.product.LCSProduct")
    @JacksonXmlProperty(localName = "INSTANCE")
    List<FlexProduct> products;
}
