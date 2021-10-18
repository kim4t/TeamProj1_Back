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
    @Column(name = "startDate", nullable = true, length = 250)
    private LocalDate startDate;
    @Column(name = "endDate", nullable = true, length = 250)
    private LocalDate endDate;
    @Column(name = "avatar", nullable = true, length = 250)
    private String avatar;
    @Column(name = "car", nullable = true, length = 250)
    private String car;
    @Column(name = "visaStartDate", nullable = true, length = 250)
    private LocalDate visaStartDate;
    @Column(name = "visaEndDate", nullable = true, length = 250)
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "visaStatusId")
    private VisaStatus visaStatus;

    @OneToOne(mappedBy = "employee")
    private ApplicationWorkFlow applicationWorkFlow;


    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<FacilityReport> facilityReportList = new ArrayList<>();

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
    private List<PersonalDocument> personalDocumentList = new ArrayList<>();

}
