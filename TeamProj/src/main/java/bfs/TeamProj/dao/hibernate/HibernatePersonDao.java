package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.domain.Person;
import bfs.TeamProj.exception.AgeInvalidException;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository()
public class HibernatePersonDao extends AbstractHibernateDAO<Person> implements PersonDao {
    public HibernatePersonDao() {
        setClazz(Person.class);
    }

    @Override
    public Person getPersonById(int id) {
        return findById(id);
    }

    @Override
    public List<Person> getALlPerson() {
        return findAll();
    }

    @Override
    public Person addPerson(Person person) throws AgeInvalidException {

        if(LocalDate.now().compareTo(LocalDate.parse(person.getDOB())) <=0){
            throw new AgeInvalidException("The age is invalid");
        }
        return create(person);
    }

    @Override
    public Person updatePerson(Person person) throws AgeInvalidException {
        if(LocalDate.now().compareTo(LocalDate.parse(person.getDOB())) <=0){
            throw new AgeInvalidException("The age is invalid");
        }
        return update(person);
    }
}
