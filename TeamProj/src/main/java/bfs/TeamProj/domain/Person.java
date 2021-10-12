package bfs.TeamProj.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "firstName", nullable = false, length = 250)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 250)
    private String lastName;

    @Column(name = "middleName", nullable = true, length = 250)
    private String middleName;

    @Column(name = "email", nullable = false, length = 250)
    private String email;

    @Column(name = "cellphone", nullable = false, length = 250)
    private String cellphone;

    @Column(name = "alternatePhone", nullable = true, length = 250)
    private String alternatePhone;

    @Column(name = "gender", nullable = false, length = 250)
    private String gender;

    @Column(name = "SSN", nullable = true, length = 250)
    private String SSN;

    @Column(name = "DOB", nullable = true, length = 250)
    private String DOB;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private Contact contact;

    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY)
    private User user;

}
