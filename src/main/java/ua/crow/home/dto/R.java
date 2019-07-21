package ua.crow.home.dto;


import lombok.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@XmlRootElement(name = "r")
@XmlAccessorType(XmlAccessType.FIELD)
public class R {

    @XmlAttribute
    private String cntr = "UA";
    @XmlAttribute
    private String key = "0";
    @XmlAttribute
    private String sid;
    @XmlAttribute(name="t")
    private String type;
    private I i;
    private String t="";
    private O o;
    @XmlElement(name="INF_NEW")
    private List<InfNew> infNews;


    public R (String sid, String type, I i){
        this.sid = sid;
        this.type = type;
        this.i = i;
        this.o = new O();
    }

    public String getInfs(){
        return infNews.stream()
                .filter(infNew -> infNew.getSt() != null && infNew.getSt().equalsIgnoreCase("A"))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("No user found with username ")).getId();
    }

}
