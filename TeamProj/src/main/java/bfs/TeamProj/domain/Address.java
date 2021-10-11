package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "addressLine1", nullable = false, length = 250)
    private String addressLine1;

    @Column(name = "addressLine2", nullable = true, length = 250)
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 250)
    private String city;

    @Column(name = "zipCode", nullable = false, length = 250)
    private String zipCode;

    @Column(name = "stateName", nullable = false, length = 250)
    private String stateName;

    @Column(name = "stateAbbr", nullable = false, length = 250)
    private String stateAbbr;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    private Person person;
}
