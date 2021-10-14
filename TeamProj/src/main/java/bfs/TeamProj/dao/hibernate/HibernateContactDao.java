package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.ContactDao;
import bfs.TeamProj.domain.Contact;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateContactDao extends AbstractHibernateDAO<Contact> implements ContactDao {
    public HibernateContactDao() {
        setClazz(Contact.class);
    }

    @Override
    public Contact addContact(Contact contact) {
        return create(contact);
    }

    @Override
    public List<Contact> getAllContact() {
        return findAll();
    }

    @Override
    public Contact getContactById(int id) {
        return findById(id);
    }
}
