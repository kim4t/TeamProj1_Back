package bfs.TeamProj.dao;

import bfs.TeamProj.domain.Address;

import java.util.List;

public interface AddressDao {
    Address addAddress(Address address);

    List<Address> getAllAddress();

    Address getAddressById(int id);

    Address getAddressByPersonId(int personId);

    Address updateAddress(Address address);
}
