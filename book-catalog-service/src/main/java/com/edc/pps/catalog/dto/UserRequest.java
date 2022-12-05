package com.edc.pps.catalog.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@EqualsAndHashCode
public class UserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private List<CatalogItem> catalogItems;
}