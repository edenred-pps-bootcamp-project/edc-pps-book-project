package com.edc.pps.catalog.service;

import com.edc.pps.catalog.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private static final UserService userService = UserService.getInstance();

    @BeforeAll
    static void beforeAll() {
        UserService userService = UserService.getInstance();
    }

    @Test
    void givenUser_whenCreate_thenReturnUser(){
        // given
        String firstName = "first name";
        String lastName = "last name";
        String userName = "username";
        User user = new User(firstName,lastName,userName);

        // when
        User actualUser = userService.create(user);

        // then
        assertThat(actualUser.getUserId()).isNotNull();
    }

    @Test
    void givenUserParams_whenCreateExplicit_thenReturnUser(){
        // given
        String firstName = "first name";
        String lastName = "last name";
        String userName = "username";


        // when
        User actualUser = userService.createExplicit(firstName, lastName, userName);

        // then
        assertThat(actualUser.getUserId()).isNotNull();
    }

}