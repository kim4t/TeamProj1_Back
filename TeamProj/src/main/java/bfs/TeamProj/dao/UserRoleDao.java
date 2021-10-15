package bfs.TeamProj.dao;

import bfs.TeamProj.domain.UserRole;

import java.util.List;

public interface UserRoleDao {
    UserRole addUserRole(UserRole userRole);

    UserRole getUserRoleById(int id);

    List<UserRole> getAllUserRole();
}
