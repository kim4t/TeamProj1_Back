package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Address;

import java.util.List;

public interface AddressDao {
    Integer addAddress(Address address, int personId);

    List<Address> getAllAddress();
}
