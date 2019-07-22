package ua.crow.home.controller;


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

import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class LoginController {

    @Autowired
    private MarshallerWrapperService marshallerWrapperService;
    @Autowired
    private ExcelPOIHelperService excelPOIHelperService;

    @GetMapping("/")
    public ResponseEntity sayHello() throws JAXBException {
        EkbRequestDto ekbRequestDto = new EkbRequestDto(new R("hh","kh",new I("m,s")));
        return ResponseEntity.ok(marshallerWrapperService.marshallXml(ekbRequestDto));
    }

    @GetMapping(value = "/download")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=customers.xlsx");
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(new InputStreamResource(excelPOIHelperService.writeExcel()));
    }

}
