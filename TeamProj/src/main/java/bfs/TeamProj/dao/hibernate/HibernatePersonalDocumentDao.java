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
    public PersonalDocument getPersonalDocumentById(int id) {
        return findById(id);
    }

    @Override
    public List<PersonalDocument> getPersonalDocumentListByEmployeeId(int employeeId) {
        return findALLByField("employeeId", employeeId);
    }

    @Override
    public PersonalDocument updatePersonalDocument(PersonalDocument doc) {
        return update(doc);
    }

    @Override
    public PersonalDocument getPersonalDocumentByTitle(String title) {
        return findByField("title", title);
    }
}
