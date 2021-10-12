package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Permission;

import java.util.List;

public interface PermissionDao {
    Integer addPermission(Permission permission);

    List<Permission> getAllPermission();
}
