package ua.crow.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

@Component
public class MarshallerWrapperServiceImpl implements MarshallerWrapperService {

    @Autowired
    private Jaxb2Marshaller marshaller;

    @Override
    public <T> String marshallXml(final T obj){
        StringWriter sw = new StringWriter();
        Result result = new StreamResult(sw);
        marshaller.marshal(obj, result);
        return sw.toString();
    }

    @Override
    public <T> T unmarshallXml(String response) {
        StringBuffer xmlStr = new StringBuffer( response );
        return (T) marshaller.unmarshal(new StreamSource( new StringReader( xmlStr.toString() ) ));
    }

}
