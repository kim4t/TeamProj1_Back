package bfs.TeamProj.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StatusProfile {
    private String firstName;
    private String lastName;
    private String middleName;
    private LocalDate visaEndDate;
    private int dayLeft;
    private String status;
}
