package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.PersonalDocumentDao;
import bfs.TeamProj.domain.PersonalDocument;

import java.util.List;

public class HibernatePersonalDocumentDao extends AbstractHibernateDAO<PersonalDocument> implements PersonalDocumentDao {
    @Override
    public PersonalDocument addPersonalDocument(PersonalDocument doc) {
        return create(doc);
    }

    @Override
    public List<PersonalDocument> getPersonalDocumentListByEmployeeId(int employeeId) {
        return findByField("employeeId", employeeId);
    }
}
