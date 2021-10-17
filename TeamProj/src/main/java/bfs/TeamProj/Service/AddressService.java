package bfs.TeamProj.Service;

import bfs.TeamProj.dao.AddressDao;
import bfs.TeamProj.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressDao addressDao;

    @Transactional
    public Address addAddress(Address address) {
        return addressDao.addAddress(address);
    }

    @Transactional
    public List<Address> getAllAddress() {
        return addressDao.getAllAddress();
    }

    @Transactional
    public Address getAddressById(int id) {
        return addressDao.getAddressById(id);
    }

    @Transactional
    public Address getAddressByPersonId(int personId) {
        return addressDao.getAddressByPersonId(personId);
    }
}
