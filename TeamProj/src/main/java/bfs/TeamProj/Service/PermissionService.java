package bfs.TeamProj.Service;

import bfs.TeamProj.dao.PermissionDao;
import bfs.TeamProj.domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Transactional
    public Integer addPermission(Permission permission) {
        return permissionDao.addPermission(permission);
    }

    @Transactional
    public List<Permission> getAllSampleDocument() {
        return permissionDao.getAllPermission();
    }
}

