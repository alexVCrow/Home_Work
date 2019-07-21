package ua.crow.home.dto;

import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "r")
@XmlAccessorType(XmlAccessType.FIELD)
public class RRsp {

//    @XmlAttribute
//    private String key;
    @XmlElement(name="INF_NEW")
    private List<InfNew> infNews;

}
