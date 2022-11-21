package com.edc.pps.catalog.repository;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.model.User;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CatalogItem, Long> {

    Set<User> getUsers();

}
