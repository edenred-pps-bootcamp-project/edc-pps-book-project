package com.edc.pps.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edc.pps.catalog.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);


}
