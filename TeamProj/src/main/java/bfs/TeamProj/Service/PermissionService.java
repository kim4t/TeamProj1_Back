package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PermissionDao;
import bfs.TeamProj.dao.RoleDao;
import bfs.TeamProj.dao.RolePermissionDao;
import bfs.TeamProj.domain.Permission;
import bfs.TeamProj.domain.RolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionService {
    private PermissionDao permissionDao;
    private RolePermissionDao rolePermissionDao;

    @Transactional
    public Permission addPermission(Permission permission) {
        return permissionDao.addPermission(permission);
    }

    @Transactional
    public List<Permission> getAllPermission() {
        return permissionDao.getAllPermission();
    }

    @Transactional
    public Permission getPermissionById(int id) {
        return permissionDao.getPermissionById(id);
    }

    @Transactional
    public RolePermission addRolePermission(RolePermission rolePermission){
        return rolePermissionDao.addRolePermission(rolePermission);
    }
    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Autowired
    public void setRolePermissionDao(RolePermissionDao rolePermissionDao){
        this.rolePermissionDao = rolePermissionDao;
    }
}

