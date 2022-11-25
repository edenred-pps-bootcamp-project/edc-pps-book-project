package com.edc.pps.catalog.dto;


import java.util.List;

public class UserResponseList {

    private List<UserResponse> userResponses;

    public List<UserResponse> getUserResponses(){
        return userResponses;
    }

    public void setUserResponses(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }

}
