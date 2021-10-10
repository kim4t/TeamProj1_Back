package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
@Data
@RequiredArgsConstructor
public class RegistrationToken {
    private Integer id;
    private String token;
    private LocalDate validDuration;
    private String email;
    private String createdBy;
}

