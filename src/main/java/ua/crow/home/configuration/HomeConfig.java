package ua.crow.home.configuration;


import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import ua.crow.home.dto.EkbRequestDto;

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

    @Bean
    public AsyncHttpClientConfig asyncHttpClientConfig(){
        return new AsyncHttpClientConfig.Builder( )
                .setUserAgent( "TeamCity Wall Client" )
                .setAllowPoolingConnections( true )
                .setAllowPoolingSslConnections( true )
                .setMaxConnectionsPerHost( 10 )
                .setConnectTimeout( 60000 )
                .setRequestTimeout( 30000 )
                .build();
    }

    @Bean
    public AsyncHttpClient httpClient(AsyncHttpClientConfig asyncHttpClientConfig){
        return new AsyncHttpClient(asyncHttpClientConfig);
    }

}
