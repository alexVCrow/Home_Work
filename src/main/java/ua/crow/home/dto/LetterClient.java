package ua.crow.home.dto;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LetterClient {

    private String okpo;
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birhtDate;
}
