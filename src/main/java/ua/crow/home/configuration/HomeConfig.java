package ua.crow.home.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ua.crow.home.dto.EkbRequestDto;
import ua.crow.home.dto.EkbResponseDto;
import ua.crow.home.dto.RRsp;

import javax.xml.bind.Marshaller;
import java.util.HashMap;

@Configuration
public class HomeConfig {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(new Class[]{
                EkbRequestDto.class
        });
        marshaller.setMarshallerProperties(new HashMap<String, Object>() {{
            put(Marshaller.JAXB_ENCODING, "UTF-8");
        }});
        System.out.println(marshaller);
        return marshaller;
    }

}
