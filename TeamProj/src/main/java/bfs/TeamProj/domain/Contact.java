package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Contact {
    private Integer id;
    private Integer personId;
    private String relationship;
    private String title;
    private Boolean isReference;
    private Boolean isEmergency;
    private Boolean isLandLord;
}
