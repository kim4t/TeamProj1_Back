package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "address", nullable = false, length = 250)
    private String address;

    @Column(name = "numberOfPerson", nullable = false)
    private int numberOfPerson;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contactId")
    private Contact contact;

    @OneToMany(mappedBy = "house")
    private List<Facility> facilityList = new ArrayList<>();

}
