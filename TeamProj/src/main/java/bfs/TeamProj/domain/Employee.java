package bfs.TeamProj.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "title", nullable = false, length = 250)
    private String title;
    @Column(name = "managerId", nullable = true)
    private Integer managerId;
    @Column(name = "startDate", nullable = false, length = 250)
    private LocalDate startDate;
    @Column(name = "endDate", nullable = false, length = 250)
    private LocalDate endDate;
    @Column(name = "avatar", nullable = true, length = 250)
    private String avatar;
    @Column(name = "car", nullable = true, length = 250)
    private String car;
    @Column(name = "visaStartDate", nullable = false, length = 250)
    private LocalDate visaStartDate;
    @Column(name = "visaEndDate", nullable = false, length = 250)
    private LocalDate visaEndDate;
    @Column(name = "driverLicense", nullable = true, length = 250)
    private String driverLicense;
    @Column(name = "driverLicenseExpirationDate", nullable = true, length = 250)
    private LocalDate driverLicenseExpirationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "houseId")
    private House house;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visaStatusId")
    private VisaStatus visaStatus;

    @OneToMany(mappedBy = "employee")
    private List<FacilityReport> facilityReportList = new ArrayList<>();

    @OneToMany(mappedBy = "employee")
    private List<PersonalDocument> personalDocumentList = new ArrayList<>();

}
