package bfs.TeamProj.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Address {
    private Integer id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String stateName;
    private String stateAbbr;
    private Integer personId;
}
