package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.domain.Person;
import org.springframework.stereotype.Repository;

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
    public Person addPerson(Person person) {
        return create(person);
    }
}
