package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="facilityReport")
public class FacilityReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Column(name = "reportDate", nullable = false, length = 250)
    private LocalDate reportDate;
    @Column(name = "description", nullable = false, length = 250)
    private String description;
    @Column(name = "status", nullable = false, length = 250)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;

    @OneToOne(mappedBy = "facilityReport")
    private FacilityReportDetail facilityReportDetail;
}
