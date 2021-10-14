package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.UserRoleDao;
import bfs.TeamProj.domain.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class HibernateUserRoleDao extends AbstractHibernateDAO<UserRole> implements UserRoleDao {
    public HibernateUserRoleDao() {
        setClazz(UserRole.class);
    }

    @Override
    public UserRole addUserRole(UserRole userRole) {
        return create(userRole);
    }

    @Override
    public List<UserRole> getAllUserRole() {
        return findAll();
    }
}
