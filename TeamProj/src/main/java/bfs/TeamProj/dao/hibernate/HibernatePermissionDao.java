package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.PermissionDao;
import bfs.TeamProj.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernatePermissionDao extends AbstractHibernateDAO<Permission> implements PermissionDao {
    public HibernatePermissionDao() {
        setClazz(Permission.class);
    }

    @Override
    public Permission addPermission(Permission permission) {
        return create(permission);
    }

    @Override
    public List<Permission> getAllPermission() {
        return findAll();
    }

    @Override
    public Permission getPermissionById(int id) {
        return findById(id);
    }


}
