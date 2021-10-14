package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Permission;

import java.util.List;

public interface PermissionDao {
    Permission addPermission(Permission permission);

    List<Permission> getAllPermission();

    Permission getPermissionById(int id);
}
