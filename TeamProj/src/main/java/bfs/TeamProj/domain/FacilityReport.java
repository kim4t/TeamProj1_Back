package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class FacilityReport {
    private Integer id;
    private String title;
    private Integer employeeId;
    private LocalDate reportDate;
    private String description;
    private String status;
}
