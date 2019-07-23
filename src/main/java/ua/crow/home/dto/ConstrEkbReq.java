package ua.crow.home.dto;

import ua.crow.home.enums.EkbRequest;

public class ConstrEkbReq {

    protected EkbRequestDto ekbRequestDto;

    public ConstrEkbReq(LetterClient lc, EkbRequest ekbRequest){
        switch(ekbRequest){
            case INF_NEW:
                ekbRequestDto = getCreateInfNew(lc);
                break;
            case CONF_NEW:
                break;
        }
    }

    private EkbRequestDto getCreateInfNew(LetterClient lc){
        return new EkbRequestDto(new R("testSid",EkbRequest.INF_NEW.getRequest(),new I(lc.getOkpo())));
    }

    private EkbRequestDto getCreateConfNew(Object o){
        return null;
    }
}
