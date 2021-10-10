package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Data
@RequiredArgsConstructor
public class Permission {
    private Integer id;
    private String permissionName;
    private String permissionDescription;
    private LocalDate createDate;
    private LocalDate modificationDate;
    private String lastModificationUser;
}
