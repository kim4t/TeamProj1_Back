package bfs.TeamProj.dao.hibernate;

import bfs.TeamProj.dao.AbstractHibernateDAO;
import bfs.TeamProj.dao.AddressDao;
import bfs.TeamProj.domain.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HibernateAddressDao extends AbstractHibernateDAO<Address> implements AddressDao {
    public HibernateAddressDao() {
        setClazz(Address.class);
    }

    @Override
    public Address addAddress(Address address) {
        return create(address);
    }

    @Override
    public List<Address> getAllAddress() {
        return findAll();
    }

    @Override
    public Address getAddressById(int id) {
        return findById(id);
    }

    @Override
    public Address getAddressByPersonId(int personId) {
        return findByField("personId", personId);
    }
}
