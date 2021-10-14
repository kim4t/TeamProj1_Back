package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.DigitalDocumentDao;
import bfs.TeamProj.domain.DigitalDocument;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateDigitalDocumentDao extends AbstractHibernateDAO<DigitalDocument> implements DigitalDocumentDao {
    public HibernateDigitalDocumentDao() {
        setClazz(DigitalDocument.class);
    }
    @Override
    public DigitalDocument addDigitalDocument(DigitalDocument doc) {
        return create(doc);
    }

    @Override
    public List<DigitalDocument> getAllDigitalDocument() {
        return findAll();
    }
}
