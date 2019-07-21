package ua.crow.home.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.crow.home.dto.EkbRequestDto;
import ua.crow.home.dto.I;
import ua.crow.home.dto.R;

import javax.xml.bind.JAXBException;

@Service
public class ProductToXml {

    @Autowired
    private MarshallerWrapperService marshallerWrapperService;

    public String testObjectToXml(EkbRequestDto ekbRequestDto){
        return marshallerWrapperService.marshallXml(ekbRequestDto);
    }
}
