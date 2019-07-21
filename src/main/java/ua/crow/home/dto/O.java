package ua.crow.home.dto;

import lombok.*;

import javax.xml.bind.annotation.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "o")
@XmlAccessorType(XmlAccessType.FIELD)
public class O {

    @XmlElement(name="Id")
    private String id="";
    @XmlElement(name="St")
    private String st="";
    @XmlElement(name="OKPO")
    private String okpo="";
}
