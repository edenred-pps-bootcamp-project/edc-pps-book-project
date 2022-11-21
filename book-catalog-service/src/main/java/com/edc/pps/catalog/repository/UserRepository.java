package com.edc.pps.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edc.pps.catalog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
