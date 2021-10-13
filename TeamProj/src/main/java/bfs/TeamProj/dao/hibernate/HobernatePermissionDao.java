package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.PermissionDao;
import bfs.TeamProj.domain.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HobernatePermissionDao extends AbstractHibernateDAO<Permission> implements PermissionDao {
    public HobernatePermissionDao() {
        setClazz(Permission.class);
    }

    @Override
    public Integer addPermission(Permission permission) {
        return create(permission).getId();
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
