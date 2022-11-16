package com.edc.pps.catalog.repository;

import com.edc.pps.catalog.model.User;

import java.util.Set;

public interface CatalogRepository {

    Set<User> getUsers();


}
