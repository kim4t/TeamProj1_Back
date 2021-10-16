package bfs.TeamProj.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeProfile {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate visaStartDate;
    private String visaStatus;
}
