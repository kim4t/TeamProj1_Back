package bfs.TeamProj.dao.impl;

import bfs.TeamProj.dao.RolePermissionDao;
import bfs.TeamProj.domain.RolePermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
@Repository("rolePermissionJdbcDao")
public class RolePermissionJdbcImpl implements RolePermissionDao {
    private JdbcTemplate jdbcTemplate;
    private static final String GET_ALL_ROLE_PERMISSION = "SELECT * FROM role_permission";
    private static final String INSERT_ROLE_PERMISSION = "INSERT INTO role_permission (active_flag, create_date, last_modification_user, modification_date, permission_id, role_id) " +
            "VALUES (?, ?, ?, ?, ?)";

    @Override
    public Integer addRolePermission(RolePermission rolePermission, int permissionId, int roleId) {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement statement = con.prepareStatement(INSERT_ROLE_PERMISSION, Statement.RETURN_GENERATED_KEYS);
            statement.setBoolean(1, rolePermission.getActiveFlag());
            statement.setDate(3, Date.valueOf(rolePermission.getCreateDate()));
            statement.setString(2, rolePermission.getLastModificationUser());
            statement.setDate(3, Date.valueOf(rolePermission.getModificationDate()));
            statement.setInt(4, permissionId);
            statement.setInt(5, roleId);
            return statement;
        }, holder);
        return holder.getKey().intValue();
    }

    @Override
    public List<RolePermission> getAllRolePermission() {
        return jdbcTemplate.query(GET_ALL_ROLE_PERMISSION, new BeanPropertyRowMapper<>(RolePermission.class));
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
