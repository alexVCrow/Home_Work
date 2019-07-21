package ua.crow.home.dto;


import lombok.*;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@XmlRootElement(name = "doc")
@XmlAccessorType(XmlAccessType.FIELD)
public class EkbRequestDto {

    private R r;

}
