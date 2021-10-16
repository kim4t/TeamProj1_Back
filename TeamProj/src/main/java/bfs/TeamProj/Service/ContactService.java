package bfs.TeamProj.Service;

import bfs.TeamProj.dao.ContactDao;
import bfs.TeamProj.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactDao contactDao;

    @Transactional
    public Contact addContact(Contact contact) {
        return contactDao.addContact(contact);
    }

    @Transactional
    public List<Contact> getAllContact() {
        return contactDao.getAllContact();
    }

    @Transactional
    public Contact getContactById(int id) {
        return contactDao.getContactById(id);
    }

    @Transactional
    public List<Contact> getContactsByRefPersonId(int personId) {
        return contactDao.getContactsByRefPersonId(personId);
    }
}
