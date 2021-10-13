package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PermissionDao;
import bfs.TeamProj.dao.RoleDao;
import bfs.TeamProj.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionService {
    private PermissionDao permissionDao;

    @Transactional
    public Integer addPermission(Permission permission) {
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

    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
}

