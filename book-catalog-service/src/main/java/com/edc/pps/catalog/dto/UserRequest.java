package com.edc.pps.catalog.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class UserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private List<CatalogItem> catalogItems;
}