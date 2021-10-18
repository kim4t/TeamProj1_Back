package bfs.TeamProj.dao;

import bfs.TeamProj.domain.ApplicationWorkFlow;

public interface ApplicationWorkFlowDao {
    ApplicationWorkFlow getApplicationWorkFlowById(int id);

    ApplicationWorkFlow addApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow);

    ApplicationWorkFlow getApplicationWorkFlowByEmployeeId(int employeeId);

    ApplicationWorkFlow updateApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow);
}
