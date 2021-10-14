/*package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.RoleDao;
import bfs.TeamProj.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

//@Repository("roleJdbcDao")
public class RoleJdbcDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    private static final String GET_ROLE_BY_ID = "SELECT * FROM role WHERE id=?";
    private static final String GET_ALL_ROLE = "SELECT * FROM role";
    private static final String INSERT_ROLE = "INSERT INTO role (createDate, description, lastModificationUser, modificationDate, roleName) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<Role> getAllRole() {
        return jdbcTemplate.query(GET_ALL_ROLE, new BeanPropertyRowMapper<>(Role.class));
    }

    @Override
    public Role getRoleById(int id) {
        return jdbcTemplate.queryForObject(GET_ROLE_BY_ID, new BeanPropertyRowMapper<>(Role.class), id);
    }

    @Override
    public Integer addRole(Role role) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_ROLE, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(role.getCreateDate()));
            statement.setString(2, role.getDescription());
            statement.setString(3, role.getLastModificationUser());
            statement.setDate(4, Date.valueOf(role.getModificationDate()));
            statement.setString(5, role.getDescription());
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

