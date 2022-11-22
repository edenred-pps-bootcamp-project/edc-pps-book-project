package com.edc.pps.catalog.model;

import com.edc.pps.catalog.dto.CatalogItem;

import java.security.InvalidParameterException;
import java.util.List;

// TODO: (cosmin bucur) transform to entity
public class User implements Comparable<User>{
    private static Long countId = 0L;

    {
        countId++;
    }

    private  Long userId;

    private String firstName;
    private String lastName;
    private String userName;

    private List<CatalogItem> catalogItems;

    public User() {
    }

    public User(String firstName, String lastName, String userName) {
        this.userId = countId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<CatalogItem> getCatalogItems() {
        return catalogItems;
    }

    @Override
    public String toString() {
        return this.userName.charAt(this.userName.length()-1) != 's' ? "User " + this.userName + "'s full name: " +
                this.firstName + " " + this.lastName :
                "User " + this.userName + "' full name: " +
                        this.firstName + " " + this.lastName;
    }

    @Override
    public int compareTo(User other) {
        return (int) (this.userId - other.getUserId());
    }

}
