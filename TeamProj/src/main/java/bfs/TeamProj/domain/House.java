package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class House {
    private Integer id;
    private Integer contactId;
    private String address;
    private int numberOfPerson;
}
