package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Person;
import bfs.TeamProj.exception.AgeInvalidException;

import java.util.List;

public interface PersonDao {
    Person getPersonById(int id);

    List<Person> getALlPerson();

    Person addPerson(Person person) throws AgeInvalidException;

    Person updatePerson(Person person) throws AgeInvalidException;

}
