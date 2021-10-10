package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Facility {
    private Integer id;
    private String type;
    private String description;
    private int quantity;
    private Integer houseId;
}

