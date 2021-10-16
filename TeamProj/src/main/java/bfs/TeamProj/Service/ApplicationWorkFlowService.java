package bfs.TeamProj.Service;

import bfs.TeamProj.dao.ApplicationWorkFlowDao;
import bfs.TeamProj.domain.ApplicationWorkFlow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApplicationWorkFlowService {
    @Autowired
    private ApplicationWorkFlowDao applicationWorkFlowDao;

    @Transactional
    public ApplicationWorkFlow getApplicationWorkFlowById(int id) {
        return applicationWorkFlowDao.getApplicationWorkFlowById(id);
    }

    @Transactional
    public ApplicationWorkFlow addApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow) {
        return applicationWorkFlowDao.addApplicationWorkFlow(applicationWorkFlow);
    }

    @Transactional
    public ApplicationWorkFlow getApplicationWorkFlowByEmployeeId(int employeeId) {
        return applicationWorkFlowDao.getApplicationWorkFlowByEmployeeId(employeeId);
    }
}
