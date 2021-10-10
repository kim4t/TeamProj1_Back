package bfs.TeamProj.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Data
@RequiredArgsConstructor
public class Employee {
    private Integer id;
    private Integer personId;
    private String title;
    private Integer managerId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String avatar;
    private String car;
    private Integer visaStatusId;
    private LocalDate visaStartDate;
    private LocalDate visaEndDate;
    private String driverLicense;
    private LocalDate driverLicenseExpirationDate;
    private Integer houseId;

}
