package ua.crow.home.dto;

import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "i")
@XmlAccessorType(XmlAccessType.FIELD)
public class I {

    @XmlAttribute(name="OKPO")
    private String okpo;
    @XmlAttribute(name="DB")
    private String db;
    @XmlAttribute(name="LName")
    private String lName;
    @XmlAttribute(name="FName")
    private String fName;
    @XmlAttribute(name="MName")
    private String mName;

    public I (String okpo){
        this.okpo = okpo;
    }

    public I (String db, String lName, String fName, String mName){
        this.db = db;
        this.lName = lName;
        this.fName = fName;
        this.mName = mName;
    }
}
