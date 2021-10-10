package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class RolePermission {
    private Integer id;
    private Integer roleId;
    private Integer permissionId;
    private Boolean activeFlag;
    private LocalDate createDate;
    private LocalDate modificationDate;
    private String lastModificationUser;
}

