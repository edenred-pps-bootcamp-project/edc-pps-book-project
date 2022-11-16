package com.edc.pps.catalogue.repository;

import com.edc.pps.catalogue.model.User;

import java.util.HashSet;
import java.util.Set;

public class InMemoryCatalogRepository implements CatalogRepository{

    Set<User> userList = new HashSet<>();

    @Override
    public Set<User> getUsers() {
        return userList;
    }
}
