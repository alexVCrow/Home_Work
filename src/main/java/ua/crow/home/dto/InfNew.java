package ua.crow.home.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlRootElement(name = "INF_NEW")
@XmlAccessorType(XmlAccessType.FIELD)
public class InfNew {

    @XmlAttribute(name="Id")
    private String id;
    @XmlAttribute(name="OKPO")
    private String okpo;
    @XmlAttribute(name="St")
    private String st;
}
