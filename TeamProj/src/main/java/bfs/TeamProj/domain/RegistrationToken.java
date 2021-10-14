package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name ="registrationToken")
public class RegistrationToken implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "token", nullable = false, length = 250)
    private String token;
    @Column(name = "validDuration", nullable = false, length = 250)
    private LocalDateTime validDuration;
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Column(name = "createdBy", nullable = false, length = 250)
    private String createdBy;
}

