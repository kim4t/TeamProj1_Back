package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Person;

public interface PersonDao {
    Person getPersonById(int id);

    Integer addPerson(Person person);

}
