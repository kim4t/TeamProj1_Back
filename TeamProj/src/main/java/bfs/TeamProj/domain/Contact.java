package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "relationship", nullable = false, length = 250)
    private String relationship;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Column(name = "isReference", nullable = false)
    private Boolean isReference;

    @Column(name = "isEmergency", nullable = false)
    private Boolean isEmergency;

    @Column(name = "isLandLord", nullable = false, length = 250)
    private Boolean isLandLord;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    private Person person;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referencePersonId")
    private Person person2;

    @OneToOne(mappedBy = "contact")
    private House house;
}
