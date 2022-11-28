package com.edc.pps.catalog.service;

import com.edc.pps.catalog.dto.CatalogItem;
import com.edc.pps.catalog.dto.UserRequest;
import com.edc.pps.catalog.dto.UserResponse;
import com.edc.pps.catalog.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void givenUser_whenCreate_thenReturnUserResponse(){
        // given

        List<CatalogItem> catalogItems = new ArrayList<>();

        UserRequest userRequest = new UserRequest();

        userRequest.setFirstName("Popescu");
        userRequest.setLastName("Andrei");
        userRequest.setUserName("andreip");
        userRequest.setCatalogItems(catalogItems);

        // when
        UserResponse actualUser = userService.save(userRequest);

        // then
        assertThat(actualUser.getId()).isNotNull();

    }

}