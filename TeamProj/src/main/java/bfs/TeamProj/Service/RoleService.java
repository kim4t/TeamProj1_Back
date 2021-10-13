package bfs.TeamProj.Service;


import bfs.TeamProj.dao.RoleDao;
import bfs.TeamProj.domain.Permission;
import bfs.TeamProj.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleService {
    private RoleDao roleDao;

    @Transactional
    public Integer addRole(Role role) {
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
    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
