package ua.crow.home.dto;

import ua.crow.home.enums.EkbRequest;

public class EkbCreateRequest extends ConstrEkbReq {

    public EkbCreateRequest(LetterClient lc, EkbRequest ekbRequest) {
        super(lc, ekbRequest);
    }

    public EkbRequestDto getCreate(){
        return ekbRequestDto;
    }
}
