package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class DigitalDocument {
    private Integer id;
    private String type;
    private Boolean Required;
    private LocalDate templateLocation;
    private String description;
}


