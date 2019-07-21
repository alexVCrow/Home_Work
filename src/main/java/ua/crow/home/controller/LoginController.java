package ua.crow.home.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.crow.home.dto.EkbRequestDto;
import ua.crow.home.dto.I;
import ua.crow.home.dto.R;
import ua.crow.home.service.MarshallerWrapperService;

import javax.xml.bind.JAXBException;

@RestController
public class LoginController {

    @Autowired
    private MarshallerWrapperService marshallerWrapperService;

    @GetMapping("/")
    public ResponseEntity sayHello() throws JAXBException {
        EkbRequestDto ekbRequestDto = new EkbRequestDto(new R("hh","kh",new I("m,s")));
        System.out.println(marshallerWrapperService.marshallXml(ekbRequestDto));
        return ResponseEntity.ok(marshallerWrapperService.marshallXml(ekbRequestDto));
    }

}
