package ua.crow.home.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EkbRequest {

    INF_NEW("INF_NEW"),
    CONF_NEW("CONF_NEW");

    private String request;
}
