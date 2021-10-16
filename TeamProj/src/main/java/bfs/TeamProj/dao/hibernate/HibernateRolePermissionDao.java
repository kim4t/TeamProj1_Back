package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.RolePermissionDao;
import bfs.TeamProj.domain.RolePermission;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HibernateRolePermissionDao extends AbstractHibernateDAO<RolePermission> implements RolePermissionDao {
    public HibernateRolePermissionDao() {
        setClazz(RolePermission.class);
    }

    @Override
    public RolePermission addRolePermission(RolePermission rolePermission) {
        return create(rolePermission);
    }

    @Override
    public List<RolePermission> getAllRolePermission() {
        return findAll();
    }

    @Override
    public RolePermission getRolePermissionById(int id) {
        return findById(id);
    }
}
