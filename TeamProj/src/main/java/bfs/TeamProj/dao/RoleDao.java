package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> getAllRole();

    Role getRoleById(int id);

    Integer addRole(Role role);
}
