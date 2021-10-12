package bfs.TeamProj.dao.jdbcmapper;

import bfs.TeamProj.domain.Person;
import bfs.TeamProj.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = (new BeanPropertyRowMapper<>(User.class)).mapRow(rs,rowNum);
        int personId = rs.getInt("personId");
        Person p = new Person();
        p.setId(personId);
        user.setPerson(p);
        return user;
    }
}
