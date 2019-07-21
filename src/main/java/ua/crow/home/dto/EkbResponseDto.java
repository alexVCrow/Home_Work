package ua.crow.home.dto;


import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "doc")
@XmlAccessorType(XmlAccessType.FIELD)
public class EkbResponseDto {

    private R r;
}
