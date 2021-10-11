package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="digitalDocument")
public class DigitalDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "type", nullable = false, length = 250)
    private String type;
    @Column(name = "Required", nullable = false)
    private Boolean Required;
    @Column(name = "templateLocation", nullable = false, length = 250)
    private LocalDate templateLocation;
    @Column(name = "description", nullable = false, length = 250)
    private String description;
}


