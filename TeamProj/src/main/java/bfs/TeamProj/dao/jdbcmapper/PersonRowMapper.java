package bfs.TeamProj.dao.jdbcmapper;

import bfs.TeamProj.domain.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person p = new Person();
        p.setId(rs.getInt("id"));
        p.setFirstName(rs.getString("first_Name"));
        p.setLastName(rs.getString("last_Name"));
        p.setMiddleName(rs.getString("middle_Name"));
        p.setEmail(rs.getString("email"));
        p.setCellphone(rs.getString("cellphone"));
        p.setAlternatePhone(rs.getString("alternate_Phone"));
        p.setGender(rs.getString("gender"));
        p.setSSN(rs.getString("SSN"));
        p.setDOB(rs.getString("DOB"));
        return p;
    }
}
