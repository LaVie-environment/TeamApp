package cz.mendelu.dao;

import cz.mendelu.dao.domain.Address;

import java.util.List;

public interface AddressDAO {
    List<Address> findAll();
    Address findById(int id);
    void save(Address address);
    void delete(Address address);
}
