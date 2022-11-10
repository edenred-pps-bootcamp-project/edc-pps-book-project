package com.edc.pps.model;

import java.security.InvalidParameterException;

public class User {
    private static Long userId = 0L;

    private String firstName;
    private String lastName;

    static{
        userId++;
    }

    public User() throws InvalidParameterException {
        throw new InvalidParameterException("Provide valid parameters to the constructor");
    }

    public User(String firstName, String lastName) {
        // increment static id
        this.firstName = firstName;
        this.lastName = lastName;
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
}
