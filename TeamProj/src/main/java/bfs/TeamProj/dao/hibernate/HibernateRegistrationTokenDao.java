package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.RegistrationTokenDao;
import bfs.TeamProj.domain.RegistrationToken;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class HibernateRegistrationTokenDao extends AbstractHibernateDAO<RegistrationToken> implements RegistrationTokenDao {

   public HibernateRegistrationTokenDao() {setClazz(RegistrationToken.class);}
    @Override
    public Integer addRegistrationToken(RegistrationToken token) {
        return null;
    }

    @Override
    public RegistrationToken getRegistrationTokenByToken(String name) {
        return findByField("token", name);
    }

    @Override
    public List<RegistrationToken> getAllRegistrationToken() {
        return findAll();
    }
}
