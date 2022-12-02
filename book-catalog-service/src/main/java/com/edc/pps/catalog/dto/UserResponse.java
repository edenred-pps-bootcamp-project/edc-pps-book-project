package com.edc.pps.catalog.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class UserResponse implements Serializable {

    private  Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private List<CatalogItem> catalogItems;
}
