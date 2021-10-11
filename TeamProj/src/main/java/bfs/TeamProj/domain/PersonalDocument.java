package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="facility")
public class PersonalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "path", nullable = false, length = 250)
    private String path;
    @Column(name = "title", nullable = false, length = 250)
    private String title;
    @Column(name = "comment", nullable = true, length = 250)
    private String comment;
    @Column(name = "createdDate", nullable = false, length = 250)
    private LocalDate createdDate;
    @Column(name = "createdBy", nullable = false, length = 250)
    private String createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

