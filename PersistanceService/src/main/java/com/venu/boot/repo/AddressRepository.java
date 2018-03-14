package com.venu.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venu.boot.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	
}
