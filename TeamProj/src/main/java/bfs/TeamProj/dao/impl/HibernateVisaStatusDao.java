package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.VisaStatusDao;
import bfs.TeamProj.domain.VisaStatus;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateVisaStatusDao extends AbstractHibernateDAO<VisaStatus> implements VisaStatusDao {
    public HibernateVisaStatusDao(){
        setClazz(VisaStatus.class);
    }

    @Override
    public VisaStatus getVisaStatusById(int id) {
        return findById(id);
    }

    @Override
    public Integer addVisaStatus(VisaStatus visaStatus) {
        return create(visaStatus).getId();
    }
}
