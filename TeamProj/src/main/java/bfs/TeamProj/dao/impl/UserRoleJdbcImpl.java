/*package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.UserRoleDao;
import bfs.TeamProj.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository("userRoleJdbcDao")
public class UserRoleJdbcImpl implements UserRoleDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_ALL_USER_ROLE = "SELECT * FROM userRole";
    private static final String INSERT_USER_ROLE = "INSERT INTO userRole (activeFlag, lastModificationUser, modificationDate, userId, roleId) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public Integer addUserRole(UserRole userRole, int userId, int roleId) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_USER_ROLE, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, userRole.getActiveFlag());
            statement.setString(2, userRole.getLastModificationUser());
            statement.setDate(3, Date.valueOf(userRole.getModificationDate()));
            statement.setInt(4, userId);
            statement.setInt(5, roleId);
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<UserRole> getAllUserRole() {
        return jdbcTemplate.query(GET_ALL_USER_ROLE, new BeanPropertyRowMapper<>(UserRole.class));
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}

 */
