package com.edc.pps.catalog.model;

import com.edc.pps.catalog.dto.CatalogItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "user_name")
    private String userName;
    @ElementCollection
    @CollectionTable(name = "catalog_items", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "catalog_items")
    private List<CatalogItem> catalogItems = new ArrayList<>();

    public User() {
    }

    public User(long userId, String firstName, String lastName, String userName) {
        this.userId = userId;
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


    public void setCatalogItems(List<CatalogItem> catalogItems) {
        this.catalogItems = new ArrayList<>(catalogItems);
    }

    @Override
    public String toString() {
        return this.userName.charAt(this.userName.length() - 1) != 's' ? "User " + this.userName + "'s full name: " +
                this.firstName + " " + this.lastName :
                "User " + this.userName + "' full name: " +
                        this.firstName + " " + this.lastName;

    }

}
