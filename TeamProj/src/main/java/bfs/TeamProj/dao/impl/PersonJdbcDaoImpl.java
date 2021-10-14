
/*package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.PersonDao;
import bfs.TeamProj.dao.jdbcmapper.PersonRowMapper;
import bfs.TeamProj.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;


public class PersonJdbcDaoImpl implements PersonDao {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_PERSON_BY_ID = "SELECT * FROM person WHERE id=?";
    private static final String INSERT_PERSON = "INSERT INTO person (firstName, lastName, middleName, email, cellphone, alternatePhone, gender, SSN, DOB) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    @Override
    public Person getPersonById(int id) {
        //return jdbcTemplate.queryForObject(GET_PERSON_BY_ID, new PersonRowMapper(), id);
        return jdbcTemplate.queryForObject(GET_PERSON_BY_ID, new BeanPropertyRowMapper<>(Person.class), id);

    }

    @Override
    public Integer addPerson(Person person) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_PERSON, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, person.getFirstName());
            statement.setString(2, person.getLastName());
            statement.setString(3, person.getMiddleName());
            statement.setString(4, person.getEmail());
            statement.setString(5, person.getCellphone());
            statement.setString(6, person.getAlternatePhone());
            statement.setString(7, person.getGender());
            statement.setString(8, person.getSSN());
            statement.setString(9, person.getDOB());
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
*/