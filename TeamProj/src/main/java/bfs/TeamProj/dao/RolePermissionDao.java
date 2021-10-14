package bfs.TeamProj.dao;

import bfs.TeamProj.domain.RolePermission;

import java.util.List;

public interface RolePermissionDao {
    RolePermission addRolePermission (RolePermission rolePermission);

    List<RolePermission> getAllRolePermission();

    RolePermission getRolePermissionById(int id);
}
