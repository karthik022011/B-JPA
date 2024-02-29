package com.learning.transactionmanagement.repository;

import com.learning.transactionmanagement.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
