package bfs.TeamProj.Service;

import bfs.TeamProj.dao.AddressDao;
import bfs.TeamProj.domain.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
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

    @Transactional
    public Address updateAddress(Address address) {
        return addressDao.updateAddress(address);
    }

    @Async("taskExecutor")
    @Transactional
    public CompletableFuture<List<Address>> getAllAddressAsync(){
        System.out.println("in address service");
        return CompletableFuture.completedFuture(addressDao.getAllAddress());
    }

}
