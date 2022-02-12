package ru.wts;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import ru.wts.dto.PersonWithAddressesWrapper;
import ru.wts.dto.flex.InfoEngineCollection;
import ru.wts.dto.PersonWithAddresses;
import ru.wts.dto.SimpleBean;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class JacksonXmlTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void whenJavaSerializedToXmlStr_thenCorrect() throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        String xml = xmlMapper.writeValueAsString(new SimpleBean());
        assertNotNull(xml);
    }

    @Test
    public void whenJavaSerializedToXmlFile_thenCorrect() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        SimpleBean bean = new SimpleBean();
        xmlMapper.writeValue(new File("simple_bean.xml"), bean);
        File file = new File("simple_bean.xml");
        assertNotNull(file);
    }

    @Test
    public void whenJavaGotFromXmlStr_thenCorrect() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        SimpleBean value
                = xmlMapper.readValue("<SimpleBean><x>1</x><y>2</y></SimpleBean>", SimpleBean.class);
        assertTrue(value.getX() == 1 && value.getY() == 2);
    }

    @Test
    public void whenJavaGotFromXmlFile_thenCorrect() throws IOException, URISyntaxException {
        URL url = JacksonXmlTest.class.getResource("/simple_bean_resource.xml");
        File file = new File(url.toURI());
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        SimpleBean value = xmlMapper.readValue(xml, SimpleBean.class);
        assertTrue(value.getX() == 5 && value.getY() == 4);
    }

    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }

    @Test
    public void deserializeList() throws IOException, URISyntaxException {
        URL url = JacksonXmlTest.class.getResource("/person_with_addresses.xml");
        File file = new File(url.toURI());
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        PersonWithAddresses value = xmlMapper.readValue(xml, PersonWithAddresses.class);
        assertEquals("City1", value.getAddress().get(0).getCity());
        assertEquals("City2", value.getAddress().get(1).getCity());
    }

    @Test
    public void deserializeWithListWrapper() throws IOException, URISyntaxException {
        URL url = JacksonXmlTest.class.getResource("/person_with_addresses_wrapper.xml");
        File file = new File(url.toURI());
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        PersonWithAddressesWrapper value = xmlMapper.readValue(xml, PersonWithAddressesWrapper.class);
        assertEquals("City1", value.getAddresses().get(0).getCity());
        assertEquals("City2", value.getAddresses().get(1).getCity());
    }

    @Test
    public void deserializeEmptyList() throws IOException, URISyntaxException {
        URL url = JacksonXmlTest.class.getResource("/person_with_no_addresses.xml");
        File file = new File(url.toURI());
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        PersonWithAddresses value = xmlMapper.readValue(xml, PersonWithAddresses.class);
        assertEquals("City1", value.getAddress().get(0).getCity());
        assertEquals("City2", value.getAddress().get(1).getCity());
    }

    @Test
    public void deserializeWithEmptyListWrapper() throws IOException, URISyntaxException {
        URL url = JacksonXmlTest.class.getResource("/person_with_no_addresses_wrapper.xml");
        File file = new File(url.toURI());
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));
        PersonWithAddressesWrapper value = xmlMapper.readValue(xml, PersonWithAddressesWrapper.class);
        assertEquals("City1", value.getAddresses().get(0).getCity());
        assertEquals("City2", value.getAddresses().get(1).getCity());
    }

    @Test
    public void serializeWithAttributes() throws URISyntaxException, IOException{
        URL url = JacksonXmlTest.class.getResource("/1stTRY.xml");
        File file = new File(url.toURI());
        XmlMapper xmlMapper = new XmlMapper();
        String xml =  inputStreamToString(new FileInputStream(file));
        InfoEngineCollection value = xmlMapper.readValue(xml, InfoEngineCollection.class);
        assertNotNull(value);
    }
}
