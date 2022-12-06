package com.edc.pps.catalog.model;

import com.edc.pps.catalog.dto.CatalogItem;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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


    /*
    public User(Long userId, String firstName, String lastName, String userName) {
        this.id = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;

    }*/

    @Override
    public String toString() {
        return this.userName.charAt(this.userName.length() - 1) != 's' ? "User " + this.userName + "'s full name: " +
                this.firstName + " " + this.lastName :
                "User " + this.userName + "' full name: " +
                        this.firstName + " " + this.lastName;

    }

}
