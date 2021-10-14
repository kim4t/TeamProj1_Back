package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.UserDao;
import bfs.TeamProj.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUserDao extends AbstractHibernateDAO<User> implements UserDao {
    public HibernateUserDao() {
        setClazz(User.class);
    }

    @Override
    public User getUserById(int id) {
        return findById(id);
    }

    public User getUserByEmail(String email){
        return findByField("email", email);
    }

    @Override
    public User addUser(User user) {
        return create(user);
    }
}
