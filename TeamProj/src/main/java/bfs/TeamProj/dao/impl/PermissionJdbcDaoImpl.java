package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.PermissionDao;
import bfs.TeamProj.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

//@Repository("permissionJdbcDao")
public class PermissionJdbcDaoImpl implements PermissionDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_ALL_PERMISSION = "SELECT * FROM permission";
    private static final String INSERT_PERMISSION = "INSERT INTO permission (createDate, lastModificationUser, modificationDate, permissionDescription, permissionName) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public Integer addPermission(Permission permission) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_PERMISSION, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, Date.valueOf(permission.getCreateDate()));
            statement.setString(2, permission.getLastModificationUser());
            statement.setDate(3, Date.valueOf(permission.getModificationDate()));
            statement.setString(4, permission.getPermissionDescription());
            statement.setString(5, permission.getPermissionName());
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<Permission> getAllPermission() {
        return jdbcTemplate.query(GET_ALL_PERMISSION, new BeanPropertyRowMapper<>(Permission.class));
    }

    @Override
    public Permission getPermissionById(int id) {
        return null;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
