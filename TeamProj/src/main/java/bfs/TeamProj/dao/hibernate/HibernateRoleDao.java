package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.RoleDao;
import bfs.TeamProj.domain.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateRoleDao extends AbstractHibernateDAO<Role> implements RoleDao {
    public HibernateRoleDao() {
        setClazz(Role.class);
    }

    @Override
    public List<Role> getAllRole() {
        return findAll();
    }

    @Override
    public Role getRoleById(int id) {
        return findById(id);
    }

    @Override
    public Role addRole(Role role) {
        return create(role);
    }
}
