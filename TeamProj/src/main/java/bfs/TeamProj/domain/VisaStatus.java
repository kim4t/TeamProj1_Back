package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class VisaStatus {
    private Integer id;
    private String visaType;
    private Boolean active;
    private LocalDate modificationDate;
    private String createUser;
}

