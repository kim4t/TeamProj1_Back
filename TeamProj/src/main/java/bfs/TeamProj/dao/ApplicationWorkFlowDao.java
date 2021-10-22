package bfs.TeamProj.dao;

import bfs.TeamProj.domain.ApplicationWorkFlow;

import java.util.List;

public interface ApplicationWorkFlowDao {
    ApplicationWorkFlow getApplicationWorkFlowById(int id);

    List<ApplicationWorkFlow> getAllApplicationWorkFlow();

    ApplicationWorkFlow addApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow);

    ApplicationWorkFlow getApplicationWorkFlowByEmployeeId(int employeeId);

    ApplicationWorkFlow updateApplicationWorkFlow (ApplicationWorkFlow applicationWorkFlow);
}
