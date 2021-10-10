package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class ApplicationWorkFlow {
    private Integer id;
    private Integer employeeId;
    private LocalDate createdDate;
    private LocalDate modificationDate;
    private String status;
    private String comments;
    private String type;
}

