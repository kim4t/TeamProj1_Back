package bfs.TeamProj.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "userName", nullable = false, length = 250)
    private String userName;
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Column(name = "password", nullable = false, length = 250)
    private String password;
    @Column(name = "createDate", nullable = false, length = 250)
    private LocalDate createDate;
    @Column(name = "modificationDate", nullable = false, length = 250)
    private LocalDate modificationDate;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personId")
    private Person person;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private UserRole userRole;

    @Override
    public String toString() {
        return String.format("%s(id=%d, name='%s', email=%s, password=%s, createDate=%s, personId=%s)",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getUserName(),
                this.getEmail(),
                this.getPassword(),
                this.getCreateDate(),
                this.getPerson() == null ? "no person" : this.getPerson().getId());
    }
}