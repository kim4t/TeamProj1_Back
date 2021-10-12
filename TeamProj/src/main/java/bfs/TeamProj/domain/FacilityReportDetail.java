package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="facilityReportDetail")
public class FacilityReportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "comments", nullable = false, length = 250)
    private String comments;
    @Column(name = "createdDate", nullable = false, length = 250)
    private LocalDate createdDate;
    @Column(name = "lastModificationDate", nullable = false, length = 250)
    private LocalDate lastModificationDate;

    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "reportId")
    //private FacilityReport facilityReport;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reportId")
    private FacilityReport facilityReport;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;
}
