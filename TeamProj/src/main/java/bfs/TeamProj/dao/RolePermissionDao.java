package bfs.TeamProj.dao;

import bfs.TeamProj.domain.RolePermission;

import java.util.List;

public interface RolePermissionDao {
    Integer addRolePermission (RolePermission rolePermission, int permissionId, int roleId);

    List<RolePermission> getAllRolePermission();
}
