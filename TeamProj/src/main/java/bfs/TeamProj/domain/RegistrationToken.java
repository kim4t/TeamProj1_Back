package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
@Data
@Entity
@Table(name ="registrationToken")
public class RegistrationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "token", nullable = false, length = 250)
    private String token;
    @Column(name = "validDuration", nullable = false, length = 250)
    private LocalDate validDuration;
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Column(name = "createdBy", nullable = false, length = 250)
    private String createdBy;
}

