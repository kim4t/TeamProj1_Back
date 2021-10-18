package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PersonalDocumentDao;
import bfs.TeamProj.domain.PersonalDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonalDocumentService {
    @Autowired
    private PersonalDocumentDao personalDocumentDao;

    @Transactional
    public PersonalDocument addPersonalDocument(PersonalDocument doc) {
        return personalDocumentDao.addPersonalDocument(doc);
    }

    @Transactional
    public List<PersonalDocument> getPersonalDocumentListByEmployeeId(int personId) {
        return personalDocumentDao.getPersonalDocumentListByEmployeeId(personId);
    }

    @Transactional
    public PersonalDocument getPersonalDocumentById(int id) {
        return personalDocumentDao.getPersonalDocumentById(id);
    }

    @Transactional
    public PersonalDocument updatePersonalDocument(PersonalDocument personalDocument) {
        return personalDocumentDao.updatePersonalDocument(personalDocument);
    }

    @Transactional
    public PersonalDocument getPersonalDocumentByTitle(String title) {
        return personalDocumentDao.getPersonalDocumentByTitle(title);
    }
}
