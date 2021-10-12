package bfs.TeamProj.dao;

import bfs.TeamProj.domain.UserRole;

import java.util.List;

public interface UserRoleDao {
    Integer addUserRole(UserRole userRole, int userId, int roleId);

    List<UserRole> getAllUserRole();
}
