package com.edc.pps.catalogue.repository;

import com.edc.pps.catalogue.model.User;

import java.util.HashSet;
import java.util.Set;

public interface CatalogRepository {


    Set<User> getUsers();


}
