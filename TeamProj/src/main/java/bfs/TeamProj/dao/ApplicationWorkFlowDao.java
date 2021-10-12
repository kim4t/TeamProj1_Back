package bfs.TeamProj.dao;

import bfs.TeamProj.domain.ApplicationWorkFlow;

public interface ApplicationWorkFlowDao {
    ApplicationWorkFlow getApplicationWorkFlowById(int id);

    Integer addApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow, int employeeId);
}
