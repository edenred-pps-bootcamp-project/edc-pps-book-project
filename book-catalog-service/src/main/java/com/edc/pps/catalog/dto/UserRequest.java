package com.edc.pps.catalog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private List<CatalogItem> catalogItems;
}