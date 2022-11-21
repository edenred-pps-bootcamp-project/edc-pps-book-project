package com.edc.pps.catalog.repository;

import com.edc.pps.catalog.model.User;

import java.util.HashSet;
import java.util.Set;

public class InMemoryCatalogRepository implements CatalogRepository{

    Set<User> userList = new HashSet<>();

    @Override
    public Set<User> getUsers() {
        return userList;
    }
}
