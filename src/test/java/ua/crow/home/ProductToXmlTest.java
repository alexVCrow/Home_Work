package ua.crow.home;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ua.crow.home.configuration.HomeConfig;
import ua.crow.home.dto.*;
import ua.crow.home.enums.EkbRequest;
import ua.crow.home.service.MarshallerWrapperService;
import ua.crow.home.service.MarshallerWrapperServiceImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProductToXmlTest {

    @Autowired
    private MarshallerWrapperService marshallerWrapperService;

    private static final String SID = "testSid";
    private static final String TYPE = "INF_NEW";
    private static final String OKPO = "1234567890";

    @Test
    public void testObjectToXml() {
        EkbRequestDto ekbRequestDtoOkpo = new EkbRequestDto(new R(SID,TYPE,new I(OKPO)));
        EkbRequestDto ekbRequestDtoDt =  new EkbRequestDto(new R(SID,TYPE,new I("2012-12-12","Фамилия", " Bvz", "dsf")));
        String respNot = "<?xml version='1.0' encoding='UTF-8'?><doc><r key='0'><INF_NEW/></r></doc>";
        String resp = "<?xml version='1.0' encoding='UTF-8'?><doc><r key='0'><INF_NEW Id='21863603' OKPO='3130610834' St='A'></INF_NEW></r></doc>";
        String respList = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><doc><r  key=\"0\"><INF_NEW Id=\"1027916811\" OKPO=\"1234567890\" St=\"O\"></INF_NEW><INF_NEW Id=\"1003992774\" OKPO=\"1234567890\" St=\"O\"></INF_NEW><INF_NEW Id=\"1050149075\" OKPO=\"1234567890\" St=\"O\"></INF_NEW><INF_NEW Id=\"1050149076\" OKPO=\"1234567890\" St=\"A\"></INF_NEW><INF_NEW Id=\"1050149077\" OKPO=\"1234567890\" St=\"O\"></INF_NEW><INF_NEW Id=\"1050114842\" OKPO=\"1234567890\" St=\"O\"></INF_NEW></r></doc>";
//        StringWriter sw = new StringWriter();
//        JAXBContext jaxbContext = JAXBContext.newInstance(EkbRequestDto.class);
//        Marshaller marshaller = jaxbContext.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
//        marshaller.marshal(ekbRequestDto, sw);
        System.out.println(marshallerWrapperService.marshallXml(ekbRequestDtoOkpo));
        System.out.println(marshallerWrapperService.marshallXml(ekbRequestDtoDt));
        EkbRequestDto ff = marshallerWrapperService.unmarshallXml(resp);
        EkbRequestDto ffff = marshallerWrapperService.unmarshallXml(respList);
        EkbRequestDto fg= marshallerWrapperService.unmarshallXml(respList);
        System.out.println(ff.toString());
        System.out.println(ffff.toString());
        System.out.println(fg.getR().getInfs());

        LetterClient lc = new LetterClient("1234567890","Фамилия","Имя","Отчество", new Date());
        EkbCreateRequest ekbCreateRequest = new EkbCreateRequest(lc, EkbRequest.INF_NEW);
        ekbCreateRequest.getCreate();
    }
}
