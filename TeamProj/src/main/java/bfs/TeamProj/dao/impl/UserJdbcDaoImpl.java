package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.UserDao;
import bfs.TeamProj.dao.jdbcmapper.PersonRowMapper;
import bfs.TeamProj.dao.jdbcmapper.UserRowMapper;
import bfs.TeamProj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository("userJdbcDao")
public class UserJdbcDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String INSERT_USER = "INSERT INTO user (user_name, password, email, person_id, create_date, modification_date) " +
            "VALUES (?, ?, ?, ?, ?, ?)";

    @Override
    public User getUserById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID, new UserRowMapper(), id);
        //return jdbcTemplate.queryForObject(GET_USER_BY_ID, new BeanPropertyRowMapper<>(User.class), id);
    }

    @Override
    public Integer addUser(User user, int personId) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, personId);
            statement.setDate(5, Date.valueOf(user.getCreateDate()));
            statement.setDate(6, Date.valueOf(user.getModificationDate()));
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }


    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
