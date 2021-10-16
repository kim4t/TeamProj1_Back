package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "rolePermission")
public class RolePermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @Column(name = "activeFlag", nullable = false)
    private Boolean activeFlag;
    @Column(name = "createDate", nullable = false, length = 250)
    private LocalDate createDate;
    @Column(name = "modificationDate", nullable = false, length = 250)
    private LocalDate modificationDate;
    @Column(name = "lastModificationUser", nullable = false, length = 250)
    private String lastModificationUser;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permissionId")
    private Permission permission;

}

