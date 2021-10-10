package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Person {
    private Integer id;
    private String firstName;
    private String LastName;
    private String middleName;
    private String email;
    private String cellphone;
    private String alternatePhone;
    private String gender;
    private String SSN;
    private String DOB;
}
