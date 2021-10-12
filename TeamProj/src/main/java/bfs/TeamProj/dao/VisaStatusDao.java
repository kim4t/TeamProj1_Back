package bfs.TeamProj.dao;

import bfs.TeamProj.domain.VisaStatus;


public interface VisaStatusDao {
    VisaStatus getVisaStatusById(int id);

    Integer addVisaStatus(VisaStatus visaStatus);
}
