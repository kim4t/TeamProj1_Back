package bfs.TeamProj.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "roleName", nullable = false, length = 250)
    private String roleName;
    @Column(name = "description", nullable = false, length = 250)
    private String description;
    @Column(name = "createDate", nullable = false, length = 250)
    private LocalDate createDate;
    @Column(name = "modificationDate", nullable = false, length = 250)
    private LocalDate modificationDate;
    @Column(name = "lastModificationUser", nullable = false, length = 250)
    private String lastModificationUser;

    @OneToOne(mappedBy = "role")
    private UserRole userRole;
    @OneToOne(mappedBy = "role")
    private RolePermission rolePermission;
}


