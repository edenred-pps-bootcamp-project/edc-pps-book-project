package com.edc.pps.catalogue.model;

import java.security.InvalidParameterException;

public class User implements Comparable{
    private static Long countId = 0L;

    {
        countId++;
    }
    private  Long userId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String firstName;
    private String lastName;
    private String userName;

    public User() throws InvalidParameterException {
        throw new InvalidParameterException("Provide valid parameters to the constructor");
    }

    public User(String firstName, String lastName, String userName) {
        this.userId = countId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    private Long getUserId() {
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

    @Override
    public String toString() {
        return this.userName.charAt(-1) != 's' ? "User " + this.userName + "'s full name: " +
                this.firstName + " " + this.lastName :
                "User " + this.userName + "' full name: " +
                        this.firstName + " " + this.lastName;

    }

    @Override
    public int compareTo(Object other) {
        User otherUser = (User) other;
        return (int) (this.userId - otherUser.getUserId());
    }


}
