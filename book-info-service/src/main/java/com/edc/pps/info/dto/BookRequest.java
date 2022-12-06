package com.edc.pps.info.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
public class BookRequest {

    private String title;

    private String author;


}
