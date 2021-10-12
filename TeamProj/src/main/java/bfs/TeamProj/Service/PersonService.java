package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("personService")
public class PersonService {
    @Autowired
    private PersonDao personDao;

    @Transactional
    public Integer addPerson(Person p) {
        return personDao.addPerson(p);
    }

    @Transactional
    public Person getPersonById(int id) {
        return personDao.getPersonById(id);
    }
}
