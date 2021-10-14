package bfs.TeamProj.Service;


import bfs.TeamProj.dao.RoleDao;
import bfs.TeamProj.dao.UserRoleDao;
import bfs.TeamProj.domain.Role;
import bfs.TeamProj.domain.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    private RoleDao roleDao;
    private UserRoleDao userRoleDao;

    @Transactional
    public Role addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Transactional
    public List<Role> getAllRole() {
        return roleDao.getAllRole();
    }

    @Transactional
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }

    @Transactional
    public Role getRoleByName(String name) {
        return roleDao.getRoleByName(name);
    }

    @Transactional
    public UserRole addUserRole(UserRole userRole) {
        return userRoleDao.addUserRole(userRole);
    }


    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    @Autowired
    public void setUserRoleDao(UserRoleDao userRoleDao) {
        this.userRoleDao = userRoleDao;
    }
}
