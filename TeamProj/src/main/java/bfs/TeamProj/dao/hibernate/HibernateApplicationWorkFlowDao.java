package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.ApplicationWorkFlowDao;
import bfs.TeamProj.domain.ApplicationWorkFlow;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateApplicationWorkFlowDao extends AbstractHibernateDAO<ApplicationWorkFlow> implements ApplicationWorkFlowDao {

    public HibernateApplicationWorkFlowDao() {
        setClazz(ApplicationWorkFlow.class);
    }

    @Override
    public ApplicationWorkFlow getApplicationWorkFlowById(int id) {
        return findById(id);
    }

    @Override
    public List<ApplicationWorkFlow> getAllApplicationWorkFlow() {
        return findAll();
    }

    @Override
    public ApplicationWorkFlow addApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow) {
        return create(applicationWorkFlow);
    }

    @Override
    public ApplicationWorkFlow getApplicationWorkFlowByEmployeeId(int employeeId) {
        return findByField("employeeId", employeeId);
    }

    @Override
    public ApplicationWorkFlow updateApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow) {
        return update(applicationWorkFlow);
    }
}
