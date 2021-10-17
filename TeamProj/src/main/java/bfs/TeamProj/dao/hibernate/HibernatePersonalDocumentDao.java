package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.PersonalDocumentDao;
import bfs.TeamProj.domain.PersonalDocument;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HibernatePersonalDocumentDao extends AbstractHibernateDAO<PersonalDocument> implements PersonalDocumentDao {
    public HibernatePersonalDocumentDao(){
        setClazz(PersonalDocument.class);
    }

    @Override
    public PersonalDocument addPersonalDocument(PersonalDocument doc) {
        return create(doc);
    }

    @Override
    public List<PersonalDocument> getPersonalDocumentListByEmployeeId(int employeeId) {
        return findALLByField("employeeId", employeeId);
    }
}
