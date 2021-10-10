package bfs.TeamProj.domain;

import lombok.*;

import java.time.LocalDate;
@Data
@RequiredArgsConstructor
public class User {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private LocalDate createDate;
    private Integer personId;
    private LocalDate modificationDate;

}
