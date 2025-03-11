package com.address.repository;

import com.address.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressRepo extends CrudRepository<Address, Long> {

    List<Address> findAddressByCity(String city);
}
