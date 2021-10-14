package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.ApplicationWorkFlowDao;
import bfs.TeamProj.domain.ApplicationWorkFlow;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateApplicationWorkFlowDao extends AbstractHibernateDAO<ApplicationWorkFlow> implements ApplicationWorkFlowDao {

    public HibernateApplicationWorkFlowDao(){
        setClazz(ApplicationWorkFlow.class);
    }
    @Override
    public ApplicationWorkFlow getApplicationWorkFlowById(int id) {
        return findById(id);
    }

    @Override
    public ApplicationWorkFlow addApplicationWorkFlow(ApplicationWorkFlow applicationWorkFlow) {
        return create(applicationWorkFlow);
    }
}
