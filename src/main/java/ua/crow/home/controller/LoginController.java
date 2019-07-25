package ua.crow.home.controller;


import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;
import org.asynchttpclient.AsyncHttpClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.crow.home.dto.EkbRequestDto;
import ua.crow.home.dto.I;
import ua.crow.home.dto.R;
import ua.crow.home.service.ExcelPOIHelperService;
import ua.crow.home.service.MarshallerWrapperService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class LoginController {

    @Autowired
    private AsyncHttpClient asyncHttpClient;

    @GetMapping("/")
    public ResponseEntity sayHello() throws JAXBException, ExecutionException, InterruptedException, IOException {
//        EkbRequestDto ekbRequestDto = new EkbRequestDto(new R("hh","kh",new I("m,s")));
        Response response = asyncHttpClient.prepareGet("http://localhost:8080/download").execute().get();
        System.out.println(asyncHttpClient.isClosed());
        return ResponseEntity.ok(response.getResponseBody());
    }

    @GetMapping(value = "/download")
    public ResponseEntity excelCustomersReport(){
        return ResponseEntity
                .ok()
                .body("Success!!");
    }

}
