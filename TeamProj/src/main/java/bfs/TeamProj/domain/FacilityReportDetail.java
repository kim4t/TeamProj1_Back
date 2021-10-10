package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class FacilityReportDetail {
    private Integer id;
    private Integer reportId;
    private Integer employeeId;
    private String comments;
    private LocalDate createdDate;
    private LocalDate lastModificationDate;
}
