package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void givenUser_whenCreate_thenReturnUser(){
        // given
        String firstName = "first name";
        String lastName = "last name";
        String userName = "username";
        Long id = 0L;
        User user = new User(id,firstName,lastName,userName);

        // when
        UserResponse actualUser = userService.save(user);

        // then
        assertThat(actualUser.getId()).isNotNull();
    }

}