package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="employee")
public class VisaStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "visaType", nullable = false, length = 250)
    private String visaType;
    @Column(name = "active", nullable = false)
    private Boolean active;
    @Column(name = "modificationDate", nullable = false, length = 250)
    private LocalDate modificationDate;
    @Column(name = "createUser", nullable = false, length = 250)
    private String createUser;

    @OneToOne(mappedBy = "visaStatus")
    private Employee employee;
}

