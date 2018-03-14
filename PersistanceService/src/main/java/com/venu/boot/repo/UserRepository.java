package com.venu.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venu.boot.entity.UserDetails;


public interface UserRepository extends JpaRepository<UserDetails, Long> {

	UserDetails findByName(String name);
}
