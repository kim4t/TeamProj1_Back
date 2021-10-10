package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class PersonalDocument {
    private Integer id;
    private Integer employeeId;
    private String path;
    private String title;
    private String comment;
    private LocalDate createdDate;
    private String CreatedBy;
}

