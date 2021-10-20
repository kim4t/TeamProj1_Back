package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.domain.Person;
import bfs.TeamProj.exception.AgeInvalidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personService")
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public Person addPerson(Person p) throws AgeInvalidException {
        return personDao.addPerson(p);
    }

    @Transactional
    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }

    @Transactional
    public List<Person> getAllPerson() {
        return personDao.getALlPerson();
    }

    @Transactional
    public Person updatePerson(Person p) throws AgeInvalidException {
        return personDao.updatePerson(p);
    }
}
