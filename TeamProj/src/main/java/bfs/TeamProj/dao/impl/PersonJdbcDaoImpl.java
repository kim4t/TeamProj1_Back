package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("personJdbcDao")
public class PersonJdbcDaoImpl implements PersonDao {
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_PERSON = "INSERT INTO person (first_Name, last_Name, middle_Name, email, cellphone, alternate_Phone, gender, SSN, DOB) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public Person getPersonById(int id) {
        return null;
    }

    @Override
    public Integer addPerson(Person person) {
        return jdbcTemplate.update(INSERT_PERSON,
                person.getFirstName(), person.getLastName(), person.getMiddleName(),
                person.getEmail(), person.getCellphone(),person.getAlternatePhone(),
                person.getGender(), person.getSSN(), person.getDOB());
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
