package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name="visaStatus")
public class VisaStatus implements Serializable {
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

