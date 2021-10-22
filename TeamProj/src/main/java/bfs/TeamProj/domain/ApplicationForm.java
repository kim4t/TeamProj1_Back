package bfs.TeamProj.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ApplicationForm {
    private int employeeId;
    private LocalDate lastModifiedDate;
    private String type;
    String status;

}
