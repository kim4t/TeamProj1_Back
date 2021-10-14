package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Person;

import java.util.List;

public interface PersonDao {
    Person getPersonById(int id);

    List<Person> getALlPerson();

    Person addPerson(Person person);

}
