package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "permissionName", nullable = false)
    private String permissionName;
    @Column(name = "permissionDescription", nullable = false)
    private String permissionDescription;
    @Column(name = "createDate", nullable = false)
    private LocalDate createDate;
    @Column(name = "modificationDate", nullable = false)
    private LocalDate modificationDate;
    @Column(name = "lastModificationUser", nullable = false)
    private String lastModificationUser;

    @OneToOne(mappedBy = "permission")
    RolePermission rolePermission;
}
