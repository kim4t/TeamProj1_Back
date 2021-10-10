package bfs.TeamProj.domain;

import lombok.*;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class UserRole {
    private Integer id;
    private Integer userId;
    private Integer roleId;
    private Boolean activeFlag;
    private LocalDate modificationDate;
    private String lastModificationUser;
}

