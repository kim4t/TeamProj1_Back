package bfs.TeamProj.domain;

import lombok.*;

import java.time.LocalDate;
@Data
@RequiredArgsConstructor
public class Role {
    private Integer id;
    private String roleName;
    private String description;
    private LocalDate createDate;
    private LocalDate modificationDate;
    private String lastModificationUser;
}


