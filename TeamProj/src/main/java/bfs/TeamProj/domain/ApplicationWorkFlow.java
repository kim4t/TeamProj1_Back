package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "applicationWorkFlow")
public class ApplicationWorkFlow implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "createdDate", nullable = false, length = 250)
    private LocalDate createdDate;
    @Column(name = "modificationDate", nullable = false, length = 250)
    private LocalDate modificationDate;
    @Column(name = "status", nullable = false, length = 250)
    private String status;
    @Column(name = "comments", nullable = true, length = 250)
    private String comments;
    @Column(name = "type", nullable = false, length = 250)
    private String type;

    public ApplicationWorkFlow() {

    }

    public ApplicationWorkFlow(int id, LocalDate createdDate, LocalDate modificationDate, String status, String type) {
        this.id = id;
        this.createdDate = createdDate;
        this.modificationDate = modificationDate;
        this.status = status;
        this.type = type;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId")
    private Employee employee;
}

